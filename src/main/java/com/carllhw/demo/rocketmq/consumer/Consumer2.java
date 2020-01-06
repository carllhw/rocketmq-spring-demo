package com.carllhw.demo.rocketmq.consumer;

import com.carllhw.demo.rocketmq.domain.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * consumer 2
 *
 * @author carllhw
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "${demo.rocketmq.topic:}", consumerGroup = "rocketmq-spring-demo-2",
        selectorExpression = "orderPaidEvent")
public class Consumer2 implements RocketMQListener<OrderPaidEvent> {

    @Override
    public void onMessage(OrderPaidEvent orderPaidEvent) {
        log.info("received orderPaidEvent: {}", orderPaidEvent);
    }
}
