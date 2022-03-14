package com.minwoo.spring_core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 보통 패키지 최상단에서 ComponentScan으로 다 뒤져서 추가하는 것이 보통
        // basePackages = "com.minwoo.spring_core",
        // basePackageClasses = AutoAppConfig.class,
        // excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
