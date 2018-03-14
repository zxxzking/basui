package com.lv.basui.interceptor;

import com.lv.basui.dto.SocketReceiveMsg;
import com.lv.basui.dto.SocketResp;
import com.lv.basui.dto.UserInfo;
import com.lv.basui.utils.SocketMessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SocketInterceptor implements WebSocketHandler {

    private Logger log = LoggerFactory.getLogger(SocketInterceptor.class);

    private static Map<String, WebSocketSession> sessions = new ConcurrentHashMap<String, WebSocketSession>();

    private static Map<String, UserInfo> onlineUsers = new ConcurrentHashMap<String, UserInfo>();


    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        log.info("socket链接已打开 id="+webSocketSession.getId());

        sessions.put(webSocketSession.getId(), webSocketSession);
        // 打开连接时 创建当前活跃用户对象
        UserInfo userInfo =  new UserInfo();
        onlineUsers.put(webSocketSession.getId(),userInfo);

        SocketResp resp = new SocketResp();
        resp.setOnlineNum(sessions.size());

        SocketMessageUtils.sendMessageToAll(resp,sessions);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {

        Object payload =  webSocketMessage.getPayload();
        System.out.println(payload.toString());


    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        log.debug("handleTransportError");

        sessions.remove(webSocketSession.getId());

        log.error(throwable.getMessage(), throwable);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        log.info("socket链接已关闭 id="+webSocketSession.getId());
        sessions.remove(webSocketSession.getId());

        SocketResp resp = new SocketResp();
        resp.setOnlineNum(sessions.size());

        SocketMessageUtils.sendMessageToAll(resp,sessions);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
