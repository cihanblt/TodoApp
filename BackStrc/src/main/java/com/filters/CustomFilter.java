package com.filters;

import com.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cihanblt
 */
@Component
public class CustomFilter extends GenericFilterBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String ipAddress = IpUtil.getClientIpAddress(request);
        try {
            filterChain.doFilter(request, response);
            LOGGER.info(ipAddress + "filter is ok" );
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            filterChain.doFilter(request,response);
        }
//            filterChain.doFilter(request,response);
    }


}
