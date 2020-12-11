package com.qh.venus.achilles.sms.system.mapper;

import java.util.List;

import com.qh.venus.achilles.sms.system.domain.SysUserPost;


/**
 * @Title: 用户与岗位 表 数据层
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public interface SysUserPostMapper {
	/**
	 * 通过用户ID删除用户和岗位关联
	 * 
	 * @param userId
	 *            用户ID
	 * @return 结果
	 */
	public int deleteUserPostByUserId(Long userId);

	/**
	 * 通过岗位ID查询岗位使用数量
	 * 
	 * @param postId
	 *            岗位ID
	 * @return 结果
	 */
	public int countUserPostById(Long postId);

	/**
	 * 批量删除用户和岗位关联
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteUserPost(Long[] ids);

	/**
	 * 批量新增用户岗位信息
	 * 
	 * @param userPostList
	 *            用户角色列表
	 * @return 结果
	 */
	public int batchUserPost(List<SysUserPost> userPostList);
}
