package com.tangjiqunliu.concurrency.example.filter;

import com.tangjiqunliu.concurrency.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpRequest httpRequest = (HttpRequest) servletRequest;
        log.info("doFilter: {} {}",Thread.currentThread().getId(),httpRequest);
        RequestHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
