package com.qh.venus.achilles.sms.system.mapper;

import java.util.List;

import com.qh.venus.achilles.sms.system.domain.SysConfig;


/**
 * @Title: 参数配置 数据层
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public interface SysConfigMapper {
	/**
	 * 查询参数配置信息
	 * 
	 * @param config
	 *            参数配置信息
	 * @return 参数配置信息
	 */
	public SysConfig selectConfig(SysConfig config);

	/**
	 * 查询参数配置列表
	 * 
	 * @param config
	 *            参数配置信息
	 * @return 参数配置集合
	 */
	public List<SysConfig> selectConfigList(SysConfig config);

	/**
	 * 根据键名查询参数配置信息
	 * 
	 * @param configKey
	 *            参数键名
	 * @return 参数配置信息
	 */
	public SysConfig checkConfigKeyUnique(String configKey);

	/**
	 * 新增参数配置
	 * 
	 * @param config
	 *            参数配置信息
	 * @return 结果
	 */
	public int insertConfig(SysConfig config);

	/**
	 * 修改参数配置
	 * 
	 * @param config
	 *            参数配置信息
	 * @return 结果
	 */
	public int updateConfig(SysConfig config);

	/**
	 * 批量删除参数配置
	 * 
	 * @param configIds
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteConfigByIds(String[] configIds);
}