package com.ruoyi.web.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BntUsers {
  @TableId(value="id",type= IdType.AUTO)
  private long id;
  private Long parentId;
  private String firstName;
  private String lastName;
  private String username;
  private String photoUrl;
  private String eth;
  private String createTime;
  private String water;
  private String tgId;
  private String shareCode;
  private Boolean status;
  private String withdrawUrl;
  @TableField(exist = false)
  private String miningEth; //当前挖了多少eth 没收割
  @TableField(exist = false)
  private String miningEthValue; //当前每秒产生多少eth
  @TableField(exist = false)
  private String rate;
  @TableField(exist = false)
  private int pageNum;
  @TableField(exist = false)
  private int pageSize;
  @TableField(exist = false)

  private String startTime;
  @TableField(exist = false)

  private String endTime;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }


  public String getEth() {
    return eth;
  }

  public void setEth(String eth) {
    this.eth = eth;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getWater() {
    return water;
  }

  public void setWater(String water) {
    this.water = water;
  }

}
