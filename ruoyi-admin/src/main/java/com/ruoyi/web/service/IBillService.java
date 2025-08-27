package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntBill;
import com.ruoyi.web.entity.BntUsers;
import com.ruoyi.web.entity.BntWithdrawOrder;


public interface IBillService {

    TableDataInfo list(BntBill bntShop, LoginUser loginUser);

    void addBill(int type, int bill_type, String amount, BntUsers bntUser, String remark);

}
