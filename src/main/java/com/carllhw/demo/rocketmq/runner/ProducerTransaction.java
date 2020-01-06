package com.carllhw.demo.rocketmq.runner;

import com.carllhw.demo.rocketmq.autoconfigure.DemoRocketmqProperties;
import com.carllhw.demo.rocketmq.util.DestinationUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * producer transaction
 *
 * @author carllhw
 */
@Slf4j
@Component
public class ProducerTransaction implements DemoRunner {

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
        Message<String> msg = MessageBuilder.withPayload("transaction").build();
        rocketMqTemplate.sendMessageInTransaction("testTransaction", DestinationUtil.getDestination(
                demoRocketmqProperties.getTopic(), "string"), msg, null);
    }

    @RocketMQTransactionListener(txProducerGroup = "testTransaction")
    public static class TransactionListenerImpl implements RocketMQLocalTransactionListener {
        @Override
        public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
            log.info("received message to executeLocalTransaction: {}, arg: {}", msg, arg);
            return RocketMQLocalTransactionState.UNKNOWN;
        }

        @Override
        public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
            log.info("received message to checkLocalTransaction: {}", msg);
            return RocketMQLocalTransactionState.COMMIT;
        }
    }
}
