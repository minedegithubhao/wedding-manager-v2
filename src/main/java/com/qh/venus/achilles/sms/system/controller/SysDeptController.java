package com.qh.venus.achilles.sms.system.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.sms.system.domain.SysDept;
import com.qh.venus.achilles.sms.system.service.ISysDeptService;


/**
 * @Title: 部门 提供者
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/system/dept")
public class SysDeptController extends BaseController {
	@Autowired
	private ISysDeptService sysDeptService;

	/**
	 * 查询部门
	 */
	@GetMapping("get/{deptId}")
	public SysDept get(@PathVariable("deptId") Long deptId) {
		return sysDeptService.selectDeptById(deptId);
	}

	/**
	 * 查询部门列表
	 */
	@GetMapping("list")
	public R list(SysDept sysDept) {
		startPage();
		return result(sysDeptService.selectDeptList(sysDept));
	}

	/**
	 * 查询所有可用部门
	 */
	@GetMapping("list/enable")
	public R listEnable(SysDept sysDept) {
		sysDept.setStatus("0");
		return result(sysDeptService.selectDeptList(sysDept));
	}

	/**
	 * 新增保存部门
	 */
	@PostMapping("save")
	public R addSave(@RequestBody SysDept sysDept) {
		return toAjax(sysDeptService.insertDept(sysDept));
	}

	/**
	 * 修改保存部门
	 */
	@PostMapping("update")
	public R editSave(@RequestBody SysDept sysDept) {
		return toAjax(sysDeptService.updateDept(sysDept));
	}

	/**
	 * 删除部门
	 */
	@PostMapping("remove/{deptId}")
	public R remove(@PathVariable("deptId") Long deptId) {
		return toAjax(sysDeptService.deleteDeptById(deptId));
	}

	/**
	 * 加载角色部门（数据权限）列表
	 */
	@GetMapping("/role/{roleId}")
	public Set<String> deptTreeData(@PathVariable("roleId") Long roleId) {
		if (null == roleId || roleId <= 0)
			return null;
		return sysDeptService.roleDeptIds(roleId);
	}
}
