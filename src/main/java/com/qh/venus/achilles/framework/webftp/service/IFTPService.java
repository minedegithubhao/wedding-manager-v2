package com.qh.venus.achilles.framework.webftp.service;

import com.qh.venus.achilles.framework.webftp.pojo.FTPEntity;
import org.apache.commons.net.ftp.FTPFile;

/**
 * 脚本管理Service接口
 *
 * @author qh_venus_zf
 * @date 2020-04-23
 */
public interface IFTPService
{

    /**
     * 查询某个路径下的目录
     *
     * @param tScript FTP协议
     * @return 某个路径下的目录
     */
    public FTPFile[] selectPathList(FTPEntity fTPEntity);
}
