package com.qh.venus.achilles.framework.webftp.pool;

import com.qh.venus.achilles.framework.webftp.pojo.FTPEntity;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.pool.PoolableObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * FTPClient 工厂
 * @Auther: yzc
 * @Date: 2020-07-14 15:40
 * @Description:
 */
@SuppressWarnings("all")
public class FTPClientFactory implements PoolableObjectFactory<FTPClient> {
    protected final Logger log = LoggerFactory.getLogger(FTPClientFactory.class);
    private FTPEntity ftpProperties;

    public FTPClientFactory(FTPEntity ftpProperties) {
        this.ftpProperties = ftpProperties;
    }

    @Override
    public FTPClient makeObject() throws Exception {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding(ftpProperties.getEncoding());
        ftpClient.setConnectTimeout(ftpProperties.getClientTimeout());
        try {
            ftpClient.connect(ftpProperties.getHost(), ftpProperties.getPort());
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                log.warn("FTPServer refused connection");
                return null;
            }
            boolean result = ftpClient.login(ftpProperties.getUsername(), ftpProperties.getPassword());
            ftpClient.setFileType(ftpProperties.getTransferFileType());
//            ftpClient.changeWorkingDirectory(ftpProperties.getBaseUrl());
            if (!result) {
                log.warn("ftpClient login failed... username is {}", ftpProperties.getUsername());
            }
        } catch (Exception e) {
            log.error("create ftp connection failed...{}", e);
            throw e;
        }

        return ftpClient;
    }

    @Override
    public void destroyObject(FTPClient ftpClient) throws Exception {
        try {
            if(ftpClient != null && ftpClient.isConnected()) {
                ftpClient.logout();
            }
        } catch (Exception e) {
            log.error("ftp client logout failed...{}", e);
            throw e;
        } finally {
            if(ftpClient != null) {
                ftpClient.disconnect();
            }
        }

    }

    @Override
    public boolean validateObject(FTPClient ftpClient) {
        try {
            return ftpClient.sendNoOp();
        } catch (Exception e) {
            log.error("Failed to validate client: {}");
        }
        return false;
    }

    @Override
    public void activateObject(FTPClient obj) throws Exception {
        //Do nothing

    }

    @Override
    public void passivateObject(FTPClient obj) throws Exception {
        //Do nothing

    }
}