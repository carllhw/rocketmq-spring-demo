package com.carllhw.demo.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * consumer 1
 *
 * @author carllhw
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "${demo.rocketmq.topic:}", consumerGroup = "rocketmq-spring-demo-1",
        selectorExpression = "string")
public class Consumer1 implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("received message: {}", message);
    }
}
