package vip.ddm.ddm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.*;

/*
@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		//在topic和user这两个域上可以向客户端发消息；
		config.enableSimpleBroker("/topic","/user");
		//客户端向服务端发送时的主题上面需要加"/app"作为前缀
		config.setApplicationDestinationPrefixes("/app");
		//给指定用户发送（一对一）的主题前缀是“/user/”;
		config.setUserDestinationPrefix("/user/");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//客户端创建连接时的url
		registry.addEndpoint("/webServer").setAllowedOrigins("*").withSockJS();
		System.out.println("服务端启动成功");
	}
}*/
