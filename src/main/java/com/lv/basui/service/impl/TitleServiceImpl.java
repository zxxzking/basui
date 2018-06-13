package com.lv.basui.service.impl;

import com.lv.basui.dao.TitleDao;
import com.lv.basui.entity.Text;
import com.lv.basui.entity.Title;
import com.lv.basui.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Transactional(rollbackFor = Exception.class)
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleDao titleDao;


    @Override
    public List<Title> listTitle(){

        Map map = new HashMap();

        Set set = map.entrySet();
        Iterator<Map.Entry> iterator = set.iterator();

        List<Title> list = titleDao.queryTitleList();
/*
        for (Title title:list) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String newDate = format.format(title.getInserttime());

            String[] split = newDate.split(" ")[0].split("-");
            newDate = split[1]+"-"+split[2];
            title.setPublishDate(newDate);

        }*/
        return titleDao.queryTitleList();

    }

    @Override
    public Text querySpecificContent(int titleId){
        return titleDao.queryText(titleId);
    }

    @Override
    public Title getTitle(int titleId){
        return titleDao.queryTitle(titleId);
    }


    public static void main(String[] args) {




        File[] roots = File.listRoots();
        for (int i =0; i < roots.length; i++) {
            System.out.println(roots[i].getPath());
        }



        /*File file = new File("C://");

        if(file.exists()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                System.out.println(file1.getName());
            }


        }*/
    }

}
