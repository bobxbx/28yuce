package com.ruoyi.web.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BntShop {
  @TableId(value="id",type= IdType.AUTO)
  private long id;
  private String image;
  private String createTime;
  private Boolean status;
  private long sort;
  private long type;

  private String nameEn;
  private String nameZh;
  private String specificationsZh;
  private String specificationsEn;
  private String colorZh;
  private String colorEn;
  private Boolean newShop;
  @TableField(exist = false)
  private int pageNum;
  @TableField(exist = false)
  private int pageSize;
  @TableField(exist = false)
  private String typeName;

}
