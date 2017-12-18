package com.lv.basui.service.impl;

import com.lv.basui.dao.TitleDao;
import com.lv.basui.entity.Text;
import com.lv.basui.entity.Title;
import com.lv.basui.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleDao titleDao;


    @Override
    public List<Title> listTitle(){

        return titleDao.queryTitleList();

    }

    @Override
    public Text querySpecificContent(int titleId){
        return titleDao.queryText(titleId);
    }

}
