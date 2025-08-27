package com.ruoyi.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;



@Data
public class BntBill {
  @TableId(value="id",type= IdType.AUTO)

  private long id;
  private Long billType;
  private Long type;
  private String createTime;
  private Long fromId;
  private String amount;
  private String lastAmount;
  private String newAmount;
  private String remark;

  @TableField(exist = false)
  private int pageNum;

  @TableField(exist = false)
  private int pageSize;


}
