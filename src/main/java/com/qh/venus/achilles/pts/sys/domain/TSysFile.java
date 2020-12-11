package com.qh.venus.achilles.pts.sys.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel;
import com.qh.venus.achilles.framework.aspectj.lang.annotation.Excel.Type;
import com.qh.venus.achilles.framework.web.domain.BaseEntity;

/**
 * 公共附件对象 t_sys_file
 *
 * @author qh_venus_zf
 * @date 2020-04-23
 */
public class TSysFile extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 文件真实名称
     */
    @Excel(name = "文件真实名称")
    private String fileRealname;

    /**
     * 文件全路径
     */
    @Excel(name = "文件全路径")
    private String fileFullpath;

    /**
     * 文件相对路径
     */
    @Excel(name = "文件全路径")
    private String filePath;

    /**
     * 存储名称
     */
    @Excel(name = "存储名称")
    private String storageName;

    /**
     * 业务ID
     */
    @Excel(name = "业务ID")
    private String busId;

    /**
     * 存储类型
     */
    @Excel(name = "存储类型")
    private String storageType;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

    /**
     * 删除标识
     */
    private String delFlag;
    private String[] busIdArray;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String[] getBusIdArray() {
        return busIdArray;
    }

    public void setBusIdArray(String[] busIdArray) {
        this.busIdArray = busIdArray;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFileRealname(String fileRealname) {
        this.fileRealname = fileRealname;
    }

    public String getFileRealname() {
        return fileRealname;
    }

    public void setFileFullpath(String fileFullpath) {
        this.fileFullpath = fileFullpath;
    }

    public String getFileFullpath() {
        return fileFullpath;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusId() {
        return busId;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStorageType() {
        return storageType;
    }

    public String getStatus() {
        return status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("fileRealname", getFileRealname())
                .append("fileFullpath", getFileFullpath())
                .append("filePath", getFilePath())
                .append("storageName", getStorageName())
                .append("busId", getBusId())
                .append("storageType", getStorageType())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("remark", getRemark())
                .toString();
    }
}
