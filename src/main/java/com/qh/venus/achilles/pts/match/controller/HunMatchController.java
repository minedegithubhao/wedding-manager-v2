package com.qh.venus.achilles.pts.match.controller;

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
import com.qh.venus.achilles.pts.match.domain.HunMatch;
import com.qh.venus.achilles.pts.match.service.IHunMatchService;

/**
 * 配对 提供者
 * 
 * @author qh_venus
 * @date 2020-11-18
 */
@RestController
@RequestMapping("/pts/match/hunMatch")
public class HunMatchController extends BaseController
{
	
	@Autowired
	private IHunMatchService hunMatchService;
	
	/**
	 * 查询配对
	 */
	@GetMapping("get/{id}")
	public HunMatch get(@PathVariable("id") Long id)
	{
		return hunMatchService.selectHunMatchById(id);
		
	}
	
	/**
	 * 查询配对列表
	 */
	@GetMapping("list")
	@OperLog(title = "删除配对", businessType = BusinessType.QUERY)
	@HasPermissions("match:hunMatch:list")
	public R list(HunMatch hunMatch)
	{
		startPage();
        return result(hunMatchService.selectHunMatchList(hunMatch));
	}
	
	
	/**
	 * 新增保存配对
	 */
	@PostMapping("save")
	@OperLog(title = "删除配对", businessType = BusinessType.INSERT)
	@HasPermissions("match:hunMatch:add")
	public R addSave(@RequestBody HunMatch hunMatch)
	{		
		return toAjax(hunMatchService.insertHunMatch(hunMatch));
	}

	/**
	 * 修改保存配对
	 */
	@PostMapping("update")
	@OperLog(title = "删除配对", businessType = BusinessType.UPDATE)
	@HasPermissions("match:hunMatch:edit")
	public R editSave(@RequestBody HunMatch hunMatch)
	{		
		return toAjax(hunMatchService.updateHunMatch(hunMatch));
	}
	
	/**
	 * 删除配对
	 */
	@PostMapping("remove")
	@OperLog(title = "删除配对", businessType = BusinessType.DELETE)
	@HasPermissions("match:hunMatch:remove")
	public R remove(String ids)
	{		
		return toAjax(hunMatchService.deleteHunMatchByIds(ids));
	}
	
}
