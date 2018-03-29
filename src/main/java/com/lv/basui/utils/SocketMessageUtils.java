package com.lv.basui.utils;

import com.lv.basui.dto.SocketResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Iterator;
import java.util.Map;

public class SocketMessageUtils {

    private static Logger logger = LoggerFactory.getLogger(SocketMessageUtils.class);


    public static void sendMessageToAll(SocketResp resp,Map<String, WebSocketSession> sessions) throws Exception{
        resp.setOnlineNum(sessions.size());
        Iterator<String> iterator = sessions.keySet().iterator();
        while (iterator.hasNext()){
            String entry = iterator.next();
            WebSocketSession session = sessions.get(entry);
            logger.info("给id为"+session.getId()+"的用户发送消息");
            session.sendMessage(new TextMessage(resp.toJsonString()));
        }
    }
}
