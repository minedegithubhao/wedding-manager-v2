package com.qh.venus.achilles.sms.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.sms.system.domain.SysPost;
import com.qh.venus.achilles.sms.system.service.ISysPostService;


/**
 * @Title: 岗位 提供者
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/system/sys/sysPost")
public class SysPostClient extends BaseController {

	@Autowired
	private ISysPostService sysPostService;

	/**
	 * 查询岗位
	 */
	@GetMapping("get/{postId}")
	public SysPost get(@PathVariable("postId") Long postId) {
		return sysPostService.selectPostById(postId);

	}

	/**
	 * 查询岗位列表
	 */
	@PostMapping("list")
	public List<SysPost> list(SysPost sysPost) {
		startPage();
		return sysPostService.selectPostList(sysPost);
	}

	/**
	 * 新增保存岗位
	 */
	@PostMapping("save")
	public int addSave(SysPost sysPost) {
		return sysPostService.insertPost(sysPost);
	}

	/**
	 * 修改保存岗位
	 */
	@PostMapping("update")
	public int editSave(SysPost sysPost) {
		return sysPostService.updatePost(sysPost);
	}

	/**
	 * 删除岗位
	 * 
	 * @throws Exception
	 */
	@PostMapping("remove")
	public int remove(String ids) throws Exception {
		return sysPostService.deletePostByIds(ids);
	}

}
