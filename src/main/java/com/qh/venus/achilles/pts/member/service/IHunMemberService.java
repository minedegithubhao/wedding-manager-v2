package com.qh.venus.achilles.pts.member.service;

import com.qh.venus.achilles.pts.member.domain.HunMember;
import java.util.List;

/**
 * 会员管理Service接口
 * 
 * @author wedding
 * @date 2020-11-17
 */
public interface IHunMemberService 
{
    /**
     * 查询会员管理
     * 
     * @param id 会员管理ID
     * @return 会员管理
     */
    public HunMember selectHunMemberById(Long id);

    /**
     * 查询会员管理列表
     * 
     * @param hunMember 会员管理
     * @return 会员管理集合
     */
    public List<HunMember> selectHunMemberList(HunMember hunMember);

    /**
     * 新增会员管理
     * 
     * @param hunMember 会员管理
     * @return 结果
     */
    public int insertHunMember(HunMember hunMember);

    /**
     * 修改会员管理
     * 
     * @param hunMember 会员管理
     * @return 结果
     */
    public int updateHunMember(HunMember hunMember);

    /**
     * 批量删除会员管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHunMemberByIds(String ids);

    /**
     * 删除会员管理信息
     * 
     * @param id 会员管理ID
     * @return 结果
     */
    public int deleteHunMemberById(Long id);
}
