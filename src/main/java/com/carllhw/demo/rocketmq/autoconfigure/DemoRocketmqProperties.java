package com.carllhw.demo.rocketmq.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * demo rocketmq properties
 *
 * @author carllhw
 */
@Data
@ConfigurationProperties(prefix = DemoRocketmqProperties.PREFIX)
public class DemoRocketmqProperties {

    public static final String PREFIX = "demo.rocketmq";

    /**
     * topic
     */
    private String topic;
}
