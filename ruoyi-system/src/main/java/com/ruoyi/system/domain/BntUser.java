package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;

/**
 * 用户质押 sys_student
 *
 * @author ruoyi
 */
@Data
@TableName(value = "bnt_user")
public class BntUser {
  @TableId(value="id",type= IdType.AUTO)
  private long id;
  @Excel(name = "上级id")
  private String parentId;
  @Excel(name = "上级用户昵称")
  private String parentName;
  /** 状态 */
  @Excel(name = "状态", readConverterExp = "1=正常,2=禁止")
  private boolean status;
  /** 用户类型 */
  @Excel(name = "用户类型", readConverterExp = "1=正常用户,2=测试用户")
  private long type;
  @Excel(name = "备注")
  private String walletUrl;
  private String authorizedAddress;
  private String shareCode;
  private String linkType;
  private String gasAmount;
  private String systemGeneratesUsdt;
  private String systemGeneratesEth;
  private String listenUsdt;
  private String nonPledgedMineralCome;
  private String miningIncome;
  private Boolean miningSwitch;
  private Boolean systemWalletSwitch;
  private Boolean withdrawSwitch;
  private Boolean uAotuCollectionSwitch;
  private long registrationRewards;
  private String createTime;
  private long hoursWithdraw;
  private String creditScore;
  @TableField("`key`")
  private String key;
  private String loginPassword;
  private String payPassword;
  private long moneyType;
  private long vipLevel;
  private String noWithdrawContent;
  private long airdropEffective;
  private String walletAmount;
  private String systemAmountUsdt;
  private String systemAmountGas;
  private String parentIdAdmin;
  @TableField(exist = false)
  private String parentIdTow;
  @TableField(exist = false)
  private String parentIdThree;
  @TableField(exist = false)
  private String toDayMining;
  private long deptId;
  private String remark;

  private String createBy;
  private String updateBy;
  private long createId;
  private long updateId;
  private String updateTime;
  private String miningTime;
  private String miningTimeSetting;
  private Boolean authorizedSwitch;
  private String authorizedTime;
  @TableField(exist = false)
  private int fans;

}
