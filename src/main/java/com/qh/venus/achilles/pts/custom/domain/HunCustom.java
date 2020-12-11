package com.qh.venus.achilles.pts.custom.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qh.venus.achilles.pts.relation.domain.HunAgent;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel.Type;
import com.qh.venus.achilles.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 客户管理对象 hun_custom
 * 
 * @author wedding
 * @date 2020-11-12
 */
public class HunCustom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 删除标记，0-未删除，1-已删除 */
    private String delFlag;

    /** 状态，1-离职，2-停用 */
    @Excel(name = "状态，1-离职，2-停用")
    private String status;

    /** 优先级 */
    @Excel(name = "优先级")
    private String parse1;

    /** 备用字段 */
    @Excel(name = "备用字段")
    private String parse2;

    /** 备用字段 */
    @Excel(name = "备用字段")
    private String parse3;

    /** 备用字段 */
    @Excel(name = "备用字段")
    private String parse4;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 姓别 */
    @Excel(name = "姓别")
    private String sex;

    /** 民族 */
    @Excel(name = "民族")
    private String nation;

    /** 出生日期 */
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String nativePlace;

    /** 血型,1-A,2-B,3-AB,4-o,5-其他 */
    @Excel(name = "血型,1-A,2-B,3-AB,4-o,5-其他")
    private String blood;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 身高 */
    @Excel(name = "身高")
    private String height;

    /** 体重 */
    @Excel(name = "体重")
    private String weight;

    /** 身体状况 */
    @Excel(name = "身体状况")
    private String physicalCondition;

    /** 兴趣好爱 */
    @Excel(name = "兴趣好爱")
    private String hobby;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String graduationCollage;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 职业 */
    @Excel(name = "职业")
    private String job;

    /** 工作地址 */
    @Excel(name = "工作地址")
    private String jobAddr;

    /** 照片 */
    @Excel(name = "照片")
    private String pic;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String homeAddr;

    /** 家庭情况 */
    @Excel(name = "家庭情况")
    private String homeDesc;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 微信号 */
    @Excel(name = "微信号")
    private String wechat;

    /** QQ号 */
    @Excel(name = "QQ号")
    private String qq;

    /** $column.columnComment */
    @Excel(name = "QQ号")
    private String email;

    /** 婚姻状况，1-已婚，0-未婚 */
    @Excel(name = "婚姻状况，1-已婚，0-未婚")
    private String maritalStatus;

    /** 收入状况 */
    @Excel(name = "收入状况")
    private String salary;

    /** 是否有房，1-有，0-无 */
    @Excel(name = "是否有房，1-有，0-无")
    private String house;

    /** 房产说明 */
    @Excel(name = "房产说明")
    private String houseDesc;

    /** 是否有车，1-有，0-无 */
    @Excel(name = "是否有车，1-有，0-无")
    private String car;

    /** 车子说明 */
    @Excel(name = "车子说明")
    private String carDesc;

    /** 代理人id */
    @Excel(name = "代理人id")
    private String agent;

    private HunAgent hunAgent;
    private String filePath;

    private int totalMatch;
    private int matchSuccess;
    private int matchFail;
    private int matching;

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
    public void setNation(String nation) 
    {
        this.nation = nation;
    }

    public String getNation() 
    {
        return nation;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setNativePlace(String nativePlace) 
    {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() 
    {
        return nativePlace;
    }
    public void setBlood(String blood) 
    {
        this.blood = blood;
    }

    public String getBlood() 
    {
        return blood;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setHeight(String height) 
    {
        this.height = height;
    }

    public String getHeight() 
    {
        return height;
    }
    public void setWeight(String weight) 
    {
        this.weight = weight;
    }

    public String getWeight() 
    {
        return weight;
    }
    public void setPhysicalCondition(String physicalCondition) 
    {
        this.physicalCondition = physicalCondition;
    }

    public String getPhysicalCondition() 
    {
        return physicalCondition;
    }
    public void setHobby(String hobby) 
    {
        this.hobby = hobby;
    }

    public String getHobby() 
    {
        return hobby;
    }
    public void setGraduationCollage(String graduationCollage) 
    {
        this.graduationCollage = graduationCollage;
    }

    public String getGraduationCollage() 
    {
        return graduationCollage;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setJob(String job) 
    {
        this.job = job;
    }

    public String getJob() 
    {
        return job;
    }
    public void setJobAddr(String jobAddr) 
    {
        this.jobAddr = jobAddr;
    }

    public String getJobAddr() 
    {
        return jobAddr;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }
    public void setHomeAddr(String homeAddr) 
    {
        this.homeAddr = homeAddr;
    }

    public String getHomeAddr() 
    {
        return homeAddr;
    }
    public void setHomeDesc(String homeDesc) 
    {
        this.homeDesc = homeDesc;
    }

    public String getHomeDesc() 
    {
        return homeDesc;
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
    public void setMaritalStatus(String maritalStatus) 
    {
        this.maritalStatus = maritalStatus;
    }

    public String getMaritalStatus() 
    {
        return maritalStatus;
    }
    public void setSalary(String salary) 
    {
        this.salary = salary;
    }

    public String getSalary() 
    {
        return salary;
    }
    public void setHouse(String house) 
    {
        this.house = house;
    }

    public String getHouse() 
    {
        return house;
    }
    public void setHouseDesc(String houseDesc) 
    {
        this.houseDesc = houseDesc;
    }

    public String getHouseDesc() 
    {
        return houseDesc;
    }
    public void setCar(String car) 
    {
        this.car = car;
    }

    public String getCar() 
    {
        return car;
    }
    public void setCarDesc(String carDesc) 
    {
        this.carDesc = carDesc;
    }

    public String getCarDesc() 
    {
        return carDesc;
    }
    public void setAgent(String agent) 
    {
        this.agent = agent;
    }

    public String getAgent() 
    {
        return agent;
    }

    public HunAgent getHunAgent() {
        return hunAgent;
    }

    public void setHunAgent(HunAgent hunAgent) {
        this.hunAgent = hunAgent;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public int getTotalMatch() {
        return totalMatch;
    }

    public void setTotalMatch(int totalMatch) {
        this.totalMatch = totalMatch;
    }

    public int getMatchSuccess() {
        return matchSuccess;
    }

    public void setMatchSuccess(int matchSuccess) {
        this.matchSuccess = matchSuccess;
    }

    public int getMatchFail() {
        return matchFail;
    }

    public void setMatchFail(int matchFail) {
        this.matchFail = matchFail;
    }

    public int getMatching() {
        return matching;
    }

    public void setMatching(int matching) {
        this.matching = matching;
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
            .append("name", getName())
            .append("sex", getSex())
            .append("nation", getNation())
            .append("birthday", getBirthday())
            .append("nativePlace", getNativePlace())
            .append("blood", getBlood())
            .append("idCard", getIdCard())
            .append("height", getHeight())
            .append("weight", getWeight())
            .append("physicalCondition", getPhysicalCondition())
            .append("hobby", getHobby())
            .append("graduationCollage", getGraduationCollage())
            .append("education", getEducation())
            .append("job", getJob())
            .append("jobAddr", getJobAddr())
            .append("pic", getPic())
            .append("homeAddr", getHomeAddr())
            .append("homeDesc", getHomeDesc())
            .append("phone", getPhone())
            .append("wechat", getWechat())
            .append("qq", getQq())
            .append("email", getEmail())
            .append("maritalStatus", getMaritalStatus())
            .append("salary", getSalary())
            .append("house", getHouse())
            .append("houseDesc", getHouseDesc())
            .append("car", getCar())
            .append("carDesc", getCarDesc())
            .append("agent", getAgent())
            .append("hunAgent", getHunAgent())
            .append("filePath", getFilePath())
            .append("totalMatch", getTotalMatch())
            .append("matchSuccess", getMatchSuccess())
            .append("matchFail", getMatchFail())
            .append("matching", getMatching())
            .toString();
    }
}
