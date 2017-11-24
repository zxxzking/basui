package com.lv.basui.service.impl;

import com.lv.basui.dao.FileDao;
import com.lv.basui.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;



}
