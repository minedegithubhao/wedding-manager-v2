package com.qh.venus.achilles.pts.sys.controller;

import com.qh.venus.achilles.common.constant.Constants;
import com.qh.venus.achilles.common.constant.UserConstants;
import com.qh.venus.achilles.common.utils.StringUtils;
import com.qh.venus.achilles.common.utils.file.FileUploadUtils;
import com.qh.venus.achilles.common.utils.file.FileUtils;
import com.qh.venus.achilles.pts.sys.config.DfsConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.pts.sys.domain.TSysFile;
import com.qh.venus.achilles.pts.sys.service.ITSysFileService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * 公共附件 提供者
 *
 * @author qh_venus_zf
 * @date 2020-04-23
 */
@RestController
@RequestMapping("/pts/sys/TSysFile")
@Slf4j
public class TSysFileController extends BaseController {

    @Autowired
    private ITSysFileService tSysFileService;
    @Autowired
    private DfsConfig dfsConfig;

    /**
     * 查询${tableComment}
     */
    @GetMapping("get/{id}")
    public TSysFile get(@PathVariable("id") String id) {
        return tSysFileService.selectTSysFileById(id);

    }

    /**
     * 查询公共附件列表
     */
    @GetMapping("list")
    public R list(TSysFile tSysFile) {
        startPage();
        return result(tSysFileService.selectTSysFileList(tSysFile));
    }


    /**
     * 新增保存公共附件
     */
    @PostMapping("save")
    public R addSave(@RequestBody TSysFile tSysFile) {
        return toAjax(tSysFileService.insertTSysFile(tSysFile));
    }

    /**
     * 修改保存公共附件
     */
    @PostMapping("update")
    public R editSave(@RequestBody TSysFile tSysFile) {
        return toAjax(tSysFileService.updateTSysFile(tSysFile));
    }

    /**
     * 删除${tableComment}
     */
    @PostMapping("remove")
    public R remove(String fileId,Boolean delete) {
        return toAjax(tSysFileService.deleteTSysFileById(fileId, delete));
    }


    /**
     * 文件列表初始化
     */
    @PostMapping("init")
    public R init(String busId) {
        if(StringUtils.isEmpty(busId))
        {
            busId="-1";
        }
        TSysFile tSysFile=new TSysFile();
        tSysFile.setBusId(busId);
        return R.data(tSysFileService.selectTSysFileList(tSysFile));
    }

    /**
     * 通用下载请求
     *
     * @param fileId 文件ID
     * @param delete   是否删除
     */
    @PostMapping("download")
    public void download(String fileId, Boolean delete, HttpServletResponse response, HttpServletRequest request) throws IOException {
        tSysFileService.downloadFile(fileId, delete, response, request);
    }

    /**
     * 通用上传请求
     */
    @PostMapping("upload")
    public R upload(MultipartFile file, HttpServletResponse response, HttpServletRequest request) throws Exception {
        String busId=request.getParameter("busId");
        String isOpen=request.getParameter("isOpen");
        TSysFile tSysFile= new TSysFile();
        tSysFile.setBusId(busId);
        tSysFile.setStatus(UserConstants.NORMAL);
        tSysFile.setDelFlag(UserConstants.NO_DEL_FLAG);
        try {
            // 上传文件路径
            String filePath = "";
            if("1".equals(isOpen)){
                filePath = dfsConfig.getOpenPath();
            }else{
                filePath = dfsConfig.getPath();
            }
            // 上传并返回新文件名称
            String fileRealname=file.getResource().getFilename();
            String fileFullPath = FileUploadUtils.upload(filePath, file);
            String url = dfsConfig.getDomain() + fileFullPath;
            tSysFile.setFileRealname(fileRealname);
            tSysFile.setFileFullpath(fileFullPath);
            tSysFile.setFilePath(fileFullPath.replace(filePath,"/"));
            tSysFile.setStorageName(getStorageName(fileFullPath));
            tSysFile.setStorageType("0");
            tSysFileService.insertTSysFile(tSysFile);
            return R.ok().put("fileId", tSysFile.getId()).put("fileFullPath",fileFullPath).put("filePath",tSysFile.getFilePath());
        } catch (Exception e) {
            log.error("上传文件失败", e);
            return R.error(e.getMessage());
        }
    }

    public String getStorageName(String fileFullpath)
    {
        int index=fileFullpath.lastIndexOf("/");
        return fileFullpath.substring(index+1);

    }
}
