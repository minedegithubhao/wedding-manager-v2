package com.qh.venus.achilles.pts.sys.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel.Type;
import com.qh.venus.achilles.framework.web.domain.BaseEntity;

/**
 * 公共流水号对象 t_sys_serial_number
 * 
 * @author qh_venus_zf
 * @date 2020-04-22
 */
public class TSysSerialNumber extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 模块名称 */
    @Excel(name = "模块名称")
    private String modelName;

    /** 模块代码 */
    @Excel(name = "模块代码")
    private String modelCode;

    /** 参数模板 */
    @Excel(name = "参数模板")
    private String configTemplet;

    /** 当前最大值 */
    @Excel(name = "当前最大值")
    private String maxSerial;

    /** 缓存个数 */
    @Excel(name = "缓存个数")
    private String preMaxNum;

    /** 自增标识 */
    @Excel(name = "自增标识")
    private String autoIncrementFlag;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 删除标识 */
    private Long delFlag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setModelName(String modelName) 
    {
        this.modelName = modelName;
    }

    public String getModelName() 
    {
        return modelName;
    }
    public void setModelCode(String modelCode) 
    {
        this.modelCode = modelCode;
    }

    public String getModelCode() 
    {
        return modelCode;
    }
    public void setConfigTemplet(String configTemplet) 
    {
        this.configTemplet = configTemplet;
    }

    public String getConfigTemplet() 
    {
        return configTemplet;
    }
    public void setMaxSerial(String maxSerial) 
    {
        this.maxSerial = maxSerial;
    }

    public String getMaxSerial() 
    {
        return maxSerial;
    }
    public void setPreMaxNum(String preMaxNum) 
    {
        this.preMaxNum = preMaxNum;
    }

    public String getPreMaxNum() 
    {
        return preMaxNum;
    }
    public void setAutoIncrementFlag(String autoIncrementFlag) 
    {
        this.autoIncrementFlag = autoIncrementFlag;
    }

    public String getAutoIncrementFlag() 
    {
        return autoIncrementFlag;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("modelName", getModelName())
            .append("modelCode", getModelCode())
            .append("configTemplet", getConfigTemplet())
            .append("maxSerial", getMaxSerial())
            .append("preMaxNum", getPreMaxNum())
            .append("autoIncrementFlag", getAutoIncrementFlag())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
