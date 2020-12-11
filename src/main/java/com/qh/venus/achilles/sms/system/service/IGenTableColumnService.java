package com.qh.venus.achilles.sms.system.service;

import com.qh.venus.achilles.sms.system.domain.GenTableColumn;

import java.util.List;

/**
 * @Title:业务字段 服务层
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public interface IGenTableColumnService {
	/**
	 * 查询业务字段列表
	 * 
	 * @param genTableColumn
	 *            业务字段信息
	 * @return 业务字段集合
	 */
	public List<GenTableColumn> selectGenTableColumnListByTableId(GenTableColumn genTableColumn);

	/**
	 * 新增业务字段
	 * 
	 * @param genTableColumn
	 *            业务字段信息
	 * @return 结果
	 */
	public int insertGenTableColumn(GenTableColumn genTableColumn);

	/**
	 * 修改业务字段
	 * 
	 * @param genTableColumn
	 *            业务字段信息
	 * @return 结果
	 */
	public int updateGenTableColumn(GenTableColumn genTableColumn);

	/**
	 * 删除业务字段信息
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteGenTableColumnByIds(String ids);
}
