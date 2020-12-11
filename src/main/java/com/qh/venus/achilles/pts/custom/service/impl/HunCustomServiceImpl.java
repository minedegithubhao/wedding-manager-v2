package com.qh.venus.achilles.pts.custom.service.impl;

import java.util.List;
import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.common.utils.DateUtils;
import com.qh.venus.achilles.pts.match.domain.HunMatch;
import com.qh.venus.achilles.pts.match.service.IHunMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qh.venus.achilles.pts.custom.mapper.HunCustomMapper;
import com.qh.venus.achilles.pts.custom.domain.HunCustom;
import com.qh.venus.achilles.pts.custom.service.IHunCustomService;

import javax.annotation.Resource;

/**
 * 客户管理Service业务层处理
 * 
 * @author wedding
 * @date 2020-11-12
 */
@Service
public class HunCustomServiceImpl implements IHunCustomService 
{
    @Resource
    private HunCustomMapper hunCustomMapper;
    @Resource
    private IHunMatchService hunMatchService;

    /**
     * 查询客户管理
     * 
     * @param id 客户管理ID
     * @return 客户管理
     */
    @Override
    public HunCustom selectHunCustomById(Long id)
    {
        HunCustom hunCustom = hunCustomMapper.selectHunCustomById(id);
        List<HunMatch> hunMatchList = hunMatchService.selectHunMatchByCustomId(hunCustom.getId());
        int matchSuccess = 0;
        int matchFail = 0;
        int matching = 0;
        for (HunMatch hunMatch : hunMatchList) {
            if ("1".equals(hunMatch.getMatchStatus())) {
                matchSuccess += 1;
            } else if ("2".equals(hunMatch.getMatchStatus())) {
                matchFail += 1;
            } else {
                matching += 1;
            }
        }
        hunCustom.setTotalMatch(hunMatchList.size());
        hunCustom.setMatchSuccess(matchSuccess);
        hunCustom.setMatchFail(matchFail);
        hunCustom.setMatching(matching);
        return hunCustom;
    }

    /**
     * 查询客户管理列表
     * 
     * @param hunCustom2 客户管理
     * @return 客户管理
     */
    @Override
    public List<HunCustom> selectHunCustomList(HunCustom hunCustom2)
    {
        List<HunCustom> list = hunCustomMapper.selectHunCustomList(hunCustom2);
        for (HunCustom hunCustom : list) {
            List<HunMatch> hunMatchList = hunMatchService.selectHunMatchByCustomId(hunCustom.getId());
            int matchSuccess = 0;
            int matchFail = 0;
            int matching = 0;
            for (HunMatch hunMatch : hunMatchList) {
                if ("1".equals(hunMatch.getMatchStatus())) {
                    matchSuccess += 1;
                }
                if ("2".equals(hunMatch.getMatchStatus())) {
                    matchFail += 1;
                } else {
                    matching += 1;
                }
            }
            hunCustom.setTotalMatch(hunMatchList.size());
            hunCustom.setMatchSuccess(matchSuccess);
            hunCustom.setMatchFail(matchFail);
            hunCustom.setMatching(matching);
        }
        return list;
    }

    /**
     * 新增客户管理
     * 
     * @param hunCustom 客户管理
     * @return 结果
     */
    @Override
    public int insertHunCustom(HunCustom hunCustom)
    {
        hunCustom.setCreateTime(DateUtils.getNowDate());
        return hunCustomMapper.insertHunCustom(hunCustom);
    }

    /**
     * 修改客户管理
     * 
     * @param hunCustom 客户管理
     * @return 结果
     */
    @Override
    public int updateHunCustom(HunCustom hunCustom)
    {
        hunCustom.setUpdateTime(DateUtils.getNowDate());
        return hunCustomMapper.updateHunCustom(hunCustom);
    }

    /**
     * 删除客户管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHunCustomByIds(String ids)
    {
        return hunCustomMapper.deleteHunCustomByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户管理信息
     * 
     * @param id 客户管理ID
     * @return 结果
     */
    public int deleteHunCustomById(Long id)
    {
        return hunCustomMapper.deleteHunCustomById(id);
    }
}
