package com.opensource.message.session.defalut.factory;

import com.opensource.message.attribute.KafkaProductAttribute;
import com.opensource.message.attribute.MessageConfigBean;
import com.opensource.message.exception.NoFindConfigException;
import com.opensource.message.session.KafkaConSession;
import com.opensource.message.session.KafkaProSession;
import com.opensource.message.session.SessionFactory;
import com.opensource.message.session.defalut.connect.DefaultKafkaProSession;
import com.opensource.message.util.JsonUtil;

import java.io.IOException;

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

    @Override
    public KafkaProSession openProductSession() throws NoFindConfigException {
        return createKafkaSession();
    }

    @Override
    public KafkaConSession openConsumerSession() throws NoFindConfigException {
        return null;
    }


    private KafkaProSession createKafkaSession() throws NoFindConfigException {
        KafkaProductAttribute kafkaProductAttribute = messageConfigBean.getKafkaProductAttribute();
        if (kafkaProductAttribute == null) {
            throw new NoFindConfigException();
        }
        //将配置文件转换成Map生成Kafka连接对象
        //KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(kafkaProductConfig);
        //创建kafka会话器
        DefaultKafkaProSession kafkaProSession = new DefaultKafkaProSession(kafkaProductAttribute);
        return kafkaProSession;
    }
}
