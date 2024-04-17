package io.github.hsn.cloud.common.biz.mvc;

import cn.hutool.core.util.StrUtil;
import io.github.hsn.cloud.common.api.constants.FilterOrderConstants;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;

@Slf4j
@Order(FilterOrderConstants.LOG_FILTER)
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        String uri = null, method = null, body = null;

        try {
            if (servletRequest instanceof HttpServletRequest httpServletRequest) {
                uri = httpServletRequest.getRequestURI();
                method = httpServletRequest.getMethod();
                if (httpServletRequest.getContentType() != null && httpServletRequest.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)) {
                    ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
                    body = requestWrapper.getContentAsString();
                    servletRequest = requestWrapper;
                }
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            log.info("{}ms {} {}", System.currentTimeMillis() - startTime, method, uri);
            if (StrUtil.isNotBlank(body)) {
                log.info("{}", body);
            }
        }

    }
}
