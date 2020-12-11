package com.qh.venus.achilles.sms.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.framework.auth.annotation.HasPermissions;
import com.qh.venus.achilles.framework.log.annotation.OperLog;
import com.qh.venus.achilles.framework.log.enums.BusinessType;
import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.sms.system.domain.SysRole;
import com.qh.venus.achilles.sms.system.service.ISysRoleService;


/**
 * @Title: 角色 提供者
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/system/role")
public class SysRoleController extends BaseController {
	@Autowired
	private ISysRoleService sysRoleService;

	/**
	 * 查询角色
	 */
	@GetMapping("get/{roleId}")
	public SysRole get(@PathVariable("roleId") Long roleId) {
		return sysRoleService.selectRoleById(roleId);
	}

	/**
	 * 查询角色列表
	 */
	@GetMapping("list")
	public R list(SysRole sysRole) {
		startPage();
		return result(sysRoleService.selectRoleList(sysRole));
	}

	@GetMapping("all")
	public R all() {
		return R.ok().put("rows", sysRoleService.selectRoleAll());
	}

	/**
	 * 新增保存角色
	 */
	@PostMapping("save")
	@OperLog(title = "角色管理", businessType = BusinessType.INSERT)
	public R addSave(@RequestBody SysRole sysRole) {
		return toAjax(sysRoleService.insertRole(sysRole));
	}

	/**
	 * 修改保存角色
	 */
	@OperLog(title = "角色管理", businessType = BusinessType.UPDATE)
	@PostMapping("update")
	public R editSave(@RequestBody SysRole sysRole) {
		return toAjax(sysRoleService.updateRole(sysRole));
	}

	/**
	 * 修改保存角色
	 */
	@OperLog(title = "角色管理", businessType = BusinessType.UPDATE)
	@PostMapping("status")
	public R status(@RequestBody SysRole sysRole) {
		return toAjax(sysRoleService.changeStatus(sysRole));
	}

	/**
	 * 保存角色分配数据权限
	 */
	@HasPermissions("system:role:edit")
	@OperLog(title = "角色管理", businessType = BusinessType.UPDATE)
	@PostMapping("/authDataScope")
	public R authDataScopeSave(@RequestBody SysRole role) {
		role.setUpdateBy(getLoginName());
		if (sysRoleService.authDataScope(role) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除角色
	 * 
	 * @throws Exception
	 */
	@OperLog(title = "角色管理", businessType = BusinessType.DELETE)
	@PostMapping("remove")
	public R remove(String ids) throws Exception {
		return toAjax(sysRoleService.deleteRoleByIds(ids));
	}
}
