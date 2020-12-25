package com.opensource.message.config;

/**
 * @author 戴涛
 * @Content kafka配置对象
 * @CreateTime 2020/12/25
 */
public class KafkaProductConfig {
    //kafka集群地址
    private String servers;
    //Key反序列化类
    private String keyDeserializer;
    //value反序列化类
    private String valueDeserializer;
    //消费组ID
    private String groupId;
    //客户端ID
    private String clientId;
    //连接消费者心跳时间
    private String heartbeatIntervalMs;
    //检测消费者是否失效时间
    private String sessionTimeOutMs;
    //重新消费策略
    private
}
