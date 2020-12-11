package com.qh.venus.achilles.sms.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.framework.auth.annotation.HasPermissions;
import com.qh.venus.achilles.framework.log.annotation.OperLog;
import com.qh.venus.achilles.framework.log.enums.BusinessType;
import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.sms.system.domain.SysLogininfor;
import com.qh.venus.achilles.sms.system.service.ISysLogininforService;


/**
 * @Title: 系统访问记录 提供者
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/system/logininfor")
public class SysLogininforController extends BaseController {
	@Autowired
	private ISysLogininforService sysLogininforService;

	/**
	 * 查询系统访问记录列表
	 */
	@GetMapping("list")
	@OperLog(title = "访问日志", businessType = BusinessType.QUERY)
	@HasPermissions("monitor:logininfor:list")
	public R list(SysLogininfor sysLogininfor) {
		startPage();
		return result(sysLogininforService.selectLogininforList(sysLogininfor));
	}

	/**
	 * 新增保存系统访问记录
	 */
	@PostMapping("save")
	public void addSave(@RequestBody SysLogininfor sysLogininfor) {
		sysLogininforService.insertLogininfor(sysLogininfor);
	}

	/**
	 * 删除系统访问记录
	 */
//	@OperLog(title = "访问日志", businessType = BusinessType.DELETE)
//	@HasPermissions("monitor:logininfor:remove")
//	@PostMapping("remove")
//	public R remove(String ids) {
//		return toAjax(sysLogininforService.deleteLogininforByIds(ids));
//	}
//
//	@OperLog(title = "访问日志", businessType = BusinessType.CLEAN)
//	@HasPermissions("monitor:logininfor:remove")
//	@PostMapping("/clean")
//	public R clean() {
//		sysLogininforService.cleanLogininfor();
//		return R.ok();
//	}

}
