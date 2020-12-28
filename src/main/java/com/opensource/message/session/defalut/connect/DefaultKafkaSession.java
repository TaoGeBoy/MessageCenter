package com.opensource.message.session.defalut.connect;

import com.opensource.message.attribute.KafkaConsumerAttribute;
import com.opensource.message.attribute.KafkaProductAttribute;
import com.opensource.message.session.KafkaSession;
import lombok.Data;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

/**
 * @author 戴涛
 * @Content 默认kafka会话器
 * @CreateTime 2020/12/27
 */
public class DefaultKafkaSession implements KafkaSession {
    //初始化kafka连接器
    private KafkaProducer<String, String> kafkaProducer;
    //kafka消费者
    private KafkaConsumer<String,String> kafkaConsumer;
    //生产者参数
    private KafkaProductAttribute kafkaProductAttribute;
    //消费者参数
    private KafkaConsumerAttribute kafkaConsumerAttribute;

    //初始化构造函数
    public DefaultKafkaSession(KafkaProductAttribute kafkaProductAttribute,KafkaConsumerAttribute kafkaConsumerAttribute){
        this.kafkaProductAttribute = kafkaProductAttribute;
        this.kafkaConsumerAttribute = kafkaConsumerAttribute;
        this.kafkaProducer = new KafkaProducer<String, String>(kafkaProductAttribute.toMap());
        this.kafkaConsumer = new KafkaConsumer<String, String>(kafkaConsumerAttribute.toMap());
    }

    public boolean sendMessage(String topic, String value) throws ExecutionException, InterruptedException {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, value);
        RecordMetadata recordMetadata = kafkaProducer.send(record).get();
        System.out.println(recordMetadata);
        return true;
    }
}
