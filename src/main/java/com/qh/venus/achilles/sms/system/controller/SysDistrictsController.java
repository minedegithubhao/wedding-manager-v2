package com.qh.venus.achilles.sms.system.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.qh.venus.achilles.sms.system.domain.Districts;
import com.qh.venus.achilles.sms.system.service.IDistrictsService;


/**
 * @Title: 地区 信息操作处理
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/system/districts")
public class SysDistrictsController extends BaseController {
	@Autowired
	private IDistrictsService districtsService;

	/**
	 * 查询地区列表
	 */
	@HasPermissions("system:districts:list")
	@RequestMapping("/list")
	public R list(Districts districts) {
		startPage();
		return result(districtsService.selectDistrictsList(districts));
	}

	/**
	 * 导出地区列表
	 */
	@HasPermissions("system:districts:export")
	@OperLog(title = "地区", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public R export(Districts districts) {
		List<Districts> list = districtsService.selectDistrictsList(districts);
		ExcelUtil<Districts> util = new ExcelUtil<Districts>(Districts.class);
		return util.exportExcel(list, "districts");
	}

	/**
	 * 新增保存地区
	 */
	@HasPermissions("system:districts:add")
	@OperLog(title = "地区", businessType = BusinessType.INSERT)
	@PostMapping("save")
	public R addSave(@RequestBody Districts districts) {
		districts.setPid(districts.getId() / 100);
		districts.setCreateTime(new Date());
		districts.setUpdateTime(new Date());
		districts.setOperator(getLoginName());
		return toAjax(districtsService.insertDistricts(districts));
	}

	/**
	 * 
	 * /** 修改保存地区
	 */
	@HasPermissions("system:districts:edit")
	@OperLog(title = "地区", businessType = BusinessType.UPDATE)
	@PostMapping("update")
	public R editSave(@RequestBody Districts districts) {
		districts.setPid(districts.getId() / 100);
		districts.setOperator(getLoginName());
		districts.setUpdateTime(new Date());
		return toAjax(districtsService.updateDistricts(districts));
	}

	/**
	 * 删除地区
	 */
	@HasPermissions("system:districts:remove")
	@OperLog(title = "地区", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	public R remove(String ids) {
		return toAjax(districtsService.deleteDistrictsByIds(ids));
	}
}