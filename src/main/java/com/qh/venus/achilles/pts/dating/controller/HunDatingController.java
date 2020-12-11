package com.qh.venus.achilles.pts.dating.controller;

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
import com.qh.venus.achilles.pts.dating.domain.HunDating;
import com.qh.venus.achilles.pts.dating.service.IHunDatingService;

/**
 * 相亲 提供者
 * 
 * @author wedding
 * @date 2020-11-21
 */
@RestController
@RequestMapping("/pts/dating/hunDating")
public class HunDatingController extends BaseController
{
	
	@Autowired
	private IHunDatingService hunDatingService;
	
	/**
	 * 查询相亲
	 */
	@GetMapping("get/{id}")
	public HunDating get(@PathVariable("id") Long id)
	{
		return hunDatingService.selectHunDatingById(id);
		
	}
	
	/**
	 * 查询相亲列表
	 */
	@GetMapping("list")
	@OperLog(title = "删除相亲", businessType = BusinessType.QUERY)
	@HasPermissions("dating:hunDating:list")
	public R list(HunDating hunDating)
	{
		startPage();
        return result(hunDatingService.selectHunDatingList(hunDating));
	}
	
	
	/**
	 * 新增保存相亲
	 */
	@PostMapping("save")
	@OperLog(title = "删除相亲", businessType = BusinessType.INSERT)
	@HasPermissions("dating:hunDating:add")
	public R addSave(@RequestBody HunDating hunDating)
	{		
		return toAjax(hunDatingService.insertHunDating(hunDating));
	}

	/**
	 * 修改保存相亲
	 */
	@PostMapping("update")
	@OperLog(title = "删除相亲", businessType = BusinessType.UPDATE)
	@HasPermissions("dating:hunDating:edit")
	public R editSave(@RequestBody HunDating hunDating)
	{		
		return toAjax(hunDatingService.updateHunDating(hunDating));
	}
	
	/**
	 * 删除相亲
	 */
	@PostMapping("remove")
	@OperLog(title = "删除相亲", businessType = BusinessType.DELETE)
	@HasPermissions("dating:hunDating:remove")
	public R remove(String ids)
	{		
		return toAjax(hunDatingService.deleteHunDatingByIds(ids));
	}
	
}
