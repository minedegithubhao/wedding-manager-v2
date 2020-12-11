package com.qh.venus.achilles.sms.system.service.impl;

import java.util.List;
import com.qh.venus.achilles.common.core.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qh.venus.achilles.sms.system.mapper.SysTopMenuSettingMapper;
import com.qh.venus.achilles.sms.system.domain.SysTopMenuSetting;
import com.qh.venus.achilles.sms.system.service.ISysTopMenuSettingService;

/**
 * 顶部菜单配置Service业务层处理
 * 
 * @author qh_venus
 * @date 2020-05-14
 */
@Service
public class SysTopMenuSettingServiceImpl implements ISysTopMenuSettingService 
{
    @Autowired
    private SysTopMenuSettingMapper sysTopMenuSettingMapper;

    /**
     * 查询顶部菜单配置
     * 
     * @param id 顶部菜单配置ID
     * @return 顶部菜单配置
     */
    @Override
    public SysTopMenuSetting selectSysTopMenuSettingById(Long id)
    {
        return sysTopMenuSettingMapper.selectSysTopMenuSettingById(id);
    }

    /**
     * 查询顶部菜单配置列表
     * 
     * @param sysTopMenuSetting 顶部菜单配置
     * @return 顶部菜单配置
     */
    @Override
    public List<SysTopMenuSetting> selectSysTopMenuSettingList(SysTopMenuSetting sysTopMenuSetting)
    {
        return sysTopMenuSettingMapper.selectSysTopMenuSettingList(sysTopMenuSetting);
    }

    /**
     * 新增顶部菜单配置
     * 
     * @param sysTopMenuSetting 顶部菜单配置
     * @return 结果
     */
    @Override
    public int insertSysTopMenuSetting(SysTopMenuSetting sysTopMenuSetting)
    {
        return sysTopMenuSettingMapper.insertSysTopMenuSetting(sysTopMenuSetting);
    }

    /**
     * 修改顶部菜单配置
     * 
     * @param sysTopMenuSetting 顶部菜单配置
     * @return 结果
     */
    @Override
    public int updateSysTopMenuSetting(SysTopMenuSetting sysTopMenuSetting)
    {
        return sysTopMenuSettingMapper.updateSysTopMenuSetting(sysTopMenuSetting);
    }

    /**
     * 删除顶部菜单配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysTopMenuSettingByIds(String ids)
    {
        return sysTopMenuSettingMapper.deleteSysTopMenuSettingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除顶部菜单配置信息
     * 
     * @param id 顶部菜单配置ID
     * @return 结果
     */
    public int deleteSysTopMenuSettingById(Long id)
    {
        return sysTopMenuSettingMapper.deleteSysTopMenuSettingById(id);
    }
}
