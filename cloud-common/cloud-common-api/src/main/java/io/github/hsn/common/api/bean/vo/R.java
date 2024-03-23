package io.github.hsn.common.api.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {

    public static final Integer SUCCESS_CODE = 0;

    public static final Integer FAIL_CODE = 1;

    private Integer code;

    private String msg;

    private T data;


    public static <T> R<T> success() {
        return new R<>(SUCCESS_CODE, null, null);
    }

    public static <T> R<T> success(T data) {
        return new R<>(SUCCESS_CODE, null, data);
    }

    public static <T> R<T> fail(String msg) {
        return new R<>(FAIL_CODE, msg, null);
    }

    public static <T> R<T> fail(Integer code, String msg) {
        return new R<>(code, msg, null);
    }


}
