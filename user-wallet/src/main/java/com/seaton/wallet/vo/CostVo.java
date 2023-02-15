package com.seaton.wallet.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CostVo {

    private Long userId;

    private Long orderId;

    private BigDecimal amount;
}
