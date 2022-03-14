package com.minwoo.spring_core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static java.util.UUID.*;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestUrl;

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "] " + "[" + requestUrl + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = randomUUID().toString();
        System.out.println("[" + uuid + "] is created " + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[" + uuid + "] is destroyed " + this);
    }
}
