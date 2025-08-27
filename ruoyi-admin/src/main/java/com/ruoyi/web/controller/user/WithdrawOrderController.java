package com.ruoyi.web.controller.user;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntShop;
import com.ruoyi.web.entity.BntWithdrawOrder;
import com.ruoyi.web.service.IShopService;
import com.ruoyi.web.service.IWithdrawService;
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
@RequestMapping("/defi/withdrawOrder")
public class WithdrawOrderController extends BaseController {
    @Autowired
    private IWithdrawService iWithdrawService;


    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BntWithdrawOrder bntShop)
    {
        return   getDataTables(iWithdrawService.list(bntShop,getLoginUser()));
    }
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody BntWithdrawOrder bntShop)
    {
        return  iWithdrawService.edit(bntShop,getLoginUser());
    }

}
