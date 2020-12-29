package com.opensource.message.session;

import java.util.concurrent.ExecutionException;

/**
 * @author 戴涛
 * @Content
 * @CreateTime 2020/12/25
 */
public interface KafkaProSession{
    //发送同步消息
    boolean sendMessage(String topic, String value) throws ExecutionException, InterruptedException;
}
