package com.qh.venus.achilles.pts.sys.mapper;

import com.qh.venus.achilles.pts.sys.domain.TSysSerialNumber;
import java.util.List;

/**
 * 公共流水号Mapper接口
 * 
 * @author qh_venus_zf
 * @date 2020-04-22
 */
public interface TSysSerialNumberMapper 
{
    /**
     * 查询公共流水号
     * 
     * @param id 公共流水号ID
     * @return 公共流水号
     */
    public TSysSerialNumber selectTSysSerialNumberById(String id);

    /**
     * 查询公共流水号列表
     * 
     * @param tSysSerialNumber 公共流水号
     * @return 公共流水号集合
     */
    public List<TSysSerialNumber> selectTSysSerialNumberList(TSysSerialNumber tSysSerialNumber);

    /**
     * 新增公共流水号
     * 
     * @param tSysSerialNumber 公共流水号
     * @return 结果
     */
    public int insertTSysSerialNumber(TSysSerialNumber tSysSerialNumber);

    /**
     * 修改公共流水号
     * 
     * @param tSysSerialNumber 公共流水号
     * @return 结果
     */
    public int updateTSysSerialNumber(TSysSerialNumber tSysSerialNumber);

    /**
     * 删除公共流水号
     * 
     * @param id 公共流水号ID
     * @return 结果
     */
    public int deleteTSysSerialNumberById(String id);

    /**
     * 批量删除公共流水号
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTSysSerialNumberByIds(String[] ids);
    
    
}
