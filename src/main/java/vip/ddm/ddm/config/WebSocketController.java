package vip.ddm.ddm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/*@Controller
public class WebSocketController {


    public SimpMessagingTemplate template;

    @Autowired
    public WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    *//**
     * 服务端可以接收客户端通过主题“/app/hello”发送过来的消息，客户端需要在主题"/topic/hello"上监听并接收服务端发回的消息
     *//*
    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public void greeting(String message) throws IOException, InterruptedException {


    }

    *//**
     * 发送给单一客户端的标志。本例中，客户端接收一对一消息的主题应该是“/user/message” ,
     * 这里的用户id可以是一个普通的字符串，只要每个用户端都使用自己的id并且服务端知道每个用户的id就行。
     *//*
    @MessageMapping("/message")
    @SendToUser("/message")
    public void userMessage(String message) throws Exception {

    }

}*/
