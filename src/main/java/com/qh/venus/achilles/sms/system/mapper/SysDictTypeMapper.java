package com.qh.venus.achilles.sms.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.qh.venus.achilles.sms.system.domain.SysDictType;


/**
 * @Title: 字典表 数据层
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@Mapper
public interface SysDictTypeMapper {
	/**
	 * 根据条件分页查询字典类型
	 * 
	 * @param dictType
	 *            字典类型信息
	 * @return 字典类型集合信息
	 */
	public List<SysDictType> selectDictTypeList(SysDictType dictType);

	/**
	 * 根据所有字典类型
	 * 
	 * @return 字典类型集合信息
	 */
	public List<SysDictType> selectDictTypeAll();

	/**
	 * 根据字典类型ID查询信息
	 * 
	 * @param dictId
	 *            字典类型ID
	 * @return 字典类型
	 */
	public SysDictType selectDictTypeById(Long dictId);

	/**
	 * 通过字典ID删除字典信息
	 * 
	 * @param dictId
	 *            字典ID
	 * @return 结果
	 */
	public int deleteDictTypeById(Long dictId);

	/**
	 * 批量删除字典类型
	 * 
	 * @param ids
	 *            需要删除的数据
	 * @return 结果
	 */
	public int deleteDictTypeByIds(Long[] ids);

	/**
	 * 新增字典类型信息
	 * 
	 * @param dictType
	 *            字典类型信息
	 * @return 结果
	 */
	public int insertDictType(SysDictType dictType);

	/**
	 * 修改字典类型信息
	 * 
	 * @param dictType
	 *            字典类型信息
	 * @return 结果
	 */
	public int updateDictType(SysDictType dictType);

	/**
	 * 校验字典类型称是否唯一
	 * 
	 * @param dictType
	 *            字典类型
	 * @return 结果
	 */
	public SysDictType checkDictTypeUnique(String dictType);
}
