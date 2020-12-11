package com.qh.venus.achilles.sms.system.domain;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * @Title:捐赠
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@Data
@Accessors(chain = true)
public class Donate {
	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;

	private String nick;

	private Double amount;

	private Integer canal;

	private String remark;

	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;

	@Transient
	private String beginTime;

	@Transient
	private String endTime;
}
