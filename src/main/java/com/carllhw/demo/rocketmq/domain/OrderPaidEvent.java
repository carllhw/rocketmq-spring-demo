package com.carllhw.demo.rocketmq.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * order paid event
 *
 * @author carllhw
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderPaidEvent {

    private String orderId;

    private BigDecimal paidMoney;
}
