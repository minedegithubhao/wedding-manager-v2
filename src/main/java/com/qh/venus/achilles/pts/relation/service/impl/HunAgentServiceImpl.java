package com.qh.venus.achilles.pts.relation.service.impl;

import java.util.List;
import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.common.utils.DateUtils;
import javax.annotation.Resource;
import com.qh.venus.achilles.framework.security.service.TokenService;
import org.springframework.stereotype.Service;
import com.qh.venus.achilles.pts.relation.mapper.HunAgentMapper;
import com.qh.venus.achilles.pts.relation.domain.HunAgent;
import com.qh.venus.achilles.pts.relation.service.IHunAgentService;

/**
 * 代理人Service业务层处理
 * 
 * @author qh_venus
 * @date 2020-11-13
 */
@Service
public class HunAgentServiceImpl implements IHunAgentService 
{
    @Resource
    private HunAgentMapper hunAgentMapper;
    @Resource
    private TokenService tokenService;

    /**
     * 查询代理人
     * 
     * @param id 代理人ID
     * @return 代理人
     */
    @Override
    public HunAgent selectHunAgentById(Long id)
    {
        return hunAgentMapper.selectHunAgentById(id);
    }

    /**
     * 查询代理人列表
     * 
     * @param hunAgent 代理人
     * @return 代理人
     */
    @Override
    public List<HunAgent> selectHunAgentList(HunAgent hunAgent)
    {
        return hunAgentMapper.selectHunAgentList(hunAgent);
    }

    /**
     * 新增代理人
     * 
     * @param hunAgent 代理人
     * @return 结果
     */
    @Override
    public int insertHunAgent(HunAgent hunAgent)
    {
        String userName = tokenService.getLoginUserDefault();
        hunAgent.setCreateBy(userName);
        hunAgent.setCreateTime(DateUtils.getNowDate());
        return hunAgentMapper.insertHunAgent(hunAgent);
    }

    /**
     * 修改代理人
     * 
     * @param hunAgent 代理人
     * @return 结果
     */
    @Override
    public int updateHunAgent(HunAgent hunAgent)
    {
        String userName = tokenService.getLoginUserDefault();
        hunAgent.setUpdateBy(userName);
        hunAgent.setUpdateTime(DateUtils.getNowDate());
        return hunAgentMapper.updateHunAgent(hunAgent);
    }

    /**
     * 删除代理人对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHunAgentByIds(String ids)
    {
        return hunAgentMapper.deleteHunAgentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除代理人信息
     * 
     * @param id 代理人ID
     * @return 结果
     */
    public int deleteHunAgentById(Long id)
    {
        return hunAgentMapper.deleteHunAgentById(id);
    }
}
