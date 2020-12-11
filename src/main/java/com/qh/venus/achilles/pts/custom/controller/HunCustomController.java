package com.qh.venus.achilles.pts.custom.controller;

import com.qh.venus.achilles.framework.auth.annotation.HasPermissions;
import com.qh.venus.achilles.framework.log.annotation.OperLog;
import com.qh.venus.achilles.framework.log.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.pts.custom.domain.HunCustom;
import com.qh.venus.achilles.pts.custom.service.IHunCustomService;

/**
 * 客户管理 提供者
 * 
 * @author wedding
 * @date 2020-11-12
 */
@RestController
@RequestMapping("/pts/custom/custom")
public class HunCustomController extends BaseController
{
	
	@Autowired
	private IHunCustomService hunCustomService;
	
	/**
	 * 查询客户管理
	 */
	@GetMapping("get/{id}")
	public HunCustom get(@PathVariable("id") Long id)
	{
		return hunCustomService.selectHunCustomById(id);
		
	}
	
	/**
	 * 查询客户管理列表
	 */
	@GetMapping("list")
	@OperLog(title = "删除客户管理", businessType = BusinessType.QUERY)
	@HasPermissions("pts:custom:hunCustom:list")
	public R list(HunCustom hunCustom)
	{
		startPage();
        return result(hunCustomService.selectHunCustomList(hunCustom));
	}
	
	
	/**
	 * 新增保存客户管理
	 */
	@PostMapping("save")
	@OperLog(title = "删除客户管理", businessType = BusinessType.INSERT)
	@HasPermissions("pts:custom:hunCustom:add")
	public R addSave(@RequestBody HunCustom hunCustom)
	{		
		return toAjax(hunCustomService.insertHunCustom(hunCustom));
	}

	/**
	 * 修改保存客户管理
	 */
	@PostMapping("update")
	@OperLog(title = "删除客户管理", businessType = BusinessType.UPDATE)
	@HasPermissions("pts:custom:hunCustom:edit")
	public R editSave(@RequestBody HunCustom hunCustom)
	{		
		return toAjax(hunCustomService.updateHunCustom(hunCustom));
	}
	
	/**
	 * 删除客户管理
	 */
	@PostMapping("remove")
	@OperLog(title = "删除客户管理", businessType = BusinessType.DELETE)
	@HasPermissions("pts:custom:hunCustom:remove")
	public R remove(String ids)
	{		
		return toAjax(hunCustomService.deleteHunCustomByIds(ids));
	}
	
}
