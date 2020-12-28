package com.opensource.message.attribute;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 戴涛
 * @Content kafka生产者属性
 * @CreateTime 2020/12/28
 */
@Data
public class KafkaProductAttribute {
    //kafka集群地址
    private String bootstrap_servers;
    //Key反序列化类
    private String key_seserializer;
    //value反序列化类
    private String value_seserializer;
    //客户端ID
    private String client_id;

    //返回一个Map对象
    public Map<String,Object> toMap(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("bootstrap.servers",this.getBootstrap_servers());
        result.put("key.seserializer",this.getKey_seserializer());
        result.put("value_seserializer",this.getValue_seserializer());
        result.put("client.id",this.getClient_id());
        return result;
    }
}
