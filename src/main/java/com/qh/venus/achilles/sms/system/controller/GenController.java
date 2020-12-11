package com.qh.venus.achilles.sms.system.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.framework.auth.annotation.HasPermissions;
import com.qh.venus.achilles.framework.log.annotation.OperLog;
import com.qh.venus.achilles.framework.log.enums.BusinessType;
import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.framework.web.page.TableDataInfo;
import com.qh.venus.achilles.sms.system.domain.GenTable;
import com.qh.venus.achilles.sms.system.domain.GenTableColumn;
import com.qh.venus.achilles.sms.system.service.IGenTableColumnService;
import com.qh.venus.achilles.sms.system.service.IGenTableService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @Title:代码生成 操作处理
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@RestController
@RequestMapping("gen")
public class GenController extends BaseController
{
    @Autowired
    private IGenTableService genTableService;

    @Autowired
    private IGenTableColumnService genTableColumnService;

    /**
     * 查询代码生成列表
     */
    @HasPermissions("tool:gen:list")
    @GetMapping("/list")
    public TableDataInfo genList(GenTable genTable)
    {
        startPage();
        List<GenTable> list = genTableService.selectGenTableList(genTable);
        return getDataTable(list);
    }
    
    /**
     * 修改代码生成业务
     */
    @GetMapping("/get/{tableId}")
    public R get(@PathVariable("tableId") Long tableId)
    {
        GenTable table = genTableService.selectGenTableById(tableId);
        return R.data(table);
    }

    /**
     * 查询数据库列表
     */
    @HasPermissions("tool:gen:list")
    @GetMapping("/db/list")
    public R dataList(GenTable genTable)
    {
        startPage();
        List<GenTable> list = genTableService.selectDbTableList(genTable);
        return result(list);
    }

    /**
     * 查询数据表字段列表
     */
    @HasPermissions("tool:gen:edit")
    @GetMapping("edit")
    public R edit(GenTableColumn genTableColumn)
    {
        List<GenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(genTableColumn);
        GenTable table = genTableService.selectGenTableById(genTableColumn.getTableId());
        return R.data(table).put("rows",list).put("total", list.size());
    }

    /**
     * 导入表结构（保存）
     */
    @HasPermissions("tool:gen:list")
    @OperLog(title = "代码生成", businessType = BusinessType.IMPORT)
    @PostMapping("/importTable")
    public R importTableSave(String tables)
    {
        String[] tableNames = Convert.toStrArray(tables);
        // 查询表信息
        List<GenTable> tableList = genTableService.selectDbTableListByNames(tableNames);
        String operName = getLoginName();
        genTableService.importGenTable(tableList, operName);
        return R.ok();
    }

    /**
     * 修改保存代码生成业务
     */
    @HasPermissions("tool:gen:edit")
    @OperLog(title = "代码生成", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public R editSave(@RequestBody @Validated GenTable genTable)
    {
        genTableService.validateEdit(genTable);
        genTableService.updateGenTable(genTable);
        return R.ok();
    }

    @HasPermissions("tool:gen:remove")
    @OperLog(title = "代码生成", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    public R remove(String ids)
    {
        genTableService.deleteGenTableByIds(ids);
        return R.ok();
    }

    /**
     * 预览代码
     */
    @HasPermissions("tool:gen:preview")
    @GetMapping("/preview/{tableId}")
    public R preview(@PathVariable("tableId") Long tableId) throws IOException
    {
        Map<String, String> dataMap = genTableService.previewCode(tableId);
        return R.data(dataMap);
    }

    /**
     * 生成代码
     */
    @HasPermissions("tool:gen:code")
    @OperLog(title = "代码生成", businessType = BusinessType.GENCODE)
    @GetMapping("/genCode/{tableName}")
    public void genCode(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException
    {
        byte[] data = genTableService.generatorCode(tableName);
        genCode(response, data);
    }


    /**
     * 批量生成代码
     */
    @HasPermissions("tool:gen:code")
    @OperLog(title = "代码生成", businessType = BusinessType.GENCODE)
    @GetMapping("/batchGenCode")
    public void batchGenCode(HttpServletResponse response, String tables) throws IOException
    {
        String[] tableNames = Convert.toStrArray(tables);
        byte[] data = genTableService.generatorCode(tableNames);
        genCode(response, data);
    }

    /**
     * 生成zip文件
     */
    private void genCode(HttpServletResponse response, byte[] data) throws IOException
    {
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=pts.zip");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }
}