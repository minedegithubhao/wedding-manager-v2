package com.qh.venus.achilles.pts.member.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qh.venus.achilles.pts.custom.domain.HunCustom;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel.Type;
import com.qh.venus.achilles.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 会员管理对象 hun_member
 * 
 * @author wedding
 * @date 2020-11-17
 */
public class HunMember extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 删除标记，0-存在，1-删除 */
    private String delFlag;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 备用字段1 */
    @Excel(name = "备用字段1")
    private String parse1;

    /** 备用字段2 */
    @Excel(name = "备用字段2")
    private String parse2;

    /** 备用字段3 */
    @Excel(name = "备用字段3")
    private String parse3;

    /** 备用字段4 */
    @Excel(name = "备用字段4")
    private String parse4;

    /** 备用字段5 */
    @Excel(name = "备用字段5")
    private String parse5;

    /** 顾客id */
    @Excel(name = "顾客id")
    private String cid;

    /** 会员卡类型，1-卡式，2-手机号码，3-其他 */
    @Excel(name = "会员卡类型，1-卡式，2-手机号码，3-其他")
    private String cardType;

    /** 会员卡编号 */
    @Excel(name = "会员卡编号")
    private String cardId;

    /** 会员类型，1-顾客，2-红娘 */
    @Excel(name = "会员类型，1-顾客，2-红娘")
    private String memberType;

    /** 会员等级 */
    @Excel(name = "会员等级")
    private String level;

    /** 入会时间 */
    @Excel(name = "入会时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date joinTime;

    /** 会员卡名称 */
    @Excel(name = "会员卡名称")
    private String cardName;

    /** 已使用次数 */
    @Excel(name = "已使用次数")
    private String useTimes;

    private HunCustom hunCustom;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public HunCustom getHunCustom() {
        return hunCustom;
    }

    public void setHunCustom(HunCustom hunCustom) {
        this.hunCustom = hunCustom;
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
    public void setCid(String cid) 
    {
        this.cid = cid;
    }

    public String getCid() 
    {
        return cid;
    }
    public void setCardType(String cardType) 
    {
        this.cardType = cardType;
    }

    public String getCardType() 
    {
        return cardType;
    }
    public void setCardId(String cardId) 
    {
        this.cardId = cardId;
    }

    public String getCardId() 
    {
        return cardId;
    }
    public void setMemberType(String memberType) 
    {
        this.memberType = memberType;
    }

    public String getMemberType() 
    {
        return memberType;
    }
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setJoinTime(Date joinTime) 
    {
        this.joinTime = joinTime;
    }

    public Date getJoinTime() 
    {
        return joinTime;
    }
    public void setCardName(String cardName) 
    {
        this.cardName = cardName;
    }

    public String getCardName() 
    {
        return cardName;
    }
    public void setUseTimes(String useTimes) 
    {
        this.useTimes = useTimes;
    }

    public String getUseTimes() 
    {
        return useTimes;
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
            .append("cid", getCid())
            .append("cardType", getCardType())
            .append("cardId", getCardId())
            .append("memberType", getMemberType())
            .append("level", getLevel())
            .append("joinTime", getJoinTime())
            .append("cardName", getCardName())
            .append("useTimes", getUseTimes())
            .toString();
    }
}
