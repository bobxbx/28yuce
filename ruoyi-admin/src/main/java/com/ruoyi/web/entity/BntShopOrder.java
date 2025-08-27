package com.ruoyi.web.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BntShopOrder {
  @TableId(value="id",type= IdType.AUTO)
  private long id;
  private Long fromShopId;
  private String image;
  private String eth;
  private Long day;
  private String orderTime;
  private String price;
  private Long fromId;
  private Boolean isDue;
  private String mEth;
  private String gh;
  private String endTime;
  @TableField(exist = false)
  private int pageNum;
  @TableField(exist = false)
  private int pageSize;


}
