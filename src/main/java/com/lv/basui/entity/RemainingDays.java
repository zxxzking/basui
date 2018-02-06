package com.lv.basui.entity;


import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Table;

import java.sql.Timestamp;
import java.util.Date;

@Table(name = "remaining_day")
public class RemainingDays {

    @Column(name = "id")
    private Integer id;

    @Column(name = "days")
    private Integer days;

    @Column(name = "days_type")
    private String daysType;


    @Column(name = "description")
    private String description;

    @Column(name = "target_date")
    private Date targetDate;

    @Column(name = "inserttime")
    private Timestamp inserttime;

    @Column(name = "updatetime")
    private Timestamp updatetime;

    @Column(name = "isactive")
    private Short isactive = 1;

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getDaysType() {
        return daysType;
    }

    public void setDaysType(String daysType) {
        this.daysType = daysType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getInserttime() {
        return inserttime;
    }

    public void setInserttime(Timestamp inserttime) {
        this.inserttime = inserttime;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public Short getIsactive() {
        return isactive;
    }

    public void setIsactive(Short isactive) {
        this.isactive = isactive;
    }
}
