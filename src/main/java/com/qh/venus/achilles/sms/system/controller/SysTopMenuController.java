package com.qh.venus.achilles.sms.system.controller;

import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.pts.sys.service.ITSysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.sms.system.domain.SysTopMenu;
import com.qh.venus.achilles.sms.system.service.ISysTopMenuService;

/**
 * 顶部菜单 提供者
 * 
 * @author qh_venus
 * @date 2020-05-12
 */
@RestController
@RequestMapping("/system/topMenu")
public class SysTopMenuController extends BaseController
{
	
	@Autowired
	private ISysTopMenuService sysTopMenuService;
	@Autowired
	private ITSysFileService tSysFileService;
	/**
	 * 查询${tableComment}
	 */
	@GetMapping("get/{id}")
	public SysTopMenu get(@PathVariable("id") Long id)
	{
		return sysTopMenuService.selectSysTopMenuById(id);
		
	}
	
	/**
	 * 查询顶部菜单列表
	 */
	@GetMapping("list")
	public R list(SysTopMenu sysTopMenu)
	{
		startPage();
        return result(sysTopMenuService.selectSysTopMenuList(sysTopMenu));
	}
	
	
	/**
	 * 新增保存顶部菜单
	 */
	@PostMapping("save")
	public R addSave(@RequestBody SysTopMenu sysTopMenu)
	{		
		return toAjax(sysTopMenuService.insertSysTopMenu(sysTopMenu));
	}

	/**
	 * 修改保存顶部菜单
	 */
	@PostMapping("update")
	public R editSave(@RequestBody SysTopMenu sysTopMenu)
	{		
		return toAjax(sysTopMenuService.updateSysTopMenu(sysTopMenu));
	}
	
	/**
	 * 删除${tableComment}
	 */
	@PostMapping("remove")
	public R remove(String ids)
	{
		String[] idArr = Convert.toStrArray(ids);
		for (String id : idArr) {
			SysTopMenu sysTopMenu = sysTopMenuService.selectSysTopMenuById(Long.valueOf(id));
			tSysFileService.deleteTSysFileByBusId(sysTopMenu.getBusId(),true);
		}
		return toAjax(sysTopMenuService.deleteSysTopMenuByIds(ids));
	}
	
}
