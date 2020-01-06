package com.carllhw.demo.rocketmq.util;

/**
 * destination util
 *
 * @author carllhw
 */
public class DestinationUtil {

    private DestinationUtil() {
    }

    /**
     * get destination
     *
     * @param topic topic
     * @param tag   tag
     * @return destination
     */
    public static String getDestination(String topic, String tag) {
        return topic + Constants.Symbol.COLON + tag;
    }
}
