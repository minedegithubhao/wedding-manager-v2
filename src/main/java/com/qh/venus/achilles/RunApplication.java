package com.qh.venus.achilles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.InputStream;


/**
 * @author zf
 * @version V1.0
 * @Title:启动程序
 * @Description:
 * @date 2020-03-30 10:46:23
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ServletComponentScan
//@ComponentScan
public class RunApplication {

    public static void main(String[] args) {

        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RunApplication.class, args);

        System.out.println("-----------------启动成功-------------- ");
    }


}
