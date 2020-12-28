package com.opensource.message.session.defalut.factory;

import com.opensource.message.attribute.MessageConfigBean;
import com.opensource.message.exception.NoFindConfigException;
import com.opensource.message.session.KafkaSession;
import com.opensource.message.session.SessionFactory;
import com.opensource.message.session.defalut.connect.DefaultKafkaSession;
import com.opensource.message.util.JsonUtil;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.io.IOException;
import java.util.Map;

/**
 * @author 戴涛
 * @Content 默认连接对象工厂
 * @CreateTime 2020/12/25
 */
public class KafkaSessionFactory implements SessionFactory {

    private MessageConfigBean messageConfigBean;

    public SessionFactory bulid(String filePath) throws IOException {
        MessageConfigBean messageConfig = JsonUtil.getMessageConfig(filePath);
        this.messageConfigBean = messageConfig;
        return this;
    }

    public KafkaSession openKafkaSession() throws NoFindConfigException {
        return createKafkaSession();
    }

    private KafkaSession createKafkaSession() throws NoFindConfigException {
        Map<String,Object> kafkaProductConfig = messageConfigBean.getKafkaAttribute().toMap();
        if(kafkaProductConfig == null){
            throw new NoFindConfigException();
        }
        //将配置文件转换成Map生成Kafka连接对象
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(kafkaProductConfig);
        //创建kafka会话器
        DefaultKafkaSession kafkaSession = new DefaultKafkaSession(kafkaProducer);
        return kafkaSession;
    }
}
