package com.qh.venus.achilles.framework.security.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.qh.venus.achilles.common.enums.UserStatus;
import com.qh.venus.achilles.common.exception.BaseException;
import com.qh.venus.achilles.common.utils.StringUtils;
import com.qh.venus.achilles.framework.security.AuthUser;
import com.qh.venus.achilles.sms.system.domain.SysUser;
import com.qh.venus.achilles.sms.system.service.ISysUserService;
/**
 * @Title: 用户验证处理
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private ISysUserService userService;

    @Autowired
    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
        SysUser user = userService.selectUserByLoginName(userName);
        if (StringUtils.isNull(user))
        {
            log.info("登录用户：{} 不存在.", userName);
            throw new UsernameNotFoundException("登录用户：" + userName + " 不存在");
        }
        else if (UserStatus.DELETED.getCode().equals(user.getDelFlag()))
        {
            log.info("登录用户：{} 已被删除.", userName);
            throw new BaseException("对不起，您的账号：" + userName + " 已被删除");
        }
        else if (UserStatus.DISABLE.getCode().equals(user.getStatus()))
        {
            log.info("登录用户：{} 已被停用.", userName);
            throw new BaseException("对不起，您的账号：" + userName + " 已停用");
        }
        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user)
    {
        return new AuthUser(user, permissionService.getMenuPermission(user));
    }
}
