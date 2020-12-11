package com.qh.venus.achilles.sms.system.service;

import com.qh.venus.achilles.sms.system.domain.SysTopMenu;
import java.util.List;

/**
 * 顶部菜单Service接口
 * 
 * @author qh_venus
 * @date 2020-05-12
 */
public interface ISysTopMenuService 
{
    /**
     * 查询顶部菜单
     * 
     * @param id 顶部菜单ID
     * @return 顶部菜单
     */
    public SysTopMenu selectSysTopMenuById(Long id);

    /**
     * 查询顶部菜单列表
     * 
     * @param sysTopMenu 顶部菜单
     * @return 顶部菜单集合
     */
    public List<SysTopMenu> selectSysTopMenuList(SysTopMenu sysTopMenu);

    /**
     * 新增顶部菜单
     * 
     * @param sysTopMenu 顶部菜单
     * @return 结果
     */
    public int insertSysTopMenu(SysTopMenu sysTopMenu);

    /**
     * 修改顶部菜单
     * 
     * @param sysTopMenu 顶部菜单
     * @return 结果
     */
    public int updateSysTopMenu(SysTopMenu sysTopMenu);

    /**
     * 批量删除顶部菜单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysTopMenuByIds(String ids);

    /**
     * 删除顶部菜单信息
     * 
     * @param id 顶部菜单ID
     * @return 结果
     */
    public int deleteSysTopMenuById(Long id);
}
