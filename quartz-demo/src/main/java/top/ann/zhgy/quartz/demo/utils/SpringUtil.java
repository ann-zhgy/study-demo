/*
 * Meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package top.ann.zhgy.quartz.demo.utils;

import lombok.Getter;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author wb_zhanggaoyu@meituan.com
 * @version SpringUtil.class  2023-09-17 20:53
 * @since S
 */
@Component
public class SpringUtil implements ApplicationListener<WebServerInitializedEvent> {
    @Getter
    private static int serverPort;

    @Override
    public void onApplicationEvent(@NonNull WebServerInitializedEvent event) {
        serverPort = event.getWebServer().getPort();
    }
}