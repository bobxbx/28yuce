package com.ruoyi.web.controller.user;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntBill;
import com.ruoyi.web.entity.BntWithdrawOrder;
import com.ruoyi.web.service.IBillService;
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
@RequestMapping("/defi/bill")
public class BillController extends BaseController {
    @Autowired
    private IBillService iBillService;


    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BntBill bntBill)
    {
        return   getDataTables(iBillService.list(bntBill,getLoginUser()));
    }


}
