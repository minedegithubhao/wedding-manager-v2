package com.qh.venus.achilles.pts.sys.service;

import com.qh.venus.achilles.pts.sys.domain.TSysFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 公共附件Service接口
 * 
 * @author qh_venus_zf
 * @date 2020-04-23
 */
public interface ITSysFileService 
{
    /**
     * 查询公共附件
     * 
     * @param id 公共附件ID
     * @return 公共附件
     */
    public TSysFile selectTSysFileById(String id);

    /**
     * 查询公共附件列表
     * 
     * @param tSysFile 公共附件
     * @return 公共附件集合
     */
    public List<TSysFile> selectTSysFileList(TSysFile tSysFile);

    /**
     * 新增公共附件
     * 
     * @param tSysFile 公共附件
     * @return 结果
     */
    public int insertTSysFile(TSysFile tSysFile);

    /**
     * 修改公共附件
     * 
     * @param tSysFile 公共附件
     * @return 结果
     */
    public int updateTSysFile(TSysFile tSysFile);

    /**
     * 批量删除公共附件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTSysFileByIds(String ids);

    /**
     * 删除公共附件信息
     * 
     * @param id 公共附件ID
     * @return 结果
     */
    public int deleteTSysFileById(String id, Boolean delete);

    /**
     * 删除公共附件信息
     *
     * @param busId 公共附件busId
     * @return 结果
     */
    public int deleteTSysFileByBusId(String busId, Boolean delete);

    void downloadFile(String fileId, Boolean delete, HttpServletResponse response, HttpServletRequest request);
}
