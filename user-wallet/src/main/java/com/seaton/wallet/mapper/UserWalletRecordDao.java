package com.seaton.wallet.mapper;

import com.seaton.wallet.entity.UserWalletRecordEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seaton.wallet.vo.listVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author seaton
 * @email 1179130487@qq.com
 * @date 2022-11-08 21:01:09
 */
@Mapper
public interface UserWalletRecordDao extends BaseMapper<UserWalletRecordEntity> {

    List<listVo> listbyUserId(@Param("userId") Long userId);
}
