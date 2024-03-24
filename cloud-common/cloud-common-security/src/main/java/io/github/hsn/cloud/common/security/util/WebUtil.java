package io.github.hsn.cloud.common.security.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hsn.cloud.common.api.bean.vo.R;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@UtilityClass
public class WebUtil {

    public <T> void writeR(
            ObjectMapper objectMapper,
            HttpServletResponse response,
            Integer code,
            R<T> r
    ) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.getWriter().write(objectMapper.writeValueAsString(r));
        response.setStatus(code);
    }
}
