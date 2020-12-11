package com.qh.venus.achilles.pts.member.service.impl;

import java.util.List;
import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.common.utils.DateUtils;
import javax.annotation.Resource;
import com.qh.venus.achilles.framework.security.service.TokenService;
import org.springframework.stereotype.Service;
import com.qh.venus.achilles.pts.member.mapper.HunMemberMapper;
import com.qh.venus.achilles.pts.member.domain.HunMember;
import com.qh.venus.achilles.pts.member.service.IHunMemberService;

/**
 * 会员管理Service业务层处理
 * 
 * @author wedding
 * @date 2020-11-17
 */
@Service
public class HunMemberServiceImpl implements IHunMemberService 
{
    @Resource
    private HunMemberMapper hunMemberMapper;
    @Resource
    private TokenService tokenService;

    /**
     * 查询会员管理
     * 
     * @param id 会员管理ID
     * @return 会员管理
     */
    @Override
    public HunMember selectHunMemberById(Long id)
    {
        return hunMemberMapper.selectHunMemberById(id);
    }

    /**
     * 查询会员管理列表
     * 
     * @param hunMember 会员管理
     * @return 会员管理
     */
    @Override
    public List<HunMember> selectHunMemberList(HunMember hunMember)
    {
        return hunMemberMapper.selectHunMemberList(hunMember);
    }

    /**
     * 新增会员管理
     * 
     * @param hunMember 会员管理
     * @return 结果
     */
    @Override
    public int insertHunMember(HunMember hunMember)
    {
        String userName = tokenService.getLoginUserDefault();
        hunMember.setCreateBy(userName);
        hunMember.setCreateTime(DateUtils.getNowDate());
        return hunMemberMapper.insertHunMember(hunMember);
    }

    /**
     * 修改会员管理
     * 
     * @param hunMember 会员管理
     * @return 结果
     */
    @Override
    public int updateHunMember(HunMember hunMember)
    {
        String userName = tokenService.getLoginUserDefault();
        hunMember.setUpdateBy(userName);
        hunMember.setUpdateTime(DateUtils.getNowDate());
        return hunMemberMapper.updateHunMember(hunMember);
    }

    /**
     * 删除会员管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHunMemberByIds(String ids)
    {
        return hunMemberMapper.deleteHunMemberByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会员管理信息
     * 
     * @param id 会员管理ID
     * @return 结果
     */
    public int deleteHunMemberById(Long id)
    {
        return hunMemberMapper.deleteHunMemberById(id);
    }
}
