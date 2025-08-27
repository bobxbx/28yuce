package com.ruoyi.web.entity;

// 5. 时间数据实体（对应 appData.time）
public class TimeData {
    private Integer t;       // 总秒数
    private String h;        // 小时
    private Integer m;       // 分钟
    private Integer s;       // 秒

    // Getter + Setter
    public Integer getT() { return t; }
    public void setT(Integer t) { this.t = t; }
    public String getH() { return h; }
    public void setH(String h) { this.h = h; }
    public Integer getM() { return m; }
    public void setM(Integer m) { this.m = m; }
    public Integer getS() { return s; }
    public void setS(Integer s) { this.s = s; }
}
