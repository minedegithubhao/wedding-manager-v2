package com.qh.venus.achilles.pts.matchmaker.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel.Type;
import com.qh.venus.achilles.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 红娘管理对象 hun_matchmaker
 * 
 * @author wedding
 * @date 2020-11-18
 */
public class HunMatchmaker extends BaseEntity
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

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别，1-男，2-女 */
    @Excel(name = "性别，1-男，2-女")
    private String sex;

    /** 生日 */
    private Date birthday;

    /** 家庭地址 */
    private String homeAddr;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 微信号 */
    @Excel(name = "微信号")
    private String wechat;

    /** qq号 */
    @Excel(name = "qq号")
    private String qq;

    /** 邮箱 */
    private String email;

    /** 员工类型，1-招聘，2-合作 */
    @Excel(name = "员工类型，1-招聘，2-合作")
    private String type;

    /** 是否掌握资源，1-掌握，2-未掌握 */
    @Excel(name = "是否掌握资源，1-掌握，2-未掌握")
    private String source;

    /** 提成类型，1-比例 */
    @Excel(name = "提成类型，1-比例")
    private String presentType;

    /** 提成值 */
    @Excel(name = "提成值")
    private String persentValue;

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
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setHomeAddr(String homeAddr) 
    {
        this.homeAddr = homeAddr;
    }

    public String getHomeAddr() 
    {
        return homeAddr;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setPresentType(String presentType) 
    {
        this.presentType = presentType;
    }

    public String getPresentType() 
    {
        return presentType;
    }
    public void setPersentValue(String persentValue) 
    {
        this.persentValue = persentValue;
    }

    public String getPersentValue() 
    {
        return persentValue;
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
            .append("sex", getSex())
            .append("birthday", getBirthday())
            .append("homeAddr", getHomeAddr())
            .append("phone", getPhone())
            .append("wechat", getWechat())
            .append("qq", getQq())
            .append("email", getEmail())
            .append("type", getType())
            .append("source", getSource())
            .append("presentType", getPresentType())
            .append("persentValue", getPersentValue())
            .toString();
    }
}
