package com.ruoyi.web.controller.user;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntBill;
import com.ruoyi.web.entity.BntShopOrder;
import com.ruoyi.web.service.IBillService;
import com.ruoyi.web.service.IShopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/defi/shopOrder")
public class ShopOrderController extends BaseController {
    @Autowired
    private IShopOrderService iBillService;


    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BntShopOrder bntBill)
    {
        return   getDataTables(iBillService.list(bntBill,getLoginUser()));
    }


}
