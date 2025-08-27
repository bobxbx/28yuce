package com.ruoyi.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class BntShopType {

  private long id;
  private String nameZh;
  private String nameEn;

  @TableField(exist = false)
  private int pageNum;
  @TableField(exist = false)
  private int pageSize;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getNameZh() {
    return nameZh;
  }

  public void setNameZh(String nameZh) {
    this.nameZh = nameZh;
  }


  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }

}
