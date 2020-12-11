package com.qh.venus.achilles.sms.system.controller;

import java.util.List;

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
import com.qh.venus.achilles.sms.system.domain.SysDictData;
import com.qh.venus.achilles.sms.system.service.ISysDictDataService;


/**
 * @Title: 字典数据 提供者
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/system/dict/data")
public class SysDictDataController extends BaseController {

	@Autowired
	private ISysDictDataService sysDictDataService;

	/**
	 * 查询字典数据
	 */
	@GetMapping("get/{dictCode}")
	public SysDictData get(@PathVariable("dictCode") Long dictCode) {
		return sysDictDataService.selectDictDataById(dictCode);

	}

	/**
	 * 查询字典数据列表
	 */
	@GetMapping("list")
	@HasPermissions("system:dict:list")
	public R list(SysDictData sysDictData) {
		startPage();
		return result(sysDictDataService.selectDictDataList(sysDictData));
	}

	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType
	 *            字典类型
	 * @return 参数键值
	 */
	@GetMapping("type")
	public List<SysDictData> getType(String dictType) {
		return sysDictDataService.selectDictDataByType(dictType);
	}

	/**
	 * 根据字典类型和字典键值查询字典数据信息
	 * 
	 * @param dictType
	 *            字典类型
	 * @param dictValue
	 *            字典键值
	 * @return 字典标签
	 */
	@GetMapping("label")
	public String getLabel(String dictType, String dictValue) {
		return sysDictDataService.selectDictLabel(dictType, dictValue);
	}

	/**
	 * 新增保存字典数据
	 */
	@OperLog(title = "字典数据", businessType = BusinessType.INSERT)
	@HasPermissions("system:dict:add")
	@PostMapping("save")
	public R addSave(@RequestBody SysDictData sysDictData) {
		return toAjax(sysDictDataService.insertDictData(sysDictData));
	}

	/**
	 * 修改保存字典数据
	 */
	@OperLog(title = "字典数据", businessType = BusinessType.UPDATE)
	@HasPermissions("system:dict:edit")
	@PostMapping("update")
	public R editSave(@RequestBody SysDictData sysDictData) {
		return toAjax(sysDictDataService.updateDictData(sysDictData));
	}

	/**
	 * 删除字典数据
	 */
	@OperLog(title = "字典数据", businessType = BusinessType.DELETE)
	@HasPermissions("system:dict:remove")
	@PostMapping("remove")
	public R remove(String ids) {
		return toAjax(sysDictDataService.deleteDictDataByIds(ids));
	}

}