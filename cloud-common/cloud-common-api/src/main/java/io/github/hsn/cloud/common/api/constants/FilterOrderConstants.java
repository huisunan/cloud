package io.github.hsn.cloud.common.api.constants;

public interface FilterOrderConstants {
    int LOG_FILTER = 100;

    /**
     * 要优先于SecurityProperties#DEFAULT_FILTER_ORDER
     * @see org.springframework.boot.autoconfigure.security.SecurityProperties#DEFAULT_FILTER_ORDER
     */
    int TENANT_FILTER = -200;
}
