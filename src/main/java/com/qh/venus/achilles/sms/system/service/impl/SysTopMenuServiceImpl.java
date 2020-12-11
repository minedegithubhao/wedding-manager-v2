package com.qh.venus.achilles.sms.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.qh.venus.achilles.common.core.text.Convert;
import com.qh.venus.achilles.common.utils.DateUtils;
import com.qh.venus.achilles.pts.sys.mapper.TSysFileMapper;
import com.qh.venus.achilles.sms.system.domain.SysTopMenuSetting;
import com.qh.venus.achilles.sms.system.mapper.SysTopMenuSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qh.venus.achilles.sms.system.mapper.SysTopMenuMapper;
import com.qh.venus.achilles.sms.system.domain.SysTopMenu;
import com.qh.venus.achilles.sms.system.service.ISysTopMenuService;

/**
 * 顶部菜单Service业务层处理
 * 
 * @author qh_venus
 * @date 2020-05-12
 */
@Service
public class SysTopMenuServiceImpl implements ISysTopMenuService 
{
    @Autowired
    private SysTopMenuMapper sysTopMenuMapper;

    @Autowired
    private SysTopMenuSettingMapper sysTopMenuSettingMapper;
    /**
     * 查询顶部菜单
     * 
     * @param id 顶部菜单ID
     * @return 顶部菜单
     */
    @Override
    public SysTopMenu selectSysTopMenuById(Long id)
    {
        return sysTopMenuMapper.selectSysTopMenuById(id);
    }

    /**
     * 查询顶部菜单列表
     * 
     * @param sysTopMenu 顶部菜单
     * @return 顶部菜单
     */
    @Override
    public List<SysTopMenu> selectSysTopMenuList(SysTopMenu sysTopMenu)
    {
        return sysTopMenuMapper.selectSysTopMenuList(sysTopMenu);
    }

    /**
     * 新增顶部菜单
     * 
     * @param sysTopMenu 顶部菜单
     * @return 结果
     */
    @Override
    public int insertSysTopMenu(SysTopMenu sysTopMenu)
    {
        sysTopMenu.setCreateTime(DateUtils.getNowDate());
        if (sysTopMenu.getMenuIds().size() > 0) {
            sysTopMenuSettingMapper.deleteTopMenuSettingsByMenuIds(sysTopMenu.getMenuIds());
        }
        sysTopMenuMapper.insertSysTopMenu(sysTopMenu);
        return insertTopMenu(sysTopMenu);
    }

    /**
     * 修改顶部菜单
     * 
     * @param sysTopMenu 顶部菜单
     * @return 结果
     */
    @Override
    public int updateSysTopMenu(SysTopMenu sysTopMenu)
    {
        sysTopMenu.setUpdateTime(DateUtils.getNowDate());
        if (sysTopMenu.getMenuIds().size() > 0) {
            sysTopMenuSettingMapper.deleteTopMenuSettingsByMenuIds(sysTopMenu.getMenuIds());
        }
        sysTopMenuMapper.updateSysTopMenu(sysTopMenu);
        sysTopMenuSettingMapper.deleteTopMenuSettingsByTopMenuId(sysTopMenu.getId());
        return insertTopMenu(sysTopMenu);
    }

    /**
     * 新增顶部菜单与菜单关联信息
     *
     * @param sysTopMenu
     *            角色对象
     */
    public int insertTopMenu(SysTopMenu sysTopMenu) {
        int rows = 1;
        // 新增用户与角色管理
        List<SysTopMenuSetting> list = new ArrayList<SysTopMenuSetting>();
        for (Long menuId : sysTopMenu.getMenuIds()) {
            SysTopMenuSetting stms = new SysTopMenuSetting();
            stms.setTopMenuId(sysTopMenu.getId());
            stms.setMenuId(menuId);
            list.add(stms);
        }
        if (list.size() > 0) {
            rows = sysTopMenuSettingMapper.batchTopMenuSettings(list);
        }
        return rows;
    }
    /**
     * 删除顶部菜单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysTopMenuByIds(String ids)
    {
        sysTopMenuSettingMapper.deleteTopMenuSettingsByTopMenuIds(Convert.toStrArray(ids));
        return sysTopMenuMapper.deleteSysTopMenuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除顶部菜单信息
     * 
     * @param id 顶部菜单ID
     * @return 结果
     */
    public int deleteSysTopMenuById(Long id)
    {
        return sysTopMenuMapper.deleteSysTopMenuById(id);
    }
}
