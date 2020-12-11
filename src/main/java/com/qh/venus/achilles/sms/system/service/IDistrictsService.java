package com.qh.venus.achilles.sms.system.service;

import java.util.List;

import com.qh.venus.achilles.sms.system.domain.Districts;


/**
 * @Title:地区 服务层
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public interface IDistrictsService {
	/**
	 * 查询地区信息
	 *
	 * @param id
	 *            地区ID
	 * @return 地区信息
	 */
	public Districts selectDistrictsById(Integer id);

	/**
	 * 查询地区列表
	 *
	 * @param districts
	 *            地区信息
	 * @return 地区集合
	 */
	public List<Districts> selectDistrictsList(Districts districts);

	/**
	 * 新增地区
	 *
	 * @param districts
	 *            地区信息
	 * @return 结果
	 */
	public int insertDistricts(Districts districts);

	/**
	 * 修改地区
	 *
	 * @param districts
	 *            地区信息
	 * @return 结果
	 */
	public int updateDistricts(Districts districts);

	/**
	 * 删除地区信息
	 *
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteDistrictsByIds(String ids);

}
