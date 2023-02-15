package com.seaton.wallet.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.seaton.wallet.mapper.UserWalletDao;
import com.seaton.wallet.entity.UserWalletEntity;
import com.seaton.wallet.service.UserWalletService;


@Service("userWalletService")
public class UserWalletServiceImpl extends ServiceImpl<UserWalletDao, UserWalletEntity> implements UserWalletService {



}