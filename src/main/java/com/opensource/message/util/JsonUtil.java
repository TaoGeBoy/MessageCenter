package com.opensource.message.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensource.message.attribute.KafkaProductAttribute;
import com.opensource.message.attribute.MessageConfigBean;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * @author 戴涛
 * @Content JSON工具类
 * @CreateTime 2020/12/26
 */
public class JsonUtil {
    /**
     * 将JSON文件转换成字符串
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    private static String JsonToString(String filePath) throws IOException {
        // ClassPathResource类的构造方法接收路径名称，自动去classpath路径下找文件
        ClassPathResource classPathResource = new ClassPathResource(filePath);
        // 获得File对象，当然也可以获取输入流对象
        File file = classPathResource.getFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line);
        }
        return content.toString();
    }


    /**
     * 将一个字符串转换成MessageConfigBean对象
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static MessageConfigBean getMessageConfig(String filePath) throws IOException {
        MessageConfigBean messageConfigBean = new MessageConfigBean();
        String configString = JsonToString(filePath);
        //转换成JSON对象
        JSONObject jsonObject = JSONObject.parseObject(configString);
        //kafka属性赋值
        if (jsonObject.get("kafkaProductConfig") != null) {
            KafkaProductAttribute kafkaProductConfig = JSON.parseObject(jsonObject.get("kafkaProductConfig").toString(), KafkaProductAttribute.class);
            messageConfigBean.setKafkaProductAttribute(kafkaProductConfig);
        }
        return messageConfigBean;
    }
}
