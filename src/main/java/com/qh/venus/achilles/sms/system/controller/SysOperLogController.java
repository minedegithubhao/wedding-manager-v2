package com.qh.venus.achilles.sms.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.common.utils.poi.ExcelUtil;
import com.qh.venus.achilles.framework.auth.annotation.HasPermissions;
import com.qh.venus.achilles.framework.log.annotation.OperLog;
import com.qh.venus.achilles.framework.log.enums.BusinessType;
import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.sms.system.domain.SysOperLog;
import com.qh.venus.achilles.sms.system.service.ISysOperLogService;


/**
 * @Title: 操作日志记录 提供者
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/system/operLog")
public class SysOperLogController extends BaseController {
	@Autowired
	private ISysOperLogService sysOperLogService;

	/**
	 * 查询操作日志记录
	 */
	@GetMapping("get/{operId}")
	public SysOperLog get(@PathVariable("operId") Long operId) {
		return sysOperLogService.selectOperLogById(operId);
	}

	/**
	 * 查询操作日志记录列表
	 */
	@HasPermissions("monitor:operlog:list")
	@RequestMapping("list")
	public R list(SysOperLog sysOperLog) {
		startPage();
		return result(sysOperLogService.selectOperLogList(sysOperLog));
	}

	@OperLog(title = "操作日志", businessType = BusinessType.EXPORT)
	@HasPermissions("monitor:operlog:export")
	@PostMapping("/export")
	public R export(SysOperLog operLog) {
		List<SysOperLog> list = sysOperLogService.selectOperLogList(operLog);
		ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
		return util.exportExcel(list, "操作日志");
	}

	/**
	 * 新增保存操作日志记录
	 */
	@PostMapping("save")
	public void addSave(@RequestBody SysOperLog sysOperLog) {
		sysOperLogService.insertOperlog(sysOperLog);
	}

	/**
	 * 删除操作日志记录
	 */
//	@HasPermissions("monitor:operlog:remove")
//	@PostMapping("remove")
//	public R remove(String ids) {
//		return toAjax(sysOperLogService.deleteOperLogByIds(ids));
//	}
//
//	@OperLog(title = "操作日志", businessType = BusinessType.CLEAN)
//	@HasPermissions("monitor:operlog:remove")
//	@PostMapping("/clean")
//	public R clean() {
//		sysOperLogService.cleanOperLog();
//		return R.ok();
//	}
}
