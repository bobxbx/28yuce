package com.ruoyi.web.entity;

import java.util.List;

// 1. 顶层数据实体（对应 appData）
public class LotteryData {
    private
    List<Issue> issue;       // 开奖期数数据（对应 appData.issue）
    private Num num;                 // 统计数据（对应 appData.num）
    private List<Forecast> forecast; // 预测数据（对应 appData.forecast）
    private TimeData time;           // 时间数据（对应 appData.time）

    // Getter + Setter
    public List<Issue> getIssue() { return issue; }
    public void setIssue(List<Issue> issue) { this.issue = issue; }
    public Num getNum() { return num; }
    public void setNum(Num num) { this.num = num; }
    public List<Forecast> getForecast() { return forecast; }
    public void setForecast(List<Forecast> forecast) { this.forecast = forecast; }
    public TimeData getTime() { return time; }
    public void setTime(TimeData time) { this.time = time; }
}
