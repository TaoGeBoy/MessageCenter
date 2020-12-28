package com.opensource.message.attribute;

import lombok.Data;

import java.util.Map;

/**
 * @author 戴涛
 * @Content 这是一个总的配置文件bean
 * @CreateTime 2020/12/27
 */
@Data
public class MessageConfigBean {
    private KafkaAttribute kafkaAttribute;
}

