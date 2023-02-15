package com.seaton.wallet.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seaton.wallet.Constants.WalletConstants;
import com.seaton.wallet.entity.UserWalletRecordEntity;
import com.seaton.wallet.vo.CostVo;
import com.seaton.wallet.vo.RefundVo;
import com.seaton.wallet.vo.listVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.seaton.wallet.service.UserWalletRecordService;
import com.seaton.wallet.common.utils.R;



/**
 * 
 *
 * @author seaton
 * @email 1179130487@qq.com
 * @date 2022-11-08 21:01:09
 */
@RestController
@RequestMapping("userwalletrecord")
public class UserWalletRecordController {
    @Autowired
    private UserWalletRecordService userWalletRecordService;

    /**
     * 用户消费100元的接口
     * @param costVo
     * @return
     */

    @PostMapping("/cost")
    public R cost(@RequestBody CostVo costVo){
        String info = userWalletRecordService.cost(costVo);
        if(info.equals(WalletConstants.UNBALANCE)){
            return R.error("余额不足");
        }else {
            return R.ok();
        }

    }

    /**
     * 用户退款20元接口
     * @param refundVo
     * @return
     */
    @PostMapping("/refund")
    public R refund(@RequestBody RefundVo refundVo){
        userWalletRecordService.refund(refundVo);
        return R.ok();
    }


    /**
     * 查询用户钱包金额变动明细的接口
     * @param userId
     * @return
     */
    @RequestMapping("list")
    public R listbyUserId(@RequestParam("userId") Long userId){
        List<listVo> list = userWalletRecordService.listbyUserId(userId);
        //List<UserWalletRecordEntity> list = userWalletRecordService.list(new QueryWrapper<UserWalletRecordEntity>().eq("user_id", userId));
        return R.ok().put("list",list);
    }




}
