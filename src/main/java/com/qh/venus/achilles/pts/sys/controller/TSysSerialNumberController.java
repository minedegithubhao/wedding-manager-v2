package com.qh.venus.achilles.pts.sys.controller;

import com.qh.venus.achilles.common.utils.IdUtils;
import com.qh.venus.achilles.framework.auth.annotation.HasPermissions;
import com.qh.venus.achilles.framework.log.annotation.OperLog;
import com.qh.venus.achilles.framework.log.enums.BusinessType;
import com.qh.venus.achilles.pts.sys.domain.CheckUnique;
import com.qh.venus.achilles.pts.sys.service.IUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.pts.sys.domain.TSysSerialNumber;
import com.qh.venus.achilles.pts.sys.service.ITSysSerialNumberService;

/**
 * 公共流水号 提供者
 * 
 * @author qh_venus_zf
 * @date 2020-04-22
 */
@RestController
@RequestMapping("/pts/sys/TSysSerialNumber")
public class TSysSerialNumberController extends BaseController
{
	
	@Autowired
	private ITSysSerialNumberService tSysSerialNumberService;
	@Autowired
	private IUtilService utilService;
	/**
	 * 查询${tableComment}
	 */
	@GetMapping("get/{id}")
	public TSysSerialNumber get(@PathVariable("id") String id)
	{
		return tSysSerialNumberService.selectTSysSerialNumberById(id);
		
	}
	
	/**
	 * 查询公共流水号列表
	 */
	@OperLog(title = "公共流水号", businessType = BusinessType.QUERY)
	@HasPermissions("pts:sys:tSysSerialNumber:list")
	@GetMapping("list")
	public R list(TSysSerialNumber tSysSerialNumber)
	{
		startPage();
        return result(tSysSerialNumberService.selectTSysSerialNumberList(tSysSerialNumber));
	}
	
	
	/**
	 * 新增保存公共流水号
	 */
	@OperLog(title = "公共流水号", businessType = BusinessType.INSERT)
	@HasPermissions("pts:sys:tSysSerialNumber:add")
	@PostMapping("save")
	public R addSave(@RequestBody TSysSerialNumber tSysSerialNumber)
	{		
		return toAjax(tSysSerialNumberService.insertTSysSerialNumber(tSysSerialNumber));
	}

	/**
	 * 修改保存公共流水号
	 */
	@OperLog(title = "公共流水号", businessType = BusinessType.UPDATE)
	@HasPermissions("pts:sys:tSysSerialNumber:edit")
	@PostMapping("update")
	public R editSave(@RequestBody TSysSerialNumber tSysSerialNumber)
	{		
		return toAjax(tSysSerialNumberService.updateTSysSerialNumber(tSysSerialNumber));
	}
	
	/**
	 * 删除${tableComment}
	 */
	@OperLog(title = "公共流水号", businessType = BusinessType.DELETE)
	@HasPermissions("pts:sys:tSysSerialNumber:remove")
	@PostMapping("remove")
	public R remove(String ids)
	{		
		return toAjax(tSysSerialNumberService.deleteTSysSerialNumberByIds(ids));
	}

	/**
	 * 删除${tableComment}
	 */
	@PostMapping("UUID")
	public R UUID()
	{
		return R.data(IdUtils.fastSimpleUUID());
	}
	/**
	 * 唯一性校验
	 */
	@PostMapping("unique")
	public R unique(@RequestBody CheckUnique checkUnique)
	{
		checkUnique.setIdName("id");
		checkUnique.setTableName("t_sys_serial_number");
		boolean uniqueFlag=utilService.checkUnique(checkUnique);
		if(uniqueFlag)
		{
			return  R.ok();
		}
		return  R.error();
	}
}
