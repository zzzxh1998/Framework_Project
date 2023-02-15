package com.seaton.wallet.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class listVo implements Serializable {

    private Long id;
    /**
     * 钱包id
     */
    private Long userId;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 0-支出 1-退款 2-提现
     */
    private Integer type;

    /**
     * 更新时间
     */
    private Date updateTime;
}
