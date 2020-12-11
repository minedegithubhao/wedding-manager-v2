package com.qh.venus.achilles.sms.system.controller;

import java.util.Set;

import com.qh.venus.achilles.common.constant.Constants;
import com.qh.venus.achilles.common.exception.CustomException;
import com.qh.venus.achilles.common.exception.user.UserException;
import com.qh.venus.achilles.common.exception.user.UserPasswordNotMatchException;
import com.qh.venus.achilles.common.utils.MessageUtils;
import com.qh.venus.achilles.common.utils.StringUtils;
import com.qh.venus.achilles.framework.manager.AsyncManager;
import com.qh.venus.achilles.framework.manager.factory.AsyncFactory;
import com.qh.venus.achilles.framework.security.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.qh.venus.achilles.common.constant.UserConstants;
import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.common.utils.PasswordUtil;
import com.qh.venus.achilles.common.utils.RandomUtil;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.LoginUser;
import com.qh.venus.achilles.framework.auth.annotation.HasPermissions;
import com.qh.venus.achilles.framework.log.annotation.OperLog;
import com.qh.venus.achilles.framework.log.enums.BusinessType;
import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.sms.system.domain.SysUser;
import com.qh.venus.achilles.sms.system.service.ISysMenuService;
import com.qh.venus.achilles.sms.system.service.ISysUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * @Title: 用户 提供者
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {
	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ISysMenuService sysMenuService;

	@Resource
	private AuthenticationManager authenticationManager;
	/**
	 * 查询用户
	 */
	@GetMapping("get/{userId}")
	public SysUser get(@PathVariable("userId") Long userId) {
		return sysUserService.selectUserById(userId);
	}

	@GetMapping("info")
	public SysUser info(@LoginUser SysUser sysUser) {
		sysUser.setButtons(sysMenuService.selectPermsByUserId(sysUser.getUserId()));
		return sysUser;
	}

	/**
	 * 查询用户
	 */
	@GetMapping("find/{username}")
	public SysUser findByUsername(@PathVariable("username") String username) {
		return sysUserService.selectUserByLoginName(username);
	}

	/**
	 * 查询拥有当前角色的所有用户
	 */
	@GetMapping("hasRoles")
	public Set<Long> hasRoles(String roleIds) {
		Long[] arr = Convert.toLongArray(roleIds);
		return sysUserService.selectUserIdsHasRoles(arr);
	}

	/**
	 * 查询所有当前部门中的用户
	 */
	@GetMapping("inDepts")
	public Set<Long> inDept(String deptIds) {
		Long[] arr = Convert.toLongArray(deptIds);
		return sysUserService.selectUserIdsInDepts(arr);
	}

	/**
	 * 查询用户列表
	 */
	@GetMapping("list")
	public R list(SysUser sysUser) {
		startPage();
		return result(sysUserService.selectUserList(sysUser));
	}

	/**
	 * 新增保存用户
	 */
	@HasPermissions("system:user:add")
	@PostMapping("save")
	@OperLog(title = "用户管理", businessType = BusinessType.INSERT)
	public R addSave(@RequestBody SysUser sysUser) {
		if (UserConstants.USER_NAME_NOT_UNIQUE.equals(sysUserService.checkLoginNameUnique(sysUser.getLoginName()))) {
			return R.error("新增用户'" + sysUser.getLoginName() + "'失败，登录账号已存在");
		} else if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(sysUserService.checkPhoneUnique(sysUser))) {
			return R.error("新增用户'" + sysUser.getLoginName() + "'失败，手机号码已存在");
		} else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(sysUserService.checkEmailUnique(sysUser))) {
			return R.error("新增用户'" + sysUser.getLoginName() + "'失败，邮箱账号已存在");
		}
		sysUser.setSalt(RandomUtil.randomStr(6));
		sysUser.setPassword(
				PasswordUtil.defaultPassword(sysUser.getLoginName(), sysUser.getPassword()));
		sysUser.setCreateBy(getLoginName());
		return toAjax(sysUserService.insertUser(sysUser));
	}

	/**
	 * 修改保存用户
	 */
	@HasPermissions("system:user:edit")
	@OperLog(title = "用户管理", businessType = BusinessType.UPDATE)
	@PostMapping("update")
	public R editSave(@RequestBody SysUser sysUser) {
		if (null != sysUser.getUserId() && SysUser.isAdmin(sysUser.getUserId())) {
			return R.error("不允许修改超级管理员用户");
		} else if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(sysUserService.checkPhoneUnique(sysUser))) {
			return R.error("修改用户'" + sysUser.getLoginName() + "'失败，手机号码已存在");
		} else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(sysUserService.checkEmailUnique(sysUser))) {
			return R.error("修改用户'" + sysUser.getLoginName() + "'失败，邮箱账号已存在");
		}
		return toAjax(sysUserService.updateUser(sysUser));
	}

	/**
	 * 修改用户信息
	 * 
	 * @param sysUser
	 * @return
	 * @author zmr
	 */
	@HasPermissions("system:user:edit")
	@PostMapping("update/info")
	@OperLog(title = "用户管理", businessType = BusinessType.UPDATE)
	public R updateInfo(@RequestBody SysUser sysUser) {
		return toAjax(sysUserService.updateUserInfo(sysUser));
	}

	/**
	 * 记录登陆信息
	 * 
	 * @param sysUser
	 * @return
	 * @author zmr
	 */
	@PostMapping("update/login")
	public R updateLoginRecord(@RequestBody SysUser sysUser) {
		return toAjax(sysUserService.updateUser(sysUser));
	}

	@HasPermissions("system:user:resetPwd")
	@OperLog(title = "重置密码", businessType = BusinessType.UPDATE)
	@PostMapping("/resetPwd")
	public R resetPwdSave(@RequestBody SysUser user) {
		user.setSalt(RandomUtil.randomStr(6));
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return toAjax(sysUserService.resetUserPwd(user));
	}

	@HasPermissions("system:user:edit")
	@OperLog(title = "修改密码", businessType = BusinessType.UPDATE)
	@PostMapping("/updatePwd")
	@ResponseBody
	public R updatePwdSave(@RequestBody SysUser user) {
		R result = new R();
		if(StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getOldPassword())){
			return result.error("修改失败,缺少必要参数");
		}
		// 用户验证
		Authentication authentication = null;
		try {
			// 该方法会去调用UserDetailsServiceImpl.loadUserByUsername

			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getOldPassword()));
		} catch (Exception e) {
			if (e instanceof BadCredentialsException) {
				AsyncManager.me().execute(AsyncFactory.recordLogininfor(user.getUserName(), Constants.FAIL,
						MessageUtils.message("user.password.error")));
				throw new UserException("user.password.error", null);
			} else {
				AsyncManager.me()
						.execute(AsyncFactory.recordLogininfor(user.getUserName(), Constants.FAIL, e.getMessage()));
				throw new CustomException(e.getMessage());
			}
		}
		AuthUser loginUser = (AuthUser) authentication.getPrincipal();
		SysUser newUser = new SysUser();
		newUser.setUserId(loginUser.getUser().getUserId());
		newUser.setSalt(RandomUtil.randomStr(6));
		newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return toAjax(sysUserService.resetUserPwd(newUser));
	}

	/**
	 * 修改状态
	 * 
	 * @param sysUser
	 * @return
	 * @author zmr
	 */
	@HasPermissions("system:user:edit")
	@PostMapping("status")
	@OperLog(title = "用户管理", businessType = BusinessType.UPDATE)
	public R status(@RequestBody SysUser sysUser) {
		return toAjax(sysUserService.changeStatus(sysUser));
	}

	/**
	 * 删除用户
	 * 
	 * @throws Exception
	 */
	@HasPermissions("system:user:remove")
	@OperLog(title = "用户管理", businessType = BusinessType.DELETE)
	@PostMapping("remove")
	public R remove(String ids) throws Exception {
		return toAjax(sysUserService.deleteUserByIds(ids));
	}
}
