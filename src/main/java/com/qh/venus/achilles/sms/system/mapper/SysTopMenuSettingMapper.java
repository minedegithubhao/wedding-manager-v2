package com.qh.venus.achilles.sms.system.mapper;

import com.qh.venus.achilles.sms.system.domain.SysTopMenuSetting;
import java.util.List;

/**
 * 顶部菜单配置Mapper接口
 * 
 * @author qh_venus
 * @date 2020-05-14
 */
public interface SysTopMenuSettingMapper 
{
    /**
     * 查询顶部菜单配置
     * 
     * @param id 顶部菜单配置ID
     * @return 顶部菜单配置
     */
    public SysTopMenuSetting selectSysTopMenuSettingById(Long id);

    /**
     * 查询顶部菜单配置列表
     * 
     * @param sysTopMenuSetting 顶部菜单配置
     * @return 顶部菜单配置集合
     */
    public List<SysTopMenuSetting> selectSysTopMenuSettingList(SysTopMenuSetting sysTopMenuSetting);

    /**
     * 新增顶部菜单配置
     * 
     * @param sysTopMenuSetting 顶部菜单配置
     * @return 结果
     */
    public int insertSysTopMenuSetting(SysTopMenuSetting sysTopMenuSetting);

    /**
     * 修改顶部菜单配置
     * 
     * @param sysTopMenuSetting 顶部菜单配置
     * @return 结果
     */
    public int updateSysTopMenuSetting(SysTopMenuSetting sysTopMenuSetting);

    /**
     * 删除顶部菜单配置
     * 
     * @param id 顶部菜单配置ID
     * @return 结果
     */
    public int deleteSysTopMenuSettingById(Long id);

    /**
     * 根据topMenuId删除顶部菜单配置
     *
     * @param id 顶部菜单ID
     * @return 结果
     */
    public int deleteTopMenuSettingsByTopMenuId(Long id);

    /**
     * 批量删除顶部菜单配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysTopMenuSettingByIds(String[] ids);

    /**
     * 批量新增顶部菜单与菜单配置信息
     *
     * @param roleMenuList
     *            角色菜单列表
     * @return 结果
     */
    public int batchTopMenuSettings(List<SysTopMenuSetting> roleMenuList);

    /**
     * 根据菜单ID批量删除顶部菜单与菜单配置信息
     *
     * @param menuIds
     *            角色菜单列表
     * @return 结果
     */
    public int deleteTopMenuSettingsByMenuIds(List<Long> menuIds);

    /**
     * 根据顶部菜单ID批量删除顶部菜单与菜单配置信息
     *
     * @param topMenuIds
     *            角色菜单列表
     * @return 结果
     */
    public int deleteTopMenuSettingsByTopMenuIds(String[] topMenuIds);
}
