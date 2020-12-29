package com.opensource.message;

import com.opensource.message.exception.NoFindConfigException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author 戴涛
 * @Content
 * @CreateTime 2020/12/27
 */
public class demo {
    public static void main(String[] args) throws IOException, NoFindConfigException, ExecutionException, InterruptedException {
        /*SessionFactory bulid = new DefaultSessionFactory().bulid("messageConfig.json");
        KafkaSession kafkaSession = bulid.openKafkaSession();
        boolean b = kafkaSession.sendMessage("topic-demo", "hello Kafka");
        if(b){
            System.out.println("消息发送成功");
        }*/

        Properties properties = new Properties();
        properties.put("bootstrap.servers","121.4.71.84:9092");
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("client.id","demo");

        KafkaProducer<String, String> producer = new KafkaProducer<String,String>(properties);
        ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>("topic-demo","hello word");
        try{
            RecordMetadata recordMetadata = producer.send(producerRecord).get();
            System.out.println(recordMetadata);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
