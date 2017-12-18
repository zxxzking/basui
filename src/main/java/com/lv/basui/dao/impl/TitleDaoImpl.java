package com.lv.basui.dao.impl;

import com.denghb.dbhelper.DbHelper;
import com.lv.basui.dao.TitleDao;
import com.lv.basui.entity.Title;
import com.lv.basui.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TitleDaoImpl implements TitleDao {

    @Autowired
    private DbHelper dbHelper;


    @Override
    public List queryTitleList(){
        String sql = "select * from title";
        return dbHelper.list(sql, Title.class);
    }
}
