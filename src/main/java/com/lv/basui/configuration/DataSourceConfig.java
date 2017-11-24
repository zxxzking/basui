package com.lv.basui.configuration;

import com.denghb.dbhelper.DbHelper;
import com.denghb.dbhelper.impl.DbHelperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public DbHelper dbHelper() {

        DbHelperImpl db = new DbHelperImpl();
        db.setJdbcTemplate(jdbcTemplate);
        return db;
    }
}
