
package com.ruoyi.web.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.controller.mapper.BillMapper;
import com.ruoyi.web.controller.mapper.UserMapper;
import com.ruoyi.web.controller.mapper.WithdrawOrderMapper;
import com.ruoyi.web.controller.tool.BigDecimalTool;
import com.ruoyi.web.entity.BntBill;
import com.ruoyi.web.entity.BntUsers;
import com.ruoyi.web.entity.BntWithdrawOrder;
import com.ruoyi.web.service.IBillService;
import com.ruoyi.web.service.IWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillService implements IBillService {
    @Autowired
    BillMapper billMapper;
    @Autowired
    AssociationSelectImpl associationSelect;
    @Autowired
    UserMapper userMapper;

    @Override
    public TableDataInfo list(BntBill bntBill, LoginUser loginUser) {
        QueryWrapper<BntBill> bannerQueryWrapper=new QueryWrapper<BntBill>().orderByDesc("create_time");

        if(bntBill.getFromId()!=null){
            bannerQueryWrapper.eq("from_id",bntBill.getFromId());
        }
        if(bntBill.getBillType()!=null){
            bannerQueryWrapper.eq("bill_type",bntBill.getBillType());
        }
        if(bntBill.getType()!=null){
            bannerQueryWrapper.eq("type",bntBill.getType());
        }

        bannerQueryWrapper.orderByDesc("create_time");
        Page<Object> objects = PageHelper.startPage(bntBill.getPageNum(), bntBill.getPageSize());
        List<BntBill> bntBanners = billMapper.selectList(bannerQueryWrapper);

        return associationSelect.toList(objects,bntBanners) ;
    }

    @Override
    public void addBill(int type, int bill_type, String amount, BntUsers bntUser, String remark) {
        String money="0";

        BntBill bntBill=new BntBill();
        bntBill.setBillType((long) bill_type);
        bntBill.setType((long) type);
        bntBill.setCreateTime(String.valueOf(new Date().getTime()));
        bntBill.setAmount(amount);
        bntBill.setFromId(bntUser.getId());
        if(type==1){
            bntBill.setNewAmount(BigDecimalTool.Subtract(money,amount));
        }else {
            bntBill.setNewAmount(BigDecimalTool.addNumberStr(money,amount));
        }
        bntBill.setLastAmount(money);
        bntBill.setRemark(remark);
        billMapper.insert(bntBill);
    }


}
