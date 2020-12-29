package com.opensource.message.attribute;

import lombok.Data;


/**
 * @author 戴涛
 * @Content 这是一个总的配置文件bean
 * @CreateTime 2020/12/27
 */
@Data
public class MessageConfigBean {
    //kafka生产属性
    private KafkaProductAttribute kafkaProductAttribute;
    //kafka消费属性
    private KafkaConsumerAttribute kafkaConsumerAttribute;
}

