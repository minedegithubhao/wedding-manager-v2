package com.qh.venus.achilles.sms.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qh.venus.achilles.framework.web.domain.Ztree;
import com.qh.venus.achilles.sms.system.domain.SysMenu;
import com.qh.venus.achilles.sms.system.domain.SysRole;
import com.qh.venus.achilles.sms.system.domain.SysUser;


/**
 * @Title:菜单 业务层
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public interface ISysMenuService {
	
	  /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectMenuPermsByUserId(Long userId);

	/**
	 * 根据用户ID查询菜单
	 * 
	 * @param user
	 *            用户信息
     * @return 菜单列表
	 */
	public Map<Long, List<SysMenu>> selectMenusByUser(SysUser user);

	/**
	 * 查询系统菜单列表
	 * 
	 * @param menu
	 *            菜单信息
	 * @return 菜单列表
	 */
	public List<SysMenu> selectMenuList(SysMenu menu);

	/**
	 * 查询菜单集合
	 * 
	 * @return 所有菜单信息
	 */
	public List<SysMenu> selectMenuAll();

	/**
	 * 根据用户ID查询权限
	 * 
	 * @param userId
	 *            用户ID
	 * @return 权限列表
	 */
	public Set<String> selectPermsByUserId(Long userId);

	/**
	 * 根据角色ID查询菜单ID
	 * 
	 * @param roleId
	 *            角色ID
	 * @return 权限列表
	 */
	public List<SysMenu> selectMenuIdsByRoleId(Long roleId);

	/**
	 * 根据顶部菜单主键查询菜单编号
	 *
	 * @param topMenuId
	 *            顶部菜单ID
	 * @return 权限列表
	 */
	public List<SysMenu> selectMenuIdsByTopMenuId(Long topMenuId);

	/**
	 * 根据角色ID查询菜单
	 * 
	 * @param role
	 *            角色对象
	 * @return 菜单列表
	 */
	public List<Ztree> roleMenuTreeData(SysRole role);

	/**
	 * 查询所有菜单信息
	 * 
	 * @return 菜单列表
	 */
	public List<Ztree> menuTreeData();

	/**
	 * 查询系统所有权限
	 * 
	 * @return 权限列表
	 */
	public Map<String, String> selectPermsAll();

	/**
	 * 删除菜单管理信息
	 * 
	 * @param menuId
	 *            菜单ID
	 * @return 结果
	 */
	public int deleteMenuById(Long menuId);

	/**
	 * 根据菜单ID查询信息
	 * 
	 * @param menuId
	 *            菜单ID
	 * @return 菜单信息
	 */
	public SysMenu selectMenuById(Long menuId);

	/**
	 * 查询菜单数量
	 * 
	 * @param parentId
	 *            菜单父ID
	 * @return 结果
	 */
	public int selectCountMenuByParentId(Long parentId);

	/**
	 * 查询菜单使用数量
	 * 
	 * @param menuId
	 *            菜单ID
	 * @return 结果
	 */
	public int selectCountRoleMenuByMenuId(Long menuId);

	/**
	 * 新增保存菜单信息
	 * 
	 * @param menu
	 *            菜单信息
	 * @return 结果
	 */
	public int insertMenu(SysMenu menu);

	/**
	 * 修改保存菜单信息
	 * 
	 * @param menu
	 *            菜单信息
	 * @return 结果
	 */
	public int updateMenu(SysMenu menu);

	/**
	 * 校验菜单名称是否唯一
	 * 
	 * @param menu
	 *            菜单信息
	 * @return 结果
	 */
	public String checkMenuNameUnique(SysMenu menu);
}
