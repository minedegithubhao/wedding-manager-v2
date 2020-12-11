package com.qh.venus.achilles.pts.matchmaker.service;

import com.qh.venus.achilles.pts.matchmaker.domain.HunMatchmaker;
import java.util.List;

/**
 * 红娘管理Service接口
 * 
 * @author wedding
 * @date 2020-11-18
 */
public interface IHunMatchmakerService 
{
    /**
     * 查询红娘管理
     * 
     * @param id 红娘管理ID
     * @return 红娘管理
     */
    public HunMatchmaker selectHunMatchmakerById(Long id);

    /**
     * 查询红娘管理列表
     * 
     * @param hunMatchmaker 红娘管理
     * @return 红娘管理集合
     */
    public List<HunMatchmaker> selectHunMatchmakerList(HunMatchmaker hunMatchmaker);

    /**
     * 新增红娘管理
     * 
     * @param hunMatchmaker 红娘管理
     * @return 结果
     */
    public int insertHunMatchmaker(HunMatchmaker hunMatchmaker);

    /**
     * 修改红娘管理
     * 
     * @param hunMatchmaker 红娘管理
     * @return 结果
     */
    public int updateHunMatchmaker(HunMatchmaker hunMatchmaker);

    /**
     * 批量删除红娘管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHunMatchmakerByIds(String ids);

    /**
     * 删除红娘管理信息
     * 
     * @param id 红娘管理ID
     * @return 结果
     */
    public int deleteHunMatchmakerById(Long id);
}
