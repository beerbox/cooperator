package eu.garage64.cooperator.controllers;

import eu.garage64.cooperator.pojos.MessageContent;
import eu.garage64.cooperator.pojos.WsMessage;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class CooporatorController {

    @MessageMapping("/hello/{pageid}")
    @SendTo("/topic/greetings/{pageid}")
    public WsMessage greeting(@DestinationVariable(value = "pageid") String pageid,
                              @Payload MessageContent messageContent) throws Exception {
        System.out.println("received message on channel: "+ pageid);
        WsMessage msg = new WsMessage(UUID.randomUUID().toString(),messageContent, "/topic/greetings", "user");
        return msg;
    }
}
