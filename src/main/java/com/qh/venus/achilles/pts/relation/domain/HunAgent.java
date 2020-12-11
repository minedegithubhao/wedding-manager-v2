package com.qh.venus.achilles.pts.relation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel.Type;
import com.qh.venus.achilles.framework.web.domain.BaseEntity;

/**
 * 代理人对象 hun_agent
 * 
 * @author qh_venus
 * @date 2020-11-13
 */
public class HunAgent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 删除标记 */
    private String delFlag;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 备用字段 */
    private String parse1;

    /** 备用字段 */
    private String parse2;

    /** 备用字段 */
    private String parse3;

    /** 备用字段 */
    private String parse4;

    /** 备用字段 */
    private String parse5;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 与代理人关系 */
    @Excel(name = "与代理人关系")
    private String relation;

    /** 微信 */
    @Excel(name = "微信")
    private String wechat;

    /** QQ */
    @Excel(name = "QQ")
    private String qq;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setParse1(String parse1) 
    {
        this.parse1 = parse1;
    }

    public String getParse1() 
    {
        return parse1;
    }
    public void setParse2(String parse2) 
    {
        this.parse2 = parse2;
    }

    public String getParse2() 
    {
        return parse2;
    }
    public void setParse3(String parse3) 
    {
        this.parse3 = parse3;
    }

    public String getParse3() 
    {
        return parse3;
    }
    public void setParse4(String parse4) 
    {
        this.parse4 = parse4;
    }

    public String getParse4() 
    {
        return parse4;
    }
    public void setParse5(String parse5) 
    {
        this.parse5 = parse5;
    }

    public String getParse5() 
    {
        return parse5;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setRelation(String relation) 
    {
        this.relation = relation;
    }

    public String getRelation() 
    {
        return relation;
    }
    public void setWechat(String wechat) 
    {
        this.wechat = wechat;
    }

    public String getWechat() 
    {
        return wechat;
    }
    public void setQq(String qq) 
    {
        this.qq = qq;
    }

    public String getQq() 
    {
        return qq;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("parse1", getParse1())
            .append("parse2", getParse2())
            .append("parse3", getParse3())
            .append("parse4", getParse4())
            .append("parse5", getParse5())
            .append("name", getName())
            .append("phone", getPhone())
            .append("relation", getRelation())
            .append("wechat", getWechat())
            .append("qq", getQq())
            .append("email", getEmail())
            .toString();
    }
}
