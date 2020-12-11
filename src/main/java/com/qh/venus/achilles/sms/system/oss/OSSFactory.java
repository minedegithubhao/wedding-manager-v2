//package com.qh.venus.achilles.sms.system.oss;
//
//import com.alibaba.fastjson.JSON;
//import com.qh.venus.achilles.common.utils.spring.SpringUtils;
//import com.qh.venus.achilles.sms.system.service.ISysConfigService;
//
///**
// * @Title:文件上传Factory
// * @Description:
// * @author zf
// * @date 2020-03-30 10:46:23
// * @version V1.0
// * @Copyright 版权所有 ( c ) 。保留所有权利。
// * @Company
// */
//public final class OSSFactory {
//	private static ISysConfigService sysConfigService;
//	static {
//		OSSFactory.sysConfigService = (ISysConfigService) SpringUtils.getBean(ISysConfigService.class);
//	}
//
//	public static CloudStorageService build() {
//		String jsonconfig = sysConfigService.selectConfigByKey(CloudConstant.CLOUD_STORAGE_CONFIG_KEY);
//		// 获取云存储配置信息
//		CloudStorageConfig config = JSON.parseObject(jsonconfig, CloudStorageConfig.class);
//		if (config.getType() == CloudService.QINIU.getValue()) {
//			return new QiniuCloudStorageService(config);
//		} else if (config.getType() == CloudConstant.CloudService.ALIYUN.getValue()) {
//			return new AliyunCloudStorageService(config);
//		} else if (config.getType() == CloudService.QCLOUD.getValue()) {
//			return new QcloudCloudStorageService(config);
//		}
//		return null;
//	}
//}
