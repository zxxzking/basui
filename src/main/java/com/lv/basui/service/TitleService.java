package com.lv.basui.service;


import com.lv.basui.entity.Text;
import com.lv.basui.entity.Title;

import java.util.List;

public interface TitleService {


    List<Title> listTitle();

    Text querySpecificContent(int titleId);

    Title getTitle(int titleId);
}
