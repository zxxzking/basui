package com.lv.basui.service;

import com.lv.basui.entity.WeChatInfo;
import org.springframework.transaction.annotation.Transactional;

public interface WeChatUserService {
    @Transactional(rollbackFor = Exception.class)
    String initUser(WeChatInfo info);
}
