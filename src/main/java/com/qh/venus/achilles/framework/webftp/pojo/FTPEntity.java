package com.qh.venus.achilles.framework.webftp.pojo;

import com.qh.venus.achilles.framework.webftp.constant.FTPConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPFileFilter;

@Getter
@Setter
@ToString
public class FTPEntity {
    private String username;

    private String password;

    private String host;

    private Integer port;

    private String baseUrl = FTPConstant.BASE_URL;

    private int passiveMode = FTP.BINARY_FILE_TYPE;

    private String encoding = FTPConstant.ENCODING;

    private int clientTimeout = FTPConstant.CLIENT_TIMEOUT;

    private int bufferSize;

    private int transferFileType = FTP.BINARY_FILE_TYPE;

    private boolean renameUploaded;

    private int retryTime;

    // 条件过滤
    private FTPFileFilter filter;

    public Boolean isNotNull(String param) {
        return !"".equals(param) && param != null;
    }
    public Boolean validateRequiredParameter() {
        return isNotNull(host) && port != null && isNotNull(username) && isNotNull(password);
    }

    public FTPFileFilter getFilter() {
        return filter;
    }

    public void setFilter(FTPFileFilter filter) {
        this.filter = filter;
    }
}
