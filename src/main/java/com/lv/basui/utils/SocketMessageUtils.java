package com.lv.basui.utils;

import com.lv.basui.dto.SocketResp;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Iterator;
import java.util.Map;

public class SocketMessageUtils {


    public static void sendMessageToAll(SocketResp resp,Map<String, WebSocketSession> sessions) throws Exception{
        resp.setOnlineNum(sessions.size());
        Iterator<String> iterator = sessions.keySet().iterator();
        while (iterator.hasNext()){
            String entry = iterator.next();
            WebSocketSession session = sessions.get(entry);
            session.sendMessage(new TextMessage(resp.toJsonString()));
        }
    }
}
