package com.lv.basui.dao;

import com.lv.basui.entity.Text;
import com.lv.basui.entity.Title;

import java.util.List;

public interface TitleDao {
    List queryTitleList();

    Text queryText(int id);

    Title queryTitle(int id);
}
