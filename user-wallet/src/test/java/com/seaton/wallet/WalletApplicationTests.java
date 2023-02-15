package com.seaton.wallet;

import com.seaton.wallet.entity.UserWalletEntity;
import com.seaton.wallet.service.UserWalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class WalletApplicationTests {

    @Autowired
    UserWalletService userWalletService;

    @Test
    void contextLoads() {
        UserWalletEntity walletEntity = new UserWalletEntity();
        walletEntity.setWalletAmount(BigDecimal.valueOf(1000.00));
        walletEntity.setUserId(1L);
        walletEntity.setCreateTime(new Date());
        walletEntity.setUpdateTime(new Date());
        userWalletService.save(walletEntity);
    }



}
