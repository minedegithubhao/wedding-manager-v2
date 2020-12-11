package com.qh.venus.achilles.sms.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.qh.venus.achilles.sms.system.domain.SysUserRole;


/**
 * @Title: 用户表 数据层
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public interface SysUserRoleMapper {
	/**
	 * 通过用户ID删除用户和角色关联
	 * 
	 * @param userId
	 *            用户ID
	 * @return 结果
	 */
	public int deleteUserRoleByUserId(Long userId);

	/**
	 * 批量删除用户和角色关联
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteUserRole(Long[] ids);

	/**
	 * 通过角色ID查询角色使用数量
	 * 
	 * @param roleId
	 *            角色ID
	 * @return 结果
	 */
	public int countUserRoleByRoleId(Long roleId);

	/**
	 * 批量新增用户角色信息
	 * 
	 * @param userRoleList
	 *            用户角色列表
	 * @return 结果
	 */
	public int batchUserRole(List<SysUserRole> userRoleList);

	/**
	 * 删除用户和角色关联信息
	 * 
	 * @param userRole
	 *            用户和角色关联信息
	 * @return 结果
	 */
	public int deleteUserRoleInfo(SysUserRole userRole);

	/**
	 * 批量取消授权用户角色
	 * 
	 * @param roleId
	 *            角色ID
	 * @param userIds
	 *            需要删除的用户数据ID
	 * @return 结果
	 */
	public int deleteUserRoleInfos(@Param("roleId") Long roleId, @Param("userIds") Long[] userIds);
}
