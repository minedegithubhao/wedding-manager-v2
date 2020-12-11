package com.qh.venus.achilles.sms.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel.Type;
import com.qh.venus.achilles.framework.web.domain.BaseEntity;

import java.util.List;

/**
 * 顶部菜单对象 sys_top_menu
 * 
 * @author qh_venus
 * @date 2020-05-12
 */
public class SysTopMenu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 顶部菜单编号 */
    @Excel(name = "首页唯一键")
    private String code;

    /** 顶部菜单名称 */
    @Excel(name = "顶部菜单名")
    private String name;

    /** 首页地址 */
    @Excel(name = "菜单布局")
    private String component;

    /** 首页名称 */
    @Excel(name = "顶部菜单资源")
    private String source;

    /** 打开方式 */
    @Excel(name = "打开方式")
    private String target;

    /** 权限标识 */
    @Excel(name = "权限标识")
    private String perms;

    /** 菜单图标 */
    @Excel(name = "菜单图标")
    private String icon;

    /** 重定向 */
    @Excel(name = "重定向")
    private String redirect;

    /** 菜单状态（0显示 1隐藏） */
    @Excel(name = "菜单状态", readConverterExp = "0=显示,1=隐藏")
    private String visible;

    /** 导航模式 */
    @Excel(name = "导航模式")
        private String layoutMode;

    /** 多页签模式 */
    @Excel(name = "多页签模式")
    private String multiTab;

    /** 顶部菜单排序 */
    @Excel(name = "顶部菜单排序")
    private Integer orderNum;

    /** 创建人 */
    private Long createUser;

    /** 创建部门 */
    private Long createDept;

    /** 修改人 */
    private Long updateUser;

    /** 状态 */
    private Integer status;

    /** 菜单组 */
    private List<Long> menuIds;

    /** 是否已删除 */
    private String busId;

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setComponent(String component) 
    {
        this.component = component;
    }

    public String getComponent() 
    {
        return component;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setTarget(String target) 
    {
        this.target = target;
    }

    public String getTarget() 
    {
        return target;
    }
    public void setPerms(String perms) 
    {
        this.perms = perms;
    }

    public String getPerms() 
    {
        return perms;
    }
    public void setIcon(String icon) 
    {
        this.icon = icon;
    }

    public String getIcon() 
    {
        return icon;
    }
    public void setRedirect(String redirect) 
    {
        this.redirect = redirect;
    }

    public String getRedirect() 
    {
        return redirect;
    }
    public void setVisible(String visible) 
    {
        this.visible = visible;
    }

    public String getVisible() 
    {
        return visible;
    }
    public void setLayoutMode(String layoutMode)
    {
        this.layoutMode = layoutMode;
    }

    public String getLayoutMode()
    {
        return layoutMode;
    }
    public void setMultiTab(String multiTab)
    {
        this.multiTab = multiTab;
    }

    public String getMultiTab()
    {
        return multiTab;
    }
    public void setOrderNum(Integer orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() 
    {
        return orderNum;
    }
    public void setCreateUser(Long createUser) 
    {
        this.createUser = createUser;
    }

    public Long getCreateUser() 
    {
        return createUser;
    }
    public void setCreateDept(Long createDept) 
    {
        this.createDept = createDept;
    }

    public Long getCreateDept() 
    {
        return createDept;
    }
    public void setUpdateUser(Long updateUser) 
    {
        this.updateUser = updateUser;
    }

    public Long getUpdateUser() 
    {
        return updateUser;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setBusId(String busId)
    {
        this.busId = busId;
    }

    public String getBusId()
    {
        return busId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("component", getComponent())
            .append("source", getSource())
            .append("target", getTarget())
            .append("perms", getPerms())
            .append("icon", getIcon())
            .append("redirect", getRedirect())
            .append("visible", getVisible())
            .append("layoutMode", getLayoutMode())
            .append("multiTab", getMultiTab())
            .append("orderNum", getOrderNum())
            .append("createUser", getCreateUser())
            .append("createDept", getCreateDept())
            .append("createTime", getCreateTime())
            .append("updateUser", getUpdateUser())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("busId", getBusId())
            .append("menuIds", getMenuIds())
            .toString();
    }
}
