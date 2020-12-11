package com.qh.venus.achilles.sms.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel;
import com.qh.venus.achilles.framework.web.domain.BaseEntity;


/**
 * @Title:字典数据表 sys_dict_data
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public class SysDictData extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 字典编码 */
	@Excel(name = "字典编码")
	private Long dictCode;

	/** 字典排序 */
	@Excel(name = "字典排序")
	private Long dictSort;

	/** 字典标签 */
	@Excel(name = "字典标签")
	private String dictLabel;

	/** 字典键值 */
	@Excel(name = "字典键值")
	private String dictValue;

	/** 字典类型 */
	@Excel(name = "字典类型")
	private String dictType;

	/** 样式属性（其他样式扩展） */
	@Excel(name = "字典样式")
	private String cssClass;

	/** 表格字典样式 */
	private String listClass;

	/** 是否默认（Y是 N否） */
	@Excel(name = "是否默认", readConverterExp = "Y=是,N=否")
	private String isDefault;

	/** 状态（0正常 1停用） */
	@Excel(name = "状态", readConverterExp = "0=正常,1=停用")
	private String status;

	public Long getDictCode() {
		return dictCode;
	}

	public void setDictCode(Long dictCode) {
		this.dictCode = dictCode;
	}

	public Long getDictSort() {
		return dictSort;
	}

	public void setDictSort(Long dictSort) {
		this.dictSort = dictSort;
	}

	public String getDictLabel() {
		return dictLabel;
	}

	public void setDictLabel(String dictLabel) {
		this.dictLabel = dictLabel;
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getListClass() {
		return listClass;
	}

	public void setListClass(String listClass) {
		this.listClass = listClass;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("dictCode", getDictCode())
				.append("dictSort", getDictSort()).append("dictLabel", getDictLabel())
				.append("dictValue", getDictValue()).append("dictType", getDictType()).append("cssClass", getCssClass())
				.append("listClass", getListClass()).append("isDefault", getIsDefault()).append("status", getStatus())
				.append("createBy", getCreateBy()).append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).append("remark", getRemark())
				.toString();
	}
}
