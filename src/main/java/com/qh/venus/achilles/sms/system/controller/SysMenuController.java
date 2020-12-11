package com.qh.venus.achilles.sms.system.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.framework.aspectj.lang.annotation.LoginUser;
import com.qh.venus.achilles.framework.auth.annotation.HasPermissions;
import com.qh.venus.achilles.framework.log.annotation.OperLog;
import com.qh.venus.achilles.framework.log.enums.BusinessType;
import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.sms.system.domain.SysMenu;
import com.qh.venus.achilles.sms.system.domain.SysUser;
import com.qh.venus.achilles.sms.system.service.ISysMenuService;


/**
 * @Title: 菜单权限
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/system/menu")
public class SysMenuController extends BaseController {
	@Autowired
	private ISysMenuService sysMenuService;

	/**
	 * 查询菜单权限
	 */
	@GetMapping("get/{menuId}")
	public SysMenu get(@PathVariable("menuId") Long menuId) {
		return sysMenuService.selectMenuById(menuId);
	}

	@GetMapping("perms/{userId}")
	public Set<String> perms(@PathVariable("userId") Long userId) {
		return sysMenuService.selectPermsByUserId(userId);
	}

	/**
	 * 查询菜单权限
	 */
	@GetMapping("user")
	public Map<Long, List<SysMenu>> user(@LoginUser SysUser sysUser) {

		return sysMenuService.selectMenusByUser(sysUser);
	}

	/**
	 * 根据角色编号查询菜单编号（用于勾选）
	 * 
	 * @param roleId
	 * @return
	 * @author zmr
	 */
	@GetMapping("role/{roleId}")
	public List<SysMenu> role(@PathVariable("roleId") Long roleId) {
		if (null == roleId || roleId <= 0)
			return null;
		return sysMenuService.selectMenuIdsByRoleId(roleId);
	}
	/**
	 * 根据顶部菜单主键查询菜单编号（用于勾选）
	 *
	 * @param topMenuId
	 * @return
	 * @author zmr
	 */
	@GetMapping("topMenu/{topMenuId}")
	public List<SysMenu> topMenu(@PathVariable("topMenuId") Long topMenuId) {
		if (null == topMenuId || topMenuId <= 0)
			return null;
		return sysMenuService.selectMenuIdsByTopMenuId(topMenuId);
	}

	/**
	 * 查询菜单权限列表
	 */
	//@HasPermissions("system:menu:view")
	@GetMapping("list")
	public R list(SysMenu sysMenu) {
		return result(sysMenuService.selectMenuList(sysMenu));
	}

	/**
	 * 新增保存菜单权限
	 */
	@PostMapping("save")
	@OperLog(title = "菜单管理", businessType = BusinessType.INSERT)
	public R addSave(@RequestBody SysMenu sysMenu) {
		return toAjax(sysMenuService.insertMenu(sysMenu));
	}

	/**
	 * 修改保存菜单权限
	 */
	@OperLog(title = "菜单管理", businessType = BusinessType.UPDATE)
	@PostMapping("update")
	public R editSave(@RequestBody SysMenu sysMenu) {
		return toAjax(sysMenuService.updateMenu(sysMenu));
	}

	/**
	 * 删除菜单权限
	 */
	@OperLog(title = "菜单管理", businessType = BusinessType.DELETE)
	@PostMapping("remove/{menuId}")
	public R remove(@PathVariable("menuId") Long menuId) {
		return toAjax(sysMenuService.deleteMenuById(menuId));
	}
}
