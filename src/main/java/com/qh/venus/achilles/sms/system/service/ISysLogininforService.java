package com.qh.venus.achilles.sms.system.service;

import java.util.List;

import com.qh.venus.achilles.sms.system.domain.SysLogininfor;


/**
 * @Title:系统访问日志情况信息 服务层
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public interface ISysLogininforService {
	/**
	 * 新增系统登录日志
	 * 
	 * @param logininfor
	 *            访问日志对象
	 */
	public void insertLogininfor(SysLogininfor logininfor);

	/**
	 * 查询系统登录日志集合
	 * 
	 * @param logininfor
	 *            访问日志对象
	 * @return 登录记录集合
	 */
	public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

	/**
	 * 批量删除系统登录日志
	 * 
	 * @param ids
	 *            需要删除的数据
	 * @return
	 */
	public int deleteLogininforByIds(String ids);

	/**
	 * 清空系统登录日志
	 */
	public void cleanLogininfor();
}
