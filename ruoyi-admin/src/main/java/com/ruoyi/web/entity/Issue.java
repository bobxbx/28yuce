package com.ruoyi.web.entity;

// 2. 开奖期数实体（对应 appData.issue 单个元素）
public class Issue {
    private String qishu;    // 期号
    private String time;     // 开奖时间
    private String num1;     // 第一个号码
    private String num2;     // 第二个号码
    private String num3;     // 第三个号码
    private Integer color;   // 颜色标识
    private String sum;      // 和值
    private Long next;       // 下期时间戳

    // Getter + Setter
    public String getQishu() { return qishu; }
    public void setQishu(String qishu) { this.qishu = qishu; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getNum1() { return num1; }
    public void setNum1(String num1) { this.num1 = num1; }
    public String getNum2() { return num2; }
    public void setNum2(String num2) { this.num2 = num2; }
    public String getNum3() { return num3; }
    public void setNum3(String num3) { this.num3 = num3; }
    public Integer getColor() { return color; }
    public void setColor(Integer color) { this.color = color; }
    public String getSum() { return sum; }
    public void setSum(String sum) { this.sum = sum; }
    public Long getNext() { return next; }
    public void setNext(Long next) { this.next = next; }
}
