package com.carllhw.demo.rocketmq.runner;

import java.math.BigDecimal;

import com.carllhw.demo.rocketmq.autoconfigure.DemoRocketmqProperties;
import com.carllhw.demo.rocketmq.domain.OrderPaidEvent;
import com.carllhw.demo.rocketmq.util.DestinationUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * producer
 *
 * @author carllhw
 */
@Slf4j
@Component
public class Producer implements DemoRunner {

    private static final String STRING_TAG = "string";

    private DemoRocketmqProperties demoRocketmqProperties;

    private RocketMQTemplate rocketMqTemplate;

    @Autowired
    public void setDemoRocketmqProperties(DemoRocketmqProperties demoRocketmqProperties) {
        this.demoRocketmqProperties = demoRocketmqProperties;
    }

    @Autowired
    public void setRocketMqTemplate(RocketMQTemplate rocketMqTemplate) {
        this.rocketMqTemplate = rocketMqTemplate;
    }

    @Override
    public void run() {
        // send message synchronously
        rocketMqTemplate.convertAndSend(DestinationUtil.getDestination(demoRocketmqProperties.getTopic(), STRING_TAG),
                "Hello, World!");
        // send spring message
        rocketMqTemplate.send(DestinationUtil.getDestination(demoRocketmqProperties.getTopic(), STRING_TAG),
                MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
        // send messgae asynchronously
        OrderPaidEvent orderPaidEvent = new OrderPaidEvent("T_001", new BigDecimal("88.00"));
        rocketMqTemplate.asyncSend(DestinationUtil.getDestination(demoRocketmqProperties.getTopic(),
                "orderPaidEvent"), MessageBuilder.withPayload(orderPaidEvent).build(),
                new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        log.info("async onSucess SendResult={}", sendResult);
                    }

                    @Override
                    public void onException(Throwable e) {
                        log.info("async onException Throwable", e);
                    }
                });
        // Send messages orderly
        rocketMqTemplate.syncSendOrderly(DestinationUtil.getDestination(demoRocketmqProperties.getTopic(), STRING_TAG),
                MessageBuilder.withPayload("Hello, World").build(), "hashkey");
    }
}
