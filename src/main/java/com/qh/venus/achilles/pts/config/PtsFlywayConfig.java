
package com.qh.venus.achilles.pts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: MpcFlywayConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangfeng
 * @date 2018年8月17日
 *
 */
@Component
public class PtsFlywayConfig {
	@Value("${spring.datasource.druid.master.url}")
	private String url;
	@Value("${spring.datasource.druid.master.username}")
	private String uName;
	@Value("${spring.datasource.druid.master.password}")
	private String uPwd;
	@Value("${spring.flyway.table}")
	private String tableName;
	@Value("${spring.flyway.locations}")
	private String[] locations;
	@Value("${spring.flyway.enabled}")
	private boolean enabled;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String[] getLocations() {
		return locations;
	}

	public void setLocations(String[] locations) {
		this.locations = locations;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
