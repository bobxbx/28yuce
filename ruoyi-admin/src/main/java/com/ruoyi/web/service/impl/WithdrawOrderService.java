
package com.ruoyi.web.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.controller.mapper.ShopMapper;
import com.ruoyi.web.controller.mapper.UserMapper;
import com.ruoyi.web.controller.mapper.WebConfigMapper;
import com.ruoyi.web.controller.mapper.WithdrawOrderMapper;
import com.ruoyi.web.controller.tool.BigDecimalTool;
import com.ruoyi.web.entity.BntShop;
import com.ruoyi.web.entity.BntUsers;
import com.ruoyi.web.entity.BntWithdrawOrder;
import com.ruoyi.web.service.IShopService;
import com.ruoyi.web.service.IWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WithdrawOrderService implements IWithdrawService {
    @Autowired
    WithdrawOrderMapper withdrawOrderMapper;
    @Autowired
    AssociationSelectImpl associationSelect;
    @Autowired
    UserMapper userMapper;

    @Override
    public TableDataInfo list(BntWithdrawOrder bntWithdrawOrder, LoginUser loginUser) {
        QueryWrapper<BntWithdrawOrder> bannerQueryWrapper=new QueryWrapper<BntWithdrawOrder>().orderByDesc("create_time");

        if(bntWithdrawOrder.getFromId()!=null){
            bannerQueryWrapper.eq("from_id",bntWithdrawOrder.getFromId());
        }
        if(bntWithdrawOrder.getStatus()!=null){
            bannerQueryWrapper.eq("status",bntWithdrawOrder.getStatus());
        }
        if(StringUtil.isNotEmpty(bntWithdrawOrder.getUserName())){
            bannerQueryWrapper.eq("user_name",bntWithdrawOrder.getUserName());
        }
        if(StringUtil.isNotEmpty(bntWithdrawOrder.getOrderSn())){
            bannerQueryWrapper.eq("order_sn",bntWithdrawOrder.getOrderSn());
        }

        bannerQueryWrapper.orderByDesc("create_time");
        Page<Object> objects = PageHelper.startPage(bntWithdrawOrder.getPageNum(), bntWithdrawOrder.getPageSize());
        List<BntWithdrawOrder> bntBanners = withdrawOrderMapper.selectList(bannerQueryWrapper);

        return associationSelect.toList(objects,bntBanners) ;
    }

    @Override
    public AjaxResult edit(BntWithdrawOrder bntShop, LoginUser loginUser) {
        BntWithdrawOrder bntWithdrawOrder = withdrawOrderMapper.selectById(bntShop.getId());

        if(bntWithdrawOrder.getStatus()!=bntShop.getStatus()){
            if(bntShop.getStatus()==2){
                //成功
            }else {
                //失败
                BntUsers bntUsers = userMapper.selectById(bntShop.getFromId());
                bntUsers.setEth(BigDecimalTool.addNumberStr(bntUsers.getEth(),bntWithdrawOrder.getAmount()));
                userMapper.updateById(bntUsers);

            }
            withdrawOrderMapper.updateById(bntShop);
            return AjaxResult.success();
        }else {
          return   AjaxResult.error("无法修改");
        }

    }

}
