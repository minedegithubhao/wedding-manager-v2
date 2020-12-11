package com.qh.venus.achilles.pts.dating.service;

import com.qh.venus.achilles.pts.dating.domain.HunDating;
import java.util.List;

/**
 * 相亲Service接口
 * 
 * @author wedding
 * @date 2020-11-21
 */
public interface IHunDatingService 
{
    /**
     * 查询相亲
     * 
     * @param id 相亲ID
     * @return 相亲
     */
    public HunDating selectHunDatingById(Long id);

    /**
     * 查询相亲列表
     * 
     * @param hunDating 相亲
     * @return 相亲集合
     */
    public List<HunDating> selectHunDatingList(HunDating hunDating);

    /**
     * 新增相亲
     * 
     * @param hunDating 相亲
     * @return 结果
     */
    public int insertHunDating(HunDating hunDating);

    /**
     * 修改相亲
     * 
     * @param hunDating 相亲
     * @return 结果
     */
    public int updateHunDating(HunDating hunDating);

    /**
     * 批量删除相亲
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHunDatingByIds(String ids);

    /**
     * 删除相亲信息
     * 
     * @param id 相亲ID
     * @return 结果
     */
    public int deleteHunDatingById(Long id);
}
