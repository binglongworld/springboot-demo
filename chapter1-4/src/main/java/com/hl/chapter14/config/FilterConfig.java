package com.hl.chapter14.config;

import com.hl.chapter14.filter.DemoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter配置类
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean DemoFilterBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DemoFilter demoFilter = new DemoFilter();
        filterRegistrationBean.setFilter(demoFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }
}
