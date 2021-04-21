package com.hl.chapter14.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器类
 */
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---------DemoFilter开始执行----------");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("---------DemoFilter结束执行----------");
    }

    @Override
    public void destroy() {

    }
}
