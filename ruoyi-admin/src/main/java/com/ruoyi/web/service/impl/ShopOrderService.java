
package com.ruoyi.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.controller.mapper.BillMapper;
import com.ruoyi.web.controller.mapper.ShopOrderMapper;
import com.ruoyi.web.controller.mapper.UserMapper;
import com.ruoyi.web.controller.tool.BigDecimalTool;
import com.ruoyi.web.entity.BntBill;
import com.ruoyi.web.entity.BntShopOrder;
import com.ruoyi.web.entity.BntUsers;
import com.ruoyi.web.service.IBillService;
import com.ruoyi.web.service.IShopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShopOrderService implements IShopOrderService {
    @Autowired
    ShopOrderMapper shopOrderMapper;
    @Autowired
    AssociationSelectImpl associationSelect;
    @Autowired
    UserMapper userMapper;

    @Override
    public TableDataInfo list(BntShopOrder bntBill, LoginUser loginUser) {
        QueryWrapper<BntShopOrder> bannerQueryWrapper=new QueryWrapper<BntShopOrder>().orderByDesc("order_time");

        if(bntBill.getFromId()!=null){
            bannerQueryWrapper.eq("from_id",bntBill.getFromId());
        }
        if(bntBill.getFromShopId()!=null){
            bannerQueryWrapper.eq("from_shop_id",bntBill.getFromShopId());
        }


        bannerQueryWrapper.orderByDesc("order_time");
        Page<Object> objects = PageHelper.startPage(bntBill.getPageNum(), bntBill.getPageSize());
        List<BntShopOrder> bntBanners = shopOrderMapper.selectList(bannerQueryWrapper);

        return associationSelect.toList(objects,bntBanners) ;
    }



}
