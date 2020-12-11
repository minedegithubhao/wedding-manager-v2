package com.qh.venus.achilles.sms.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel.Type;
import com.qh.venus.achilles.framework.web.domain.BaseEntity;

/**
 * 顶部菜单配置对象 sys_top_menu_setting
 * 
 * @author qh_venus
 * @date 2020-05-14
 */
public class SysTopMenuSetting extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 顶部菜单主键 */
    @Excel(name = "顶部菜单主键")
    private Long topMenuId;

    /** 菜单主键 */
    @Excel(name = "菜单主键")
    private Long menuId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTopMenuId(Long topMenuId) 
    {
        this.topMenuId = topMenuId;
    }

    public Long getTopMenuId() 
    {
        return topMenuId;
    }
    public void setMenuId(Long menuId) 
    {
        this.menuId = menuId;
    }

    public Long getMenuId() 
    {
        return menuId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("topMenuId", getTopMenuId())
            .append("menuId", getMenuId())
            .toString();
    }
}
