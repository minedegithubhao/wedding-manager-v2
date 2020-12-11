package com.qh.venus.achilles.pts.relation.mapper;

import com.qh.venus.achilles.pts.relation.domain.HunAgent;
import java.util.List;

/**
 * 代理人Mapper接口
 * 
 * @author qh_venus
 * @date 2020-11-13
 */
public interface HunAgentMapper 
{
    /**
     * 查询代理人
     * 
     * @param id 代理人ID
     * @return 代理人
     */
    public HunAgent selectHunAgentById(Long id);

    /**
     * 查询代理人列表
     * 
     * @param hunAgent 代理人
     * @return 代理人集合
     */
    public List<HunAgent> selectHunAgentList(HunAgent hunAgent);

    /**
     * 新增代理人
     * 
     * @param hunAgent 代理人
     * @return 结果
     */
    public int insertHunAgent(HunAgent hunAgent);

    /**
     * 修改代理人
     * 
     * @param hunAgent 代理人
     * @return 结果
     */
    public int updateHunAgent(HunAgent hunAgent);

    /**
     * 删除代理人
     * 
     * @param id 代理人ID
     * @return 结果
     */
    public int deleteHunAgentById(Long id);

    /**
     * 批量删除代理人
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHunAgentByIds(String[] ids);
}
