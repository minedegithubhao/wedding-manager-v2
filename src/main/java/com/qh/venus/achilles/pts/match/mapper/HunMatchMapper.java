package com.qh.venus.achilles.pts.match.mapper;

import com.qh.venus.achilles.pts.match.domain.HunMatch;
import java.util.List;

/**
 * 配对Mapper接口
 * 
 * @author qh_venus
 * @date 2020-11-18
 */
public interface HunMatchMapper 
{
    /**
     * 查询配对
     * 
     * @param id 配对ID
     * @return 配对
     */
    public HunMatch selectHunMatchById(Long id);
    /**
     * 查询配对
     *
     * @param customId 配对ID
     * @return 配对
     */
    public List<HunMatch> selectHunMatchByCustomId(Long customId);

    /**
     * 查询配对列表
     * 
     * @param hunMatch 配对
     * @return 配对集合
     */
    public List<HunMatch> selectHunMatchList(HunMatch hunMatch);

    /**
     * 新增配对
     * 
     * @param hunMatch 配对
     * @return 结果
     */
    public int insertHunMatch(HunMatch hunMatch);

    /**
     * 修改配对
     * 
     * @param hunMatch 配对
     * @return 结果
     */
    public int updateHunMatch(HunMatch hunMatch);

    /**
     * 删除配对
     * 
     * @param id 配对ID
     * @return 结果
     */
    public int deleteHunMatchById(Long id);

    /**
     * 批量删除配对
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHunMatchByIds(String[] ids);
}
