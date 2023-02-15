package com.seaton.wallet.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seaton.wallet.entity.UserWalletRecordEntity;
import com.seaton.wallet.vo.CostVo;
import com.seaton.wallet.vo.RefundVo;
import com.seaton.wallet.vo.listVo;

import java.util.List;

/**
 * 
 *
 * @author seaton
 * @email 1179130487@qq.com
 * @date 2022-11-08 21:01:09
 */
public interface UserWalletRecordService extends IService<UserWalletRecordEntity> {



    String cost(CostVo costVo);

    void refund(RefundVo refundVo);

    List<listVo> listbyUserId(Long userId);



}

