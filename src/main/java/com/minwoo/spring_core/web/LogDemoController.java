package com.minwoo.spring_core.web;

import com.minwoo.spring_core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    //private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        //MyLogger myLogger = myLoggerProvider.getObject();
        String s = request.getRequestURL().toString();
        myLogger.setRequestUrl(s);
        myLogger.log("controller test");

        logDemoService.logic("testId");
        return "OK";
    }
}