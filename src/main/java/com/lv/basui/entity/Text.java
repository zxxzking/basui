package com.lv.basui.entity;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Table;

import java.sql.Timestamp;


@Table(name = "text")
public class Text {

    @Column(name = "id")
    private Integer id;

    @Column(name = "title_id")
    private Integer titleId;

    @Column(name = "content")
    private String content;

    @Column(name = "inserttime")
    private Timestamp inserttime;

    @Column(name = "updatetime")
    private Timestamp updatetime;

    @Column(name = "isactive")
    private Short isactive = 1;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
