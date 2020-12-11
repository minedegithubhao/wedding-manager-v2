package com.qh.venus.achilles.sms.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.page.PageDomain;
import com.qh.venus.achilles.sms.system.domain.SysNotice;
import com.qh.venus.achilles.sms.system.service.ISysNoticeService;


/**
 * @Title: 通知公告 提供者
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("/system/notice")
public class SysNoticeClient extends BaseController {

	@Autowired
	private ISysNoticeService sysNoticeService;

	/**
	 * 查询通知公告
	 */
	@GetMapping("get/{noticeId}")
	public SysNotice get(@PathVariable("noticeId") Long noticeId) {
		return sysNoticeService.selectNoticeById(noticeId);

	}

	/**
	 * 查询通知公告列表
	 */
	@PostMapping("list")
	public List<SysNotice> list(SysNotice sysNotice, PageDomain page) {
		startPage();
		return sysNoticeService.selectNoticeList(sysNotice);
	}

	/**
	 * 新增保存通知公告
	 */
	@PostMapping("save")
	public int addSave(SysNotice sysNotice) {
		return sysNoticeService.insertNotice(sysNotice);
	}

	/**
	 * 修改保存通知公告
	 */
	@PostMapping("update")
	public int editSave(SysNotice sysNotice) {
		return sysNoticeService.updateNotice(sysNotice);
	}

	/**
	 * 删除通知公告
	 */
	@PostMapping("remove")
	public int remove(String ids) {
		return sysNoticeService.deleteNoticeByIds(ids);
	}

}
