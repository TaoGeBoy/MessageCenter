package com.opensource.message.exception;

import lombok.Data;

/**
 * @author 戴涛
 * @Content 配置文件异常类
 * @CreateTime 2020/12/27
 */
public class NoFindConfigException extends Exception {
    public NoFindConfigException() {
    }

    public NoFindConfigException(String message) {
        super(message);
    }
}
