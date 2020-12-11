package com.qh.venus.achilles.common.utils;

import com.qh.venus.achilles.common.utils.security.Md5Utils;
import com.qh.venus.achilles.sms.system.domain.SysUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
	public static boolean matches(SysUser user, String newPassword) {
		return user.getPassword().equals(encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
	}

	public static String encryptPassword(String username, String password, String salt) {
		return Md5Utils.hash(username + password + salt);
	}
	public static String defaultPassword(String username, String password){
		return new BCryptPasswordEncoder().encode(username + 123);
	}

}