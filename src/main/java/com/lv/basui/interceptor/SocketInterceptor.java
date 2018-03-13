package com.lv.basui.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SocketInterceptor implements WebSocketHandler {

    private Logger log = LoggerFactory.getLogger(SocketInterceptor.class);

    private static Map<String, WebSocketSession> sessions = new ConcurrentHashMap<String, WebSocketSession>();

    private static Map<String, String> onlineUsers = new ConcurrentHashMap<String, String>();


    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        sessions.put(webSocketSession.getId(), webSocketSession);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {

        onlineUsers.put(webSocketMessage.getPayload().toString(),webSocketSession.getId());

        Iterator<String> iterator = sessions.keySet().iterator();
        while (iterator.hasNext()){
            String entry = iterator.next();
            WebSocketSession session = sessions.get(entry);
            session.sendMessage(new TextMessage(String.valueOf(sessions.size())));


        }

    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        log.debug("handleTransportError");

        sessions.remove(webSocketSession.getId());

        log.error(throwable.getMessage(), throwable);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.out.println("afterConnectionClosed");
        sessions.remove(webSocketSession.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
