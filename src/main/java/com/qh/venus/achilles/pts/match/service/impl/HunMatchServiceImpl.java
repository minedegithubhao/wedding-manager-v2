package com.qh.venus.achilles.pts.match.service.impl;

import java.util.List;
import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.common.utils.DateUtils;
import javax.annotation.Resource;
import com.qh.venus.achilles.framework.security.service.TokenService;
import com.qh.venus.achilles.pts.custom.domain.HunCustom;
import com.qh.venus.achilles.pts.custom.service.IHunCustomService;
import com.qh.venus.achilles.pts.matchmaker.service.IHunMatchmakerService;
import org.springframework.stereotype.Service;
import com.qh.venus.achilles.pts.match.mapper.HunMatchMapper;
import com.qh.venus.achilles.pts.match.domain.HunMatch;
import com.qh.venus.achilles.pts.match.service.IHunMatchService;

/**
 * 配对Service业务层处理
 * 
 * @author qh_venus
 * @date 2020-11-18
 */
@Service
public class HunMatchServiceImpl implements IHunMatchService 
{
    @Resource
    private HunMatchMapper hunMatchMapper;
    @Resource
    private TokenService tokenService;
    @Resource
    private IHunCustomService hunCustomService;
    @Resource
    private IHunMatchmakerService hunMatchmakerService;
    /**
     * 查询配对
     * 
     * @param id 配对ID
     * @return 配对
     */
    @Override
    public HunMatch selectHunMatchById(Long id)
    {
        HunMatch hunMatch = hunMatchMapper.selectHunMatchById(id);
        hunMatch.setCustomOne(hunCustomService.selectHunCustomById(hunMatch.getMid()));
        hunMatch.setCustomTwo(hunCustomService.selectHunCustomById(hunMatch.getWid()));
        hunMatch.setMatchMaker(hunMatchmakerService.selectHunMatchmakerById(hunMatch.getMmid()));
        return hunMatch;
    }
    /**
     * 查询配对
     *
     * @param customId 配对ID
     * @return 配对
     */
    @Override
    public List<HunMatch> selectHunMatchByCustomId(Long customId)
    {
        return hunMatchMapper.selectHunMatchByCustomId(customId);
    }

    /**
     * 查询配对列表
     * 
     * @param hunMatch2 配对
     * @return 配对
     */
    @Override
    public List<HunMatch> selectHunMatchList(HunMatch hunMatch2)
    {
        List<HunMatch> list = hunMatchMapper.selectHunMatchList(hunMatch2);
        for (HunMatch hunMatch : list) {
            hunMatch.setCustomOne(hunCustomService.selectHunCustomById(hunMatch.getMid()));
            hunMatch.setCustomTwo(hunCustomService.selectHunCustomById(hunMatch.getWid()));
            hunMatch.setMatchMaker(hunMatchmakerService.selectHunMatchmakerById(hunMatch.getMmid()));
        }
        return list;
    }

    /**
     * 新增配对
     * 
     * @param hunMatch 配对
     * @return 结果
     */
    @Override
    public int insertHunMatch(HunMatch hunMatch)
    {
        String userName = tokenService.getLoginUserDefault();
        hunMatch.setCreateBy(userName);
        hunMatch.setCreateTime(DateUtils.getNowDate());
        hunMatch.setMatchTime(DateUtils.getNowDate());
        return hunMatchMapper.insertHunMatch(hunMatch);
    }

    /**
     * 修改配对
     * 
     * @param hunMatch 配对
     * @return 结果
     */
    @Override
    public int updateHunMatch(HunMatch hunMatch)
    {
        String userName = tokenService.getLoginUserDefault();
        hunMatch.setUpdateBy(userName);
        hunMatch.setUpdateTime(DateUtils.getNowDate());
        return hunMatchMapper.updateHunMatch(hunMatch);
    }

    /**
     * 删除配对对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHunMatchByIds(String ids)
    {
        return hunMatchMapper.deleteHunMatchByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除配对信息
     * 
     * @param id 配对ID
     * @return 结果
     */
    public int deleteHunMatchById(Long id)
    {
        return hunMatchMapper.deleteHunMatchById(id);
    }
}
