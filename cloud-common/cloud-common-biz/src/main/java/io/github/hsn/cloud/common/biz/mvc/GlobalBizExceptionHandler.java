package io.github.hsn.cloud.common.biz.mvc;

import io.github.hsn.cloud.common.api.bean.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(1000)
@Slf4j
@RestController
@RestControllerAdvice
public class GlobalBizExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R<Void> exception(Exception e) {
        log.error("全局异常", e);
        return R.fail("系统异常");
    }
}
