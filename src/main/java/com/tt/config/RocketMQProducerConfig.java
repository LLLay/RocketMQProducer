package com.tt.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author tongshuo
 * @Data 2020/7/29
 * @Describe
 */
@Slf4j
@Component
@Configuration
public class RocketMQProducerConfig {

    @Value("${apache.rocketmq.consumer.PushConsumer}")
    private String producerGroup;
    @Value("{apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    private DefaultMQProducer producer;

    @PostConstruct
    private void init() {
        //生产者的组名
        producer = new DefaultMQProducer(producerGroup);

        //指定NameServer地址，多个地址以 ; 隔开
        producer.setNamesrvAddr(namesrvAddr);
        try {
            /**
             * Producer对象在使用之前必须要调用start初始化，初始化一次即可
             * 注意：切记不可以在每次发送消息时，都调用start方法
             */
            producer.start();
            log.info("项目启动，生产者RocketProducerConfig初始化完成--组名 = 【" + producerGroup + "】，nameServer = 【" + namesrvAddr + "】");
        } catch (Exception e) {
            log.error("初始化RocketMQ的消息生产者时，出现了异常。", e);
        } finally {
            //当项目启动时，就会把producer启动起来，若是这行代码不注释掉，后果就是：producer刚刚启动，就关闭了
//            producer.shutdown();
        }
    }

    public DefaultMQProducer getProducer() {
        return producer;
    }
}
