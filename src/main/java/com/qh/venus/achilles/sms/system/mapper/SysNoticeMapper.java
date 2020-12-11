package com.qh.venus.achilles.sms.system.mapper;

import java.util.List;

import com.qh.venus.achilles.sms.system.domain.SysNotice;


/**
 * @Title: 公告 数据层
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public interface SysNoticeMapper {
	/**
	 * 查询公告信息
	 * 
	 * @param noticeId
	 *            公告ID
	 * @return 公告信息
	 */
	public SysNotice selectNoticeById(Long noticeId);

	/**
	 * 查询公告列表
	 * 
	 * @param notice
	 *            公告信息
	 * @return 公告集合
	 */
	public List<SysNotice> selectNoticeList(SysNotice notice);

	/**
	 * 新增公告
	 * 
	 * @param notice
	 *            公告信息
	 * @return 结果
	 */
	public int insertNotice(SysNotice notice);

	/**
	 * 修改公告
	 * 
	 * @param notice
	 *            公告信息
	 * @return 结果
	 */
	public int updateNotice(SysNotice notice);

	/**
	 * 批量删除公告
	 * 
	 * @param noticeIds
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteNoticeByIds(String[] noticeIds);
}