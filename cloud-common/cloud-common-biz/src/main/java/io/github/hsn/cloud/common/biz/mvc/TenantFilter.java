package io.github.hsn.cloud.common.biz.mvc;

import cn.hutool.core.util.StrUtil;
import io.github.hsn.cloud.common.api.constants.CommonConstants;
import io.github.hsn.cloud.common.api.constants.FilterOrderConstants;
import io.github.hsn.cloud.common.core.tenant.TenantUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@Order(SecurityProperties.DEFAULT_FILTER_ORDER - 1)
public class TenantFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            if (servletRequest instanceof HttpServletRequest httpServletRequest) {
                String tenantId = httpServletRequest.getHeader(CommonConstants.TENANT_ID);
                TenantUtil.setTenantId(StrUtil.blankToDefault(tenantId, CommonConstants.DEFAULT_TENANT));
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            TenantUtil.clear();
        }
    }
}
