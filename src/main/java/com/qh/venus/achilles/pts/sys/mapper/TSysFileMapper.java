package com.qh.venus.achilles.pts.sys.mapper;

import com.qh.venus.achilles.pts.sys.domain.TSysFile;
import java.util.List;

/**
 * 公共附件Mapper接口
 * 
 * @author qh_venus_zf
 * @date 2020-04-23
 */
public interface TSysFileMapper 
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
     * 删除公共附件
     * 
     * @param id 公共附件ID
     * @return 结果
     */
    public int deleteTSysFileById(String id);

    /**
     * 批量删除公共附件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTSysFileByIds(String[] ids);
}
