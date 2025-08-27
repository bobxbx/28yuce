package com.ruoyi.web.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BntChargeOrder {
  @TableId(value="id",type= IdType.AUTO)
  private long id;
  private long paymentType;
  private String remark;
  private String amount;
  private String ton;
  private String txHash;
  private String createTime;
  private long fromChargeSetting;
  private long fromId;
  private String water;
  private long status;
  private String chargeUrl;
  private String completionTime;
  @TableField(exist = false)
  private int pageNum;
  @TableField(exist = false)
  private int pageSize;
  @TableField(exist = false)

  private String startTime;
  @TableField(exist = false)

  private String endTime;

}
