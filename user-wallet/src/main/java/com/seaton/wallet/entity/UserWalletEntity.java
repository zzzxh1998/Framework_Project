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
@TableName("user_wallet")
public class UserWalletEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String acv;
	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private BigDecimal walletAmount;
	/**
	 * 
	 */
	private BigDecimal threshold;
	/**
	 * 
	 */
	private String payPassword;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
