package com.lv.basui.dao.impl;

import com.denghb.dbhelper.DbHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class BaseDao {

    @Autowired
    public DbHelper dbHelper;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");

    @Transactional(
            propagation = Propagation.REQUIRES_NEW
    )
    public synchronized Long generatorKey(String tableName) {
        String sql1 = "select id from sequence where name = ?";
        Integer nextval = (Integer)this.dbHelper.queryForObject(sql1, Integer.class,tableName);
        String ymd = sdf.format(new Date());
        String sql2 = "update sequence set id = id+1 where name = ?";
        dbHelper.execute(sql2,tableName);
        return Long.parseLong(ymd + nextval);
    }
}
