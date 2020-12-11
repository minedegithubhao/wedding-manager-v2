package com.qh.venus.achilles.framework.security.handle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import com.alibaba.fastjson.JSON;
import com.qh.venus.achilles.common.constant.Constants;
import com.qh.venus.achilles.common.constant.HttpStatus;
import com.qh.venus.achilles.common.utils.ServletUtils;
import com.qh.venus.achilles.common.utils.StringUtils;
import com.qh.venus.achilles.framework.manager.AsyncManager;
import com.qh.venus.achilles.framework.manager.factory.AsyncFactory;
import com.qh.venus.achilles.framework.security.AuthUser;
import com.qh.venus.achilles.framework.security.service.TokenService;
import com.qh.venus.achilles.framework.web.domain.AjaxResult;


/**
 * @Title: 自定义退出处理类 返回成功
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler
{
    @Autowired
    private TokenService tokenService;

    /**
     * 退出处理
     * 
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException
    {
        AuthUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser))
        {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // 记录用户退出日志
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, Constants.LOGOUT, "退出成功"));
        }
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(HttpStatus.SUCCESS, "退出成功")));
    }
}
