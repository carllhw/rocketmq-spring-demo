package com.carllhw.demo.rocketmq.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * common exception
 *
 * @author carllhw
 */
@Slf4j
public class CommonException extends RuntimeException {

    private final transient Object[] parameters;

    private final String code;

    /**
     * 构造器
     *
     * @param code       异常code
     * @param parameters parameters
     */
    public CommonException(String code, Object... parameters) {
        super(code);
        this.parameters = parameters;
        this.code = code;
    }

    public CommonException(String code, Throwable cause, Object... parameters) {
        super(code, cause);
        this.code = code;
        this.parameters = parameters;
    }

    public CommonException(String code, Throwable cause) {
        super(code, cause);
        this.code = code;
        this.parameters = new Object[]{};
    }


    public CommonException(Throwable cause, Object... parameters) {
        super(cause);
        this.code = null;
        this.parameters = parameters;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public String getCode() {
        return code;
    }

    public String getTrace() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps;
        try {
            ps = new PrintStream(baos, false, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            log.error("Error get trace, unsupported encoding.", e);
            return null;
        }
        this.printStackTrace(ps);
        ps.flush();
        return new String(baos.toByteArray(), StandardCharsets.UTF_8);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", code);
        map.put("message", super.getMessage());
        return map;
    }
}
