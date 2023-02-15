package com.seaton.wallet.controller;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seaton.wallet.entity.UserWalletEntity;
import com.seaton.wallet.service.UserWalletService;
import com.seaton.wallet.common.utils.R;



/**
 * 
 *
 * @author seaton
 * @email 1179130487@qq.com
 * @date 2022-11-08 21:01:09
 */
@RestController
@RequestMapping("userwallet")
public class UserWalletController {

    @Autowired
    private UserWalletService userWalletService;

    /**
     * 查询用户钱包余额
     * @param userId
     * @return
     */
    @RequestMapping("/amount")
    public R getAmount(@RequestParam("userId") Long userId){
        UserWalletEntity user = userWalletService.getOne(new QueryWrapper<UserWalletEntity>().eq("user_id", userId));
        BigDecimal walletAmount = user.getWalletAmount();
        return R.ok().put("walletAmount",walletAmount);
    }





}
