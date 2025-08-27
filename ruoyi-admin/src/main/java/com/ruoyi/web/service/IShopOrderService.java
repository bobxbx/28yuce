package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntBill;
import com.ruoyi.web.entity.BntShopOrder;
import com.ruoyi.web.entity.BntUsers;


public interface IShopOrderService {

    TableDataInfo list(BntShopOrder bntShop, LoginUser loginUser);


}
