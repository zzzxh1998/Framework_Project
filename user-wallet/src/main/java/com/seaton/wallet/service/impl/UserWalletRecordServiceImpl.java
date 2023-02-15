package com.seaton.wallet.service.impl;

import com.seaton.wallet.Constants.WalletConstants;
import com.seaton.wallet.mapper.UserWalletDao;
import com.seaton.wallet.entity.UserWalletEntity;
import com.seaton.wallet.vo.CostVo;
import com.seaton.wallet.vo.RefundVo;
import com.seaton.wallet.vo.listVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.seaton.wallet.mapper.UserWalletRecordDao;
import com.seaton.wallet.entity.UserWalletRecordEntity;
import com.seaton.wallet.service.UserWalletRecordService;
import org.springframework.transaction.annotation.Transactional;


@Service("userWalletRecordService")
public class UserWalletRecordServiceImpl extends ServiceImpl<UserWalletRecordDao, UserWalletRecordEntity> implements UserWalletRecordService {


    @Autowired
    UserWalletRecordDao userWalletRecordDao;

    @Autowired
    UserWalletDao userWalletDao;

    @Override
    @Transactional
    public String cost(CostVo costVo) {
        //查找当前用户的余额
        UserWalletEntity userWallet = userWalletDao.selectOne(new QueryWrapper<UserWalletEntity>().eq("user_id", costVo.getUserId()));
        BigDecimal walletAmount = userWallet.getWalletAmount();

        BigDecimal balance = walletAmount.subtract(costVo.getAmount());
        //当钱包余额小于花费的金额时，返回
        if(balance.compareTo(BigDecimal.ZERO) < 0){
            return WalletConstants.UNBALANCE;
        }else {
            //添加消费记录
            UserWalletRecordEntity userWalletRecord = new UserWalletRecordEntity();
            userWalletRecord.setOldAmount(walletAmount);
            userWalletRecord.setOrderId(costVo.getOrderId());
            userWalletRecord.setAmount(costVo.getAmount());
            userWalletRecord.setType(0);
            userWalletRecord.setUpdateTime(new Date());
            userWalletRecord.setUserId(costVo.getUserId());
            userWalletRecordDao.insert(userWalletRecord);

            //修改钱包数据
            userWallet.setWalletAmount(balance);
            userWallet.setUpdateTime(new Date());
            userWalletDao.updateById(userWallet);
            return WalletConstants.SUCCESS;
        }




    }

    @Override
    public List<listVo> listbyUserId(Long userId) {
        List<listVo> list = userWalletRecordDao.listbyUserId(userId);
        return list;
    }

    /**
     * 用户退款20元接口
     * @param refundVo
     */
    @Override
    @Transactional
    public void refund(RefundVo refundVo) {

        UserWalletRecordEntity userWalletRecord = new UserWalletRecordEntity();
        BigDecimal walletAmount = userWalletDao.selectOne(new QueryWrapper<UserWalletEntity>().eq("user_id", refundVo.getUserId())).getWalletAmount();
        userWalletRecord.setOldAmount(walletAmount);
        userWalletRecord.setUserId(refundVo.getUserId());
        userWalletRecord.setAmount(refundVo.getAmount());
        userWalletRecord.setOrderId(refundVo.getOrderId());
        userWalletRecord.setType(1);
        userWalletRecord.setUpdateTime(new Date());
        userWalletRecordDao.insert(userWalletRecord);

        //修改钱包金额
        UserWalletEntity userWallet = userWalletDao.selectOne(new QueryWrapper<UserWalletEntity>().eq("user_id", refundVo.getUserId()));
        userWallet.setWalletAmount(userWallet.getWalletAmount().add(refundVo.getAmount()));
        userWallet.setUpdateTime(new Date());
        userWalletDao.updateById(userWallet);
    }








}