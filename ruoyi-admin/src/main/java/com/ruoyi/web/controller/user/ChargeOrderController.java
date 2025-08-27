package com.ruoyi.web.controller.user;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntChargeOrder;
import com.ruoyi.web.entity.BntChargeSetting;
import com.ruoyi.web.service.IChargeOrderService;
import com.ruoyi.web.service.IChargeSettingService;
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
@RequestMapping("/defi/chargeOrder")
public class ChargeOrderController extends BaseController {
    @Autowired
    private IChargeOrderService iChargeOrderService;


    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BntChargeOrder bntChargeOrder)
    {
        return   getDataTables(iChargeOrderService.list(bntChargeOrder,getLoginUser()));
    }
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody BntChargeOrder bntChargeOrder)
    {
        return  iChargeOrderService.edit(bntChargeOrder,getLoginUser());
    }



}
