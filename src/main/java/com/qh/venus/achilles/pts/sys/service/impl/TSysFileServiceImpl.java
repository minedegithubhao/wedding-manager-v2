package com.qh.venus.achilles.pts.sys.service.impl;

import java.util.List;
import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.common.utils.DateUtils;
import com.qh.venus.achilles.common.utils.StringUtils;
import com.qh.venus.achilles.common.utils.file.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qh.venus.achilles.pts.sys.mapper.TSysFileMapper;
import com.qh.venus.achilles.pts.sys.domain.TSysFile;
import com.qh.venus.achilles.pts.sys.service.ITSysFileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 公共附件Service业务层处理
 *
 * @author qh_venus_zf
 * @date 2020-04-23
 */
@Service
@Slf4j
public class TSysFileServiceImpl implements ITSysFileService
{
    @Autowired
    private TSysFileMapper tSysFileMapper;

    /**
     * 查询公共附件
     *
     * @param id 公共附件ID
     * @return 公共附件
     */
    @Override
    public TSysFile selectTSysFileById(String id)
    {
        return tSysFileMapper.selectTSysFileById(id);
    }

    /**
     * 查询公共附件列表
     *
     * @param tSysFile 公共附件
     * @return 公共附件
     */
    @Override
    public List<TSysFile> selectTSysFileList(TSysFile tSysFile)
    {
        return tSysFileMapper.selectTSysFileList(tSysFile);
    }

    /**
     * 新增公共附件
     *
     * @param tSysFile 公共附件
     * @return 结果
     */
    @Override
    public int insertTSysFile(TSysFile tSysFile)
    {
        tSysFile.setCreateTime(DateUtils.getNowDate());
        return tSysFileMapper.insertTSysFile(tSysFile);
    }

    /**
     * 修改公共附件
     *
     * @param tSysFile 公共附件
     * @return 结果
     */
    @Override
    public int updateTSysFile(TSysFile tSysFile)
    {
        tSysFile.setUpdateTime(DateUtils.getNowDate());
        return tSysFileMapper.updateTSysFile(tSysFile);
    }

    /**
     * 删除公共附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTSysFileByIds(String ids)
    {
        return tSysFileMapper.deleteTSysFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公共附件信息
     *
     * @param id 公共附件ID
     * @return 结果
     */
    public int deleteTSysFileById(String id, Boolean delete)
    {
        TSysFile tSysFile=tSysFileMapper.selectTSysFileById(id);
        String fileRealname=tSysFile.getFileRealname();
        String fileFullpath = tSysFile.getFileFullpath();
        if (delete)
        {
            FileUtils.deleteFile(fileFullpath);
        }
        return tSysFileMapper.deleteTSysFileById(id);
    }

    /**
     * 删除公共附件信息
     *
     * @param busId 公共附件busId
     * @return 结果
     */
    public int deleteTSysFileByBusId(String busId, Boolean delete)
    {
        if(StringUtils.isEmpty(busId))
        {
            busId="-1";
        }
        TSysFile file=new TSysFile();
        file.setBusId(busId);
        List<TSysFile> flies = selectTSysFileList(file);
        StringBuilder idsBuilder = new StringBuilder();
        for (TSysFile tSysFile: flies) {
            String fileFullpath = tSysFile.getFileFullpath();
            if (delete)
            {
                FileUtils.deleteFile(fileFullpath);
            }
            idsBuilder.append(tSysFile.getId()+",");
        }
        if(!"".equals(idsBuilder.toString())) {
            String ids = idsBuilder.substring(0,idsBuilder.length()-2);
            return tSysFileMapper.deleteTSysFileByIds(Convert.toStrArray(ids));
        }
        return 0;
    }

    @Override
    public void downloadFile(String fileId, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        TSysFile tSysFile = selectTSysFileById(fileId);
        String fileRealname = tSysFile.getFileRealname();
        String fileFullpath = tSysFile.getFileFullpath();
        try
        {
//            if (!FileUtils.isValidFilename(tSysFile.getFileRealname()))
//            {
//                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileRealname));
//            }
            String fileEncode = FileUtils.codeString(fileFullpath);
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");

            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request,fileRealname));
            FileUtils.writeBytes(fileFullpath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(fileFullpath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }
}
