package com.qh.venus.achilles.sms.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.framework.auth.annotation.HasPermissions;
import com.qh.venus.achilles.framework.log.annotation.OperLog;
import com.qh.venus.achilles.framework.log.enums.BusinessType;
import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.framework.web.page.PageDomain;
import com.qh.venus.achilles.sms.system.domain.SysDictType;
import com.qh.venus.achilles.sms.system.service.ISysDictTypeService;


/**
 * @Title: 字典类型 提供者
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/system/dict/type")
public class SysDictTypeController extends BaseController {

	@Autowired
	private ISysDictTypeService sysDictTypeService;

	/**
	 * 查询字典类型
	 */
	@GetMapping("get/{dictId}")
	public SysDictType get(@PathVariable("dictId") Long dictId) {
		return sysDictTypeService.selectDictTypeById(dictId);

	}

	/**
	 * 查询字典类型列表
	 */
	@GetMapping("list")
	@HasPermissions("system:dict:list")
	public R list(SysDictType sysDictType, PageDomain page) {
		startPage();
		return result(sysDictTypeService.selectDictTypeList(sysDictType));
	}

	/**
	 * 新增保存字典类型
	 */
	@OperLog(title = "字典类型", businessType = BusinessType.INSERT)
	@HasPermissions("system:dict:add")
	@PostMapping("save")
	public R addSave(@RequestBody SysDictType sysDictType) {
		return toAjax(sysDictTypeService.insertDictType(sysDictType));
	}

	/**
	 * 修改保存字典类型
	 */
	@OperLog(title = "字典类型", businessType = BusinessType.UPDATE)
	@HasPermissions("system:dict:edit")
	@PostMapping("update")
	public R editSave(@RequestBody SysDictType sysDictType) {
		return toAjax(sysDictTypeService.updateDictType(sysDictType));
	}

	/**
	 * 删除字典类型
	 * 
	 * @throws Exception
	 */
	@OperLog(title = "字典类型", businessType = BusinessType.DELETE)
	@HasPermissions("system:dict:remove")
	@PostMapping("remove")
	public R remove(String ids) throws Exception {
		return toAjax(sysDictTypeService.deleteDictTypeByIds(ids));
	}

}
