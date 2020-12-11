package com.qh.venus.achilles.pts.dating.service.impl;

import java.util.List;
import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.common.utils.DateUtils;
import javax.annotation.Resource;
import com.qh.venus.achilles.framework.security.service.TokenService;
import org.springframework.stereotype.Service;
import com.qh.venus.achilles.pts.dating.mapper.HunDatingMapper;
import com.qh.venus.achilles.pts.dating.domain.HunDating;
import com.qh.venus.achilles.pts.dating.service.IHunDatingService;

/**
 * 相亲Service业务层处理
 * 
 * @author wedding
 * @date 2020-11-21
 */
@Service
public class HunDatingServiceImpl implements IHunDatingService 
{
    @Resource
    private HunDatingMapper hunDatingMapper;
    @Resource
    private TokenService tokenService;

    /**
     * 查询相亲
     * 
     * @param id 相亲ID
     * @return 相亲
     */
    @Override
    public HunDating selectHunDatingById(Long id)
    {
        return hunDatingMapper.selectHunDatingById(id);
    }

    /**
     * 查询相亲列表
     * 
     * @param hunDating 相亲
     * @return 相亲
     */
    @Override
    public List<HunDating> selectHunDatingList(HunDating hunDating)
    {
        return hunDatingMapper.selectHunDatingList(hunDating);
    }

    /**
     * 新增相亲
     * 
     * @param hunDating 相亲
     * @return 结果
     */
    @Override
    public int insertHunDating(HunDating hunDating)
    {
        String userName = tokenService.getLoginUserDefault();
        hunDating.setCreateBy(userName);
        hunDating.setCreateTime(DateUtils.getNowDate());
        return hunDatingMapper.insertHunDating(hunDating);
    }

    /**
     * 修改相亲
     * 
     * @param hunDating 相亲
     * @return 结果
     */
    @Override
    public int updateHunDating(HunDating hunDating)
    {
        String userName = tokenService.getLoginUserDefault();
        hunDating.setUpdateBy(userName);
        hunDating.setUpdateTime(DateUtils.getNowDate());
        return hunDatingMapper.updateHunDating(hunDating);
    }

    /**
     * 删除相亲对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHunDatingByIds(String ids)
    {
        return hunDatingMapper.deleteHunDatingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除相亲信息
     * 
     * @param id 相亲ID
     * @return 结果
     */
    public int deleteHunDatingById(Long id)
    {
        return hunDatingMapper.deleteHunDatingById(id);
    }
}
