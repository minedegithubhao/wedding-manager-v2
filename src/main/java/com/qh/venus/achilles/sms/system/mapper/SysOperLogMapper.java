package com.qh.venus.achilles.sms.system.mapper;

import java.util.List;

import com.qh.venus.achilles.sms.system.domain.SysOperLog;


/**
 * @Title: 操作日志 数据层
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public interface SysOperLogMapper {
	/**
	 * 新增操作日志
	 * 
	 * @param operLog
	 *            操作日志对象
	 */
	public void insertOperlog(SysOperLog operLog);

	/**
	 * 查询系统操作日志集合
	 * 
	 * @param operLog
	 *            操作日志对象
	 * @return 操作日志集合
	 */
	public List<SysOperLog> selectOperLogList(SysOperLog operLog);

	/**
	 * 批量删除系统操作日志
	 * 
	 * @param ids
	 *            需要删除的数据
	 * @return 结果
	 */
	public int deleteOperLogByIds(String[] ids);

	/**
	 * 查询操作日志详细
	 * 
	 * @param operId
	 *            操作ID
	 * @return 操作日志对象
	 */
	public SysOperLog selectOperLogById(Long operId);

	/**
	 * 清空操作日志
	 */
	public void cleanOperLog();
}
