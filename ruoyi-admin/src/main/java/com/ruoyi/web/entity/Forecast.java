package com.ruoyi.web.entity;

// 4. 预测数据实体（对应 appData.forecast 单个元素）
public class Forecast {
    private String qishu;    // 期号
    private String dx;       // 大小预测（HTML 片段）
    private String ds;       // 单双预测（HTML 片段）
    private String kjcode;   // 开奖号码
    private String yesno;    // 命中结果（HTML 片段）

    // Getter + Setter
    public String getQishu() { return qishu; }
    public void setQishu(String qishu) { this.qishu = qishu; }
    public String getDx() { return dx; }
    public void setDx(String dx) { this.dx = dx; }
    public String getDs() { return ds; }
    public void setDs(String ds) { this.ds = ds; }
    public String getKjcode() { return kjcode; }
    public void setKjcode(String kjcode) { this.kjcode = kjcode; }
    public String getYesno() { return yesno; }
    public void setYesno(String yesno) { this.yesno = yesno; }
}
