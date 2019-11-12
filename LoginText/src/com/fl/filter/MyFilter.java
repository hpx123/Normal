package com.fl.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * 过滤器的使用
 *
 */

public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
