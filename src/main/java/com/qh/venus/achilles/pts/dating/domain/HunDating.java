package com.qh.venus.achilles.pts.dating.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qh.venus.achilles.pts.custom.domain.HunCustom;
import com.qh.venus.achilles.pts.matchmaker.domain.HunMatchmaker;
import com.qh.venus.achilles.pts.member.domain.HunMember;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel.Type;
import com.qh.venus.achilles.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 相亲对象 hun_dating
 * 
 * @author wedding
 * @date 2020-11-21
 */
public class HunDating extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 删除标记，0-存在，1-删除 */
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

    /** 男id */
    @Excel(name = "男id")
    private String mid;

    /** 女id */
    @Excel(name = "女id")
    private String wid;

    /** 红娘id */
    @Excel(name = "红娘id")
    private String mmid;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 约会时间 */
    @Excel(name = "约会时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datingTime;

    /** 约会经过 */
    @Excel(name = "约会经过")
    private String result;

    /** 男性会员 */
    @Excel(name = "男性会员")
    private String mname;

    /** 女性会员 */
    @Excel(name = "女性会员")
    private String wname;

    /** 红娘 */
    @Excel(name = "红娘")
    private String mmname;

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getMmname() {
        return mmname;
    }

    public void setMmname(String mmname) {
        this.mmname = mmname;
    }

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
    public void setMid(String mid) 
    {
        this.mid = mid;
    }

    public String getMid() 
    {
        return mid;
    }
    public void setWid(String wid) 
    {
        this.wid = wid;
    }

    public String getWid() 
    {
        return wid;
    }
    public void setMmid(String mmid) 
    {
        this.mmid = mmid;
    }

    public String getMmid() 
    {
        return mmid;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setDatingTime(Date datingTime) 
    {
        this.datingTime = datingTime;
    }

    public Date getDatingTime() 
    {
        return datingTime;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
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
            .append("mid", getMid())
            .append("wid", getWid())
            .append("mmid", getMmid())
            .append("title", getTitle())
            .append("datingTime", getDatingTime())
            .append("result", getResult())
            .toString();
    }
}
