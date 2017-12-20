package com.lv.basui.dao.impl;

import com.denghb.dbhelper.DbHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {

    @Autowired
    public DbHelper dbHelper;
}
