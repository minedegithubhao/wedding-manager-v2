package com.qh.venus.achilles.framework.webftp.service.impl;

import com.qh.venus.achilles.framework.webftp.pojo.FTPEntity;
import com.qh.venus.achilles.framework.webftp.service.IFTPService;
import com.qh.venus.achilles.framework.webftp.utils.FTPActuator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.stereotype.Service;

/**
 * 脚本管理Service业务层处理
 *
 * @author qh_venus_zf
 * @date 2020-04-23
 */
@Service
@Slf4j
public class FTPServiceImpl implements IFTPService {

    /**
     * 查询脚本管理列表
     *
     * @param tScript 脚本管理
     * @return 脚本管理
     */
    @Override
    public FTPFile[] selectPathList(FTPEntity fTPEntity) {
        if (!fTPEntity.validateRequiredParameter()) {
            return null;
        }
        FTPActuator ftpActuator = new FTPActuator(fTPEntity);
        FTPFile[] Files = new FTPFile[0];
        Boolean flag = true;
        try {
            if (fTPEntity.getFilter() != null) {
                Files = ftpActuator.getFiles(fTPEntity.getBaseUrl(), fTPEntity.getFilter());
            } else {
                Files = ftpActuator.getFiles(fTPEntity.getBaseUrl());
            }
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }finally {
            ftpActuator.disconnect();
        }
        if(flag) {
            return Files;
        } else {
            return null;
        }
    }
}
