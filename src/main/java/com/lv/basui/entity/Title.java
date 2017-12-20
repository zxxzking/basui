package com.lv.basui.entity;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Table;

import java.sql.Timestamp;


@Table(name = "table")
public class Title {

    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "inserttime")
    private Timestamp inserttime;

    @Column(name = "updatetime")
    private Timestamp updatetime;

    @Column(name = "isactive")
    private Short isactive = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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