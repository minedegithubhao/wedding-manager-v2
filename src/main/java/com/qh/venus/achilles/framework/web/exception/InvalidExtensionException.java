package com.qh.venus.achilles.framework.web.exception;

import java.util.Arrays;
import org.apache.commons.fileupload.FileUploadException;

/**
 * @Title:文件上传 有误异常类
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public class InvalidExtensionException extends FileUploadException {
	private static final long serialVersionUID = 1L;

	private String[] allowedExtension;
	private String extension;
	private String filename;

	public InvalidExtensionException(String[] allowedExtension, String extension, String filename) {
		super("filename : [" + filename + "], extension : [" + extension + "], allowed extension : ["
				+ Arrays.toString(allowedExtension) + "]");
		this.allowedExtension = allowedExtension;
		this.extension = extension;
		this.filename = filename;
	}

	public String[] getAllowedExtension() {
		return allowedExtension;
	}

	public String getExtension() {
		return extension;
	}

	public String getFilename() {
		return filename;
	}

	public static class InvalidImageExtensionException extends InvalidExtensionException {
		private static final long serialVersionUID = 1L;

		public InvalidImageExtensionException(String[] allowedExtension, String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}

	public static class InvalidFlashExtensionException extends InvalidExtensionException {
		private static final long serialVersionUID = 1L;

		public InvalidFlashExtensionException(String[] allowedExtension, String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}

	public static class InvalidMediaExtensionException extends InvalidExtensionException {
		private static final long serialVersionUID = 1L;

		public InvalidMediaExtensionException(String[] allowedExtension, String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}
}
