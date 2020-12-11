package com.qh.venus.achilles.pts.custom.mapper;

import com.qh.venus.achilles.pts.custom.domain.HunCustom;
import java.util.List;

/**
 * 客户管理Mapper接口
 * 
 * @author wedding
 * @date 2020-11-12
 */
public interface HunCustomMapper 
{
    /**
     * 查询客户管理
     * 
     * @param id 客户管理ID
     * @return 客户管理
     */
    public HunCustom selectHunCustomById(Long id);

    /**
     * 查询客户管理列表
     * 
     * @param hunCustom 客户管理
     * @return 客户管理集合
     */
    public List<HunCustom> selectHunCustomList(HunCustom hunCustom);

    /**
     * 新增客户管理
     * 
     * @param hunCustom 客户管理
     * @return 结果
     */
    public int insertHunCustom(HunCustom hunCustom);

    /**
     * 修改客户管理
     * 
     * @param hunCustom 客户管理
     * @return 结果
     */
    public int updateHunCustom(HunCustom hunCustom);

    /**
     * 删除客户管理
     * 
     * @param id 客户管理ID
     * @return 结果
     */
    public int deleteHunCustomById(Long id);

    /**
     * 批量删除客户管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHunCustomByIds(String[] ids);
}
