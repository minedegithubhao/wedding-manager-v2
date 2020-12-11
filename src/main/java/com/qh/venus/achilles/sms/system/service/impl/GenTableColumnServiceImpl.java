package com.qh.venus.achilles.sms.system.service.impl;
import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.sms.system.domain.GenTableColumn;
import com.qh.venus.achilles.sms.system.mapper.GenTableColumnMapper;
import com.qh.venus.achilles.sms.system.service.IGenTableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title:业务字段 服务层实现
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@Service
public class GenTableColumnServiceImpl implements IGenTableColumnService {
	@Autowired
	private GenTableColumnMapper genTableColumnMapper;

	/**
	 * 查询业务字段列表
	 * 
	 * @param genTableColumn
	 *            业务字段信息
	 * @return 业务字段集合
	 */
	@Override
	public List<GenTableColumn> selectGenTableColumnListByTableId(GenTableColumn genTableColumn) {
		return genTableColumnMapper.selectGenTableColumnListByTableId(genTableColumn);
	}

	/**
	 * 新增业务字段
	 * 
	 * @param genTableColumn
	 *            业务字段信息
	 * @return 结果
	 */
	@Override
	public int insertGenTableColumn(GenTableColumn genTableColumn) {
		return genTableColumnMapper.insertGenTableColumn(genTableColumn);
	}

	/**
	 * 修改业务字段
	 * 
	 * @param genTableColumn
	 *            业务字段信息
	 * @return 结果
	 */
	@Override
	public int updateGenTableColumn(GenTableColumn genTableColumn) {
		return genTableColumnMapper.updateGenTableColumn(genTableColumn);
	}

	/**
	 * 删除业务字段对象
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteGenTableColumnByIds(String ids) {
		return genTableColumnMapper.deleteGenTableColumnByIds(Convert.toLongArray(ids));
	}
}