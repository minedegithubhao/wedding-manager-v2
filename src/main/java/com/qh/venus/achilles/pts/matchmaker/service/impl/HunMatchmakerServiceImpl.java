package com.qh.venus.achilles.pts.matchmaker.service.impl;

import java.util.List;
import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.common.utils.DateUtils;
import javax.annotation.Resource;
import com.qh.venus.achilles.framework.security.service.TokenService;
import org.springframework.stereotype.Service;
import com.qh.venus.achilles.pts.matchmaker.mapper.HunMatchmakerMapper;
import com.qh.venus.achilles.pts.matchmaker.domain.HunMatchmaker;
import com.qh.venus.achilles.pts.matchmaker.service.IHunMatchmakerService;

/**
 * 红娘管理Service业务层处理
 * 
 * @author wedding
 * @date 2020-11-18
 */
@Service
public class HunMatchmakerServiceImpl implements IHunMatchmakerService 
{
    @Resource
    private HunMatchmakerMapper hunMatchmakerMapper;
    @Resource
    private TokenService tokenService;

    /**
     * 查询红娘管理
     * 
     * @param id 红娘管理ID
     * @return 红娘管理
     */
    @Override
    public HunMatchmaker selectHunMatchmakerById(Long id)
    {
        return hunMatchmakerMapper.selectHunMatchmakerById(id);
    }

    /**
     * 查询红娘管理列表
     * 
     * @param hunMatchmaker 红娘管理
     * @return 红娘管理
     */
    @Override
    public List<HunMatchmaker> selectHunMatchmakerList(HunMatchmaker hunMatchmaker)
    {
        return hunMatchmakerMapper.selectHunMatchmakerList(hunMatchmaker);
    }

    /**
     * 新增红娘管理
     * 
     * @param hunMatchmaker 红娘管理
     * @return 结果
     */
    @Override
    public int insertHunMatchmaker(HunMatchmaker hunMatchmaker)
    {
        String userName = tokenService.getLoginUserDefault();
        hunMatchmaker.setCreateBy(userName);
        hunMatchmaker.setCreateTime(DateUtils.getNowDate());
        return hunMatchmakerMapper.insertHunMatchmaker(hunMatchmaker);
    }

    /**
     * 修改红娘管理
     * 
     * @param hunMatchmaker 红娘管理
     * @return 结果
     */
    @Override
    public int updateHunMatchmaker(HunMatchmaker hunMatchmaker)
    {
        String userName = tokenService.getLoginUserDefault();
        hunMatchmaker.setUpdateBy(userName);
        hunMatchmaker.setUpdateTime(DateUtils.getNowDate());
        return hunMatchmakerMapper.updateHunMatchmaker(hunMatchmaker);
    }

    /**
     * 删除红娘管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHunMatchmakerByIds(String ids)
    {
        return hunMatchmakerMapper.deleteHunMatchmakerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除红娘管理信息
     * 
     * @param id 红娘管理ID
     * @return 结果
     */
    public int deleteHunMatchmakerById(Long id)
    {
        return hunMatchmakerMapper.deleteHunMatchmakerById(id);
    }
}
