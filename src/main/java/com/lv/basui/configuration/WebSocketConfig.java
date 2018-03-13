package com.lv.basui.configuration;

import com.lv.basui.interceptor.SocketInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(myWebSocketHandler(), "/zxxz-socket").setAllowedOrigins("*");
    }


    @Bean
    public WebSocketHandler myWebSocketHandler() {
        return new SocketInterceptor();
    }
}
