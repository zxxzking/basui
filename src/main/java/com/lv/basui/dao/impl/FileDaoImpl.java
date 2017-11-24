package com.lv.basui.dao.impl;

import com.denghb.dbhelper.DbHelper;
import com.lv.basui.dao.FileDao;
import com.lv.basui.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDaoImpl implements FileDao {

    @Autowired
    private DbHelper dbHelper;


}
