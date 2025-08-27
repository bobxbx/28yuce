package com.ruoyi.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.controller.mapper.ChargeOrderMapper;
import com.ruoyi.web.controller.mapper.ChargeSettingMapper;
import com.ruoyi.web.controller.mapper.WebConfigMapper;
import com.ruoyi.web.entity.BntChargeOrder;
import com.ruoyi.web.entity.BntChargeSetting;
import com.ruoyi.web.service.IChargeOrderService;
import com.ruoyi.web.service.IChargeSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChargeOrderService implements IChargeOrderService {

    @Autowired
    AssociationSelectImpl associationSelect;
    @Autowired
    WebConfigMapper webConfigMapper;
    @Autowired
    ChargeOrderMapper chargeOrderMapper;
    @Override
    public TableDataInfo list(BntChargeOrder bntChargeSetting, LoginUser loginUser) {
        QueryWrapper<BntChargeOrder> bannerQueryWrapper=new QueryWrapper<BntChargeOrder>().orderByDesc("create_time");

        Page<Object> objects = PageHelper.startPage(bntChargeSetting.getPageNum(), bntChargeSetting.getPageSize());
        List<BntChargeOrder> bntBanners = chargeOrderMapper.selectList(bannerQueryWrapper);

        return associationSelect.toList(objects,bntBanners) ;
    }

    @Override
    public AjaxResult edit(BntChargeOrder bntShop, LoginUser loginUser) {
        chargeOrderMapper.updateById(bntShop);
        return AjaxResult.success();

    }




}
