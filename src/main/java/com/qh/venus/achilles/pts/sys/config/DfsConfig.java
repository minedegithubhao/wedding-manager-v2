package com.qh.venus.achilles.pts.sys.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 附件配置
 *
 * @author qh_venus_zf
 * @date 2020-04-23
 */
@Data
@Component
@ConfigurationProperties(prefix = "dfs")
public class DfsConfig
{
    /** 路径*/
    private String path;

    /** 对外开放的静态资源路径 */
    private String openPath;

    //生产环境建议用nginx绑定域名映射
    /** 域名*/
    private String domain;
}