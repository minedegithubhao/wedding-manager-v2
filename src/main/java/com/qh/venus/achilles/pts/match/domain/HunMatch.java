package com.qh.venus.achilles.pts.match.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qh.venus.achilles.pts.custom.domain.HunCustom;
import com.qh.venus.achilles.pts.matchmaker.domain.HunMatchmaker;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel;
import com.qh.venus.achilles.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 配对对象 hun_match
 * 
 * @author qh_venus
 * @date 2020-11-18
 */
public class HunMatch extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 珊瑚标记 */
    private String delFlag;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 备用字段 */
    private String parse1;

    /** $column.columnComment */
    private String parse2;

    /** $column.columnComment */
    private String parse3;

    /** $column.columnComment */
    private String parse4;

    /** $column.columnComment */
    private String parse5;

    /** 男id */
    @Excel(name = "男id")
    private Long mid;

    /** 女id */
    @Excel(name = "女id")
    private Long wid;

    /** 红娘id */
    @Excel(name = "红娘id")
    private Long mmid;

    /** 配对时间 */
    @Excel(name = "配对时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date matchTime;

    /** 配对状态 */
    @Excel(name = "配对状态")
    private String matchStatus;

    /** 配对成功时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date successTime;

    /** 配对失败时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date failedTime;

    /** 配对失败原因 */
    private String failedReason;

    private HunCustom customOne;
    private HunCustom customTwo;
    private HunMatchmaker matchMaker;

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
    public void setMid(Long mid)
    {
        this.mid = mid;
    }

    public Long getMid()
    {
        return mid;
    }
    public void setWid(Long wid)
    {
        this.wid = wid;
    }

    public Long getWid()
    {
        return wid;
    }
    public void setMmid(Long mmid)
    {
        this.mmid = mmid;
    }

    public Long getMmid()
    {
        return mmid;
    }
    public void setMatchTime(Date matchTime) 
    {
        this.matchTime = matchTime;
    }

    public Date getMatchTime() 
    {
        return matchTime;
    }
    public void setMatchStatus(String matchStatus) 
    {
        this.matchStatus = matchStatus;
    }

    public String getMatchStatus() 
    {
        return matchStatus;
    }
    public void setSuccessTime(Date successTime) 
    {
        this.successTime = successTime;
    }

    public Date getSuccessTime() 
    {
        return successTime;
    }
    public void setFailedTime(Date failedTime) 
    {
        this.failedTime = failedTime;
    }

    public Date getFailedTime() 
    {
        return failedTime;
    }
    public void setFailedReason(String failedReason) 
    {
        this.failedReason = failedReason;
    }

    public String getFailedReason() 
    {
        return failedReason;
    }

    public HunCustom getCustomOne() {
        return customOne;
    }

    public void setCustomOne(HunCustom customOne) {
        this.customOne = customOne;
    }

    public HunCustom getCustomTwo() {
        return customTwo;
    }

    public void setCustomTwo(HunCustom customTwo) {
        this.customTwo = customTwo;
    }

    public HunMatchmaker getMatchMaker() {
        return matchMaker;
    }

    public void setMatchMaker(HunMatchmaker matchMaker) {
        this.matchMaker = matchMaker;
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
            .append("matchTime", getMatchTime())
            .append("matchStatus", getMatchStatus())
            .append("successTime", getSuccessTime())
            .append("failedTime", getFailedTime())
            .append("failedReason", getFailedReason())
            .append("customOne", getCustomOne())
            .append("customTwo", getCustomTwo())
            .append("matchMaker", getMatchMaker())
            .toString();
    }
}
