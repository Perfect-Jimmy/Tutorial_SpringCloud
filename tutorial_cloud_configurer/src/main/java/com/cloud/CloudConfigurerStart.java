package com.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by Jimmy. 2018/5/9  18:18
 * 配置中心
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigurerStart {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CloudConfigurerStart.class).run(args);
    }
}
