package com.qh.venus.achilles.framework.webftp.controller;

import com.qh.venus.achilles.framework.log.annotation.OperLog;
import com.qh.venus.achilles.framework.log.enums.BusinessType;
import com.qh.venus.achilles.framework.web.controller.BaseController;
import com.qh.venus.achilles.framework.web.domain.R;
import com.qh.venus.achilles.framework.webftp.pojo.FTPEntity;
import com.qh.venus.achilles.framework.webftp.service.IFTPService;
import com.qh.venus.achilles.framework.webftp.utils.FTPActuator;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * FTP协议 提供者
 *
 * @author qh_venus_yzc
 * @date 2020-07-16
 */
@RestController
@RequestMapping("/pts/ftp/webFTP")
public class FtpController extends BaseController
{
    @Autowired
    private IFTPService ftpService;

    /**
     * 查询某个路径下的目录
     */
    @OperLog(title = "FTP协议", businessType = BusinessType.QUERY)
//    @HasPermissions("pts:ftp:webFTP:list")
    @GetMapping("list")
    public R list(FTPEntity fTPEntity)
    {
        FTPFile[] Files = ftpService.selectPathList(fTPEntity);
        if (Files != null) {
            return R.data(Files);
        } else {
            return R.error("获取目录失败");
        }

    }


}

