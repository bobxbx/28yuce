package com.ruoyi.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BntWithdrawOrder {
  @TableId(value="id",type= IdType.AUTO)

  private Long id;
  private String fromId;
  private String userName;
  private String orderSn;
  private String createTime;
  private Long status;
  private String amount;
  private String withdrawUrl;
  private String withdrawTime;
  @TableField(exist = false)
  private int pageNum;
  @TableField(exist = false)
  private int pageSize;


}
