package com.opensource.message.session.defalut;

import com.opensource.message.session.KafkaSession;
import lombok.Data;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

/**
 * @author 戴涛
 * @Content 默认kafka会话器
 * @CreateTime 2020/12/27
 */
@Data
public class DefaultKafkaSession implements KafkaSession {
    //初始化kafka连接器
    private KafkaProducer<String, String> kafkaProducer;

    public boolean sendMessage(String topic, String value) throws ExecutionException, InterruptedException {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, value);
        RecordMetadata recordMetadata = kafkaProducer.send(record).get();
        System.out.println(recordMetadata);
        return true;
    }
}
