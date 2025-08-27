package com.ruoyi.web.entity;


import java.util.Map;

// 3. 统计数据实体（对应 appData.num）
public class Num {
    private Map<String, String> pode_data; // 数值未开期数（K0-K27）
    private Map<String, String> done_data; // 大小单双未开期数（DA/XIAO/DAN 等）

    // Getter + Setter
    public Map<String, String> getPode_data() { return pode_data; }
    public void setPode_data(Map<String, String> pode_data) { this.pode_data = pode_data; }
    public Map<String, String> getDone_data() { return done_data; }
    public void setDone_data(Map<String, String> done_data) { this.done_data = done_data; }
}