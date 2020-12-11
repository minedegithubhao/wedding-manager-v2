package com.qh.venus.achilles.pts.matchmaker.controller;

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
import com.qh.venus.achilles.pts.matchmaker.domain.HunMatchmaker;
import com.qh.venus.achilles.pts.matchmaker.service.IHunMatchmakerService;

/**
 * 红娘管理 提供者
 * 
 * @author wedding
 * @date 2020-11-18
 */
@RestController
@RequestMapping("/pts/matchmaker/hunMatchmaker")
public class HunMatchmakerController extends BaseController
{
	
	@Autowired
	private IHunMatchmakerService hunMatchmakerService;
	
	/**
	 * 查询红娘管理
	 */
	@GetMapping("get/{id}")
	public HunMatchmaker get(@PathVariable("id") Long id)
	{
		return hunMatchmakerService.selectHunMatchmakerById(id);
		
	}
	
	/**
	 * 查询红娘管理列表
	 */
	@GetMapping("list")
	@OperLog(title = "删除红娘管理", businessType = BusinessType.QUERY)
	@HasPermissions("matchmaker:hunMatchmaker:list")
	public R list(HunMatchmaker hunMatchmaker)
	{
		startPage();
        return result(hunMatchmakerService.selectHunMatchmakerList(hunMatchmaker));
	}
	
	
	/**
	 * 新增保存红娘管理
	 */
	@PostMapping("save")
	@OperLog(title = "删除红娘管理", businessType = BusinessType.INSERT)
	@HasPermissions("matchmaker:hunMatchmaker:add")
	public R addSave(@RequestBody HunMatchmaker hunMatchmaker)
	{		
		return toAjax(hunMatchmakerService.insertHunMatchmaker(hunMatchmaker));
	}

	/**
	 * 修改保存红娘管理
	 */
	@PostMapping("update")
	@OperLog(title = "删除红娘管理", businessType = BusinessType.UPDATE)
	@HasPermissions("matchmaker:hunMatchmaker:edit")
	public R editSave(@RequestBody HunMatchmaker hunMatchmaker)
	{		
		return toAjax(hunMatchmakerService.updateHunMatchmaker(hunMatchmaker));
	}
	
	/**
	 * 删除红娘管理
	 */
	@PostMapping("remove")
	@OperLog(title = "删除红娘管理", businessType = BusinessType.DELETE)
	@HasPermissions("matchmaker:hunMatchmaker:remove")
	public R remove(String ids)
	{		
		return toAjax(hunMatchmakerService.deleteHunMatchmakerByIds(ids));
	}
	
}
