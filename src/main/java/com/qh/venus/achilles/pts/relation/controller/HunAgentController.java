package com.qh.venus.achilles.pts.relation.controller;

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
import com.qh.venus.achilles.pts.relation.domain.HunAgent;
import com.qh.venus.achilles.pts.relation.service.IHunAgentService;

/**
 * 代理人 提供者
 * 
 * @author qh_venus
 * @date 2020-11-13
 */
@RestController
@RequestMapping("/pts/relation/hunAgent")
public class HunAgentController extends BaseController
{
	
	@Autowired
	private IHunAgentService hunAgentService;
	
	/**
	 * 查询代理人
	 */
	@GetMapping("get/{id}")
	public HunAgent get(@PathVariable("id") Long id)
	{
		return hunAgentService.selectHunAgentById(id);
		
	}
	
	/**
	 * 查询代理人列表
	 */
	@GetMapping("list")
	@OperLog(title = "删除代理人", businessType = BusinessType.QUERY)
	@HasPermissions("agent:hunAgent:list")
	public R list(HunAgent hunAgent)
	{
		startPage();
        return result(hunAgentService.selectHunAgentList(hunAgent));
	}
	
	
	/**
	 * 新增保存代理人
	 */
	@PostMapping("save")
	@OperLog(title = "删除代理人", businessType = BusinessType.INSERT)
	@HasPermissions("agent:hunAgent:add")
	public R addSave(@RequestBody HunAgent hunAgent)
	{		
		return toAjax(hunAgentService.insertHunAgent(hunAgent));
	}

	/**
	 * 修改保存代理人
	 */
	@PostMapping("update")
	@OperLog(title = "删除代理人", businessType = BusinessType.UPDATE)
	@HasPermissions("agent:hunAgent:edit")
	public R editSave(@RequestBody HunAgent hunAgent)
	{		
		return toAjax(hunAgentService.updateHunAgent(hunAgent));
	}
	
	/**
	 * 删除代理人
	 */
	@PostMapping("remove")
	@OperLog(title = "删除代理人", businessType = BusinessType.DELETE)
	@HasPermissions("agent:hunAgent:remove")
	public R remove(String ids)
	{		
		return toAjax(hunAgentService.deleteHunAgentByIds(ids));
	}
	
}
