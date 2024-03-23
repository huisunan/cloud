package io.github.hsn.common.biz.mvc;

import cn.hutool.core.util.StrUtil;
import io.github.hsn.common.api.constants.CommonConstants;
import io.github.hsn.common.core.tenant.TenantUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@Order(10)
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
