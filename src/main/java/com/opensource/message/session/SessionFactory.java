package com.opensource.message.session;

import com.opensource.message.exception.NoFindConfigException;

/**
 * @author 戴涛
 * @Content
 * @CreateTime 2020/12/25
 */
public interface SessionFactory {
    public KafkaProSession openProductSession() throws NoFindConfigException;
    public KafkaConSession openConsumerSession() throws NoFindConfigException;
}
