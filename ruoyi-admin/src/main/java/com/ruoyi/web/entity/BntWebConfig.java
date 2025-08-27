package com.ruoyi.web.entity;


import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "bnt_web_config")
public class BntWebConfig {
  @TableId(value="id",type= IdType.AUTO)
  private long id;
  private String name;
  private long type;
  private String content;
  @TableField(exist = false)
  private JSONObject contentJson;

  public JSONObject getContentJson() {
    return contentJson;
  }

  public void setContentJson(JSONObject contentJson) {
    this.contentJson = contentJson;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
