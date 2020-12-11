package com.qh.venus.achilles.pts.member.controller;

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
import com.qh.venus.achilles.pts.member.domain.HunMember;
import com.qh.venus.achilles.pts.member.service.IHunMemberService;

/**
 * 会员管理 提供者
 * 
 * @author wedding
 * @date 2020-11-17
 */
@RestController
@RequestMapping("/pts/member/hunMember")
public class HunMemberController extends BaseController
{
	
	@Autowired
	private IHunMemberService hunMemberService;
	
	/**
	 * 查询会员管理
	 */
	@GetMapping("get/{id}")
	public HunMember get(@PathVariable("id") Long id)
	{
		return hunMemberService.selectHunMemberById(id);
	}
	
	/**
	 * 查询会员管理列表
	 */
	@GetMapping("list")
	@OperLog(title = "删除会员管理", businessType = BusinessType.QUERY)
	@HasPermissions("member:hunMember:list")
	public R list(HunMember hunMember)
	{
		startPage();
        return result(hunMemberService.selectHunMemberList(hunMember));
	}
	
	
	/**
	 * 新增保存会员管理
	 */
	@PostMapping("save")
	@OperLog(title = "删除会员管理", businessType = BusinessType.INSERT)
	@HasPermissions("member:hunMember:add")
	public R addSave(@RequestBody HunMember hunMember)
	{		
		return toAjax(hunMemberService.insertHunMember(hunMember));
	}

	/**
	 * 修改保存会员管理
	 */
	@PostMapping("update")
	@OperLog(title = "删除会员管理", businessType = BusinessType.UPDATE)
	@HasPermissions("member:hunMember:edit")
	public R editSave(@RequestBody HunMember hunMember)
	{		
		return toAjax(hunMemberService.updateHunMember(hunMember));
	}
	
	/**
	 * 删除会员管理
	 */
	@PostMapping("remove")
	@OperLog(title = "删除会员管理", businessType = BusinessType.DELETE)
	@HasPermissions("member:hunMember:remove")
	public R remove(String ids)
	{		
		return toAjax(hunMemberService.deleteHunMemberByIds(ids));
	}
	
}
