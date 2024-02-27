package dev.dubhe.fantasyskinserver.data;

import cn.hutool.http.HttpStatus;

import java.util.Collections;
import java.util.LinkedHashMap;

public class ResponseResult extends LinkedHashMap<String, Object> {
    public static final ResponseResult SUCCESS = new ResponseResult(HttpStatus.HTTP_OK, "请求成功");
    protected static final String CODE = "code";
    protected static final String MSG = "msg";
    protected static final String DATA = "data";

    public ResponseResult(int code, String msg) {
//        this(code, msg, null);
        super.put(CODE, code);
        super.put(MSG, msg);
    }

    public ResponseResult(int code, String msg, Object data) {
        super.put(CODE, code);
        super.put(MSG, msg);
        if (null != data) {
            super.put(DATA, data);
        }
    }

    public static ResponseResult success(Object data) {
        return new ResponseResult(HttpStatus.HTTP_OK, "请求成功", data);
    }

    public static ResponseResult successSingleData(String name, Object data) {
        return new ResponseResult(HttpStatus.HTTP_OK, "请求成功", Collections.singletonMap(name, data));
    }

    public static ResponseResult success(String msg) {
        return new ResponseResult(HttpStatus.HTTP_OK, msg);
    }

    public static ResponseResult success(String msg, Object data) {
        return new ResponseResult(HttpStatus.HTTP_OK, msg, data);
    }

    public static ResponseResult msg(int code, String msg) {
        return new ResponseResult(code, msg);
    }
}
