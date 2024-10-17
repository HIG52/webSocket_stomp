package com.example.websocketstomp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket 메시지 처리를 활성화하는 WebSocket 설정 클래스입니다.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 메시지 브로커를 구성합니다. "/topic" 접두사를 가진 간단한 메모리 내 메시지 브로커를 활성화하고,
     * 애플리케이션 목적지 접두사를 "/app"으로 설정합니다.
     *
     * @param config 메시지 브로커 레지스트리
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * STOMP 엔드포인트를 등록합니다. "/ws" 엔드포인트를 추가하고 SockJS 폴백 옵션을 활성화합니다.
     *
     * @param registry STOMP 엔드포인트 레지스트리
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

}