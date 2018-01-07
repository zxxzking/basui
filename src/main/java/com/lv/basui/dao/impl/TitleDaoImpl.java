package com.lv.basui.dao.impl;

import com.denghb.dbhelper.DbHelper;
import com.lv.basui.dao.TitleDao;
import com.lv.basui.entity.Text;
import com.lv.basui.entity.Title;
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


    @Override
    public Text queryText(int id){
        String sql = "select * from text where title_id = ? and isactive = '1'";
        Text text = dbHelper.queryForObject(sql, Text.class, id);
        return text;
    }






}
