package com.seaton.wallet.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RefundVo {

    private Long userId;

    private Long orderId;

    private BigDecimal amount;
}
