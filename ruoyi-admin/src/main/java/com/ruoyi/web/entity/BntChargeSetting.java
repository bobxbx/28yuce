package com.ruoyi.web.entity;


import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BntChargeSetting {
  @TableId(value="id",type= IdType.AUTO)

  private long id;
  private String waterNum;
  private String price;
  private String rate;
  private String createTime;

  @TableField(exist = false)
  private int pageNum;

  @TableField(exist = false)
  private int pageSize;


}
