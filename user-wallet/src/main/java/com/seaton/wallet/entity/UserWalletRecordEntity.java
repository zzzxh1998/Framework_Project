package com.seaton.wallet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author seaton
 * @email 1179130487@qq.com
 * @date 2022-11-08 21:01:09
 */
@Data
@TableName("user_wallet_record")
public class UserWalletRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	private String aa="1312";
	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 钱包id
	 */
	private Long userId;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 金额
	 */
	private BigDecimal amount;
	/**
	 * 旧的金额
	 */
	private BigDecimal oldAmount;
	/**
	 * 0-支出 1-退款 2-提现
	 */
	private Integer type;
	/**
	 * 银行流水号
	 */
	private Integer bankSerialNumber;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
