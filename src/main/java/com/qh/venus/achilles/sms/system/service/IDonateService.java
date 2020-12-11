package com.qh.venus.achilles.sms.system.service;

import java.util.List;

import com.qh.venus.achilles.sms.system.domain.Donate;


/**
 * @Title:捐赠 服务层
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public interface IDonateService {
	/**
	 * 查询捐赠列表
	 * 
	 * @param donate
	 *            捐赠信息
	 * @return 捐赠集合
	 */
	public List<Donate> selectDistrictsList(Donate donate);
}
