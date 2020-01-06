package com.carllhw.demo.rocketmq.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * demo rocketmq auto configuration
 *
 * @author carllhw
 */
@Configuration
@EnableConfigurationProperties(DemoRocketmqProperties.class)
public class DemoRocketmqAutoConfiguration {

}
