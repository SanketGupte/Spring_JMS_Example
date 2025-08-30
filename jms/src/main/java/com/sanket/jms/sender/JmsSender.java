package com.sanket.jms.sender;

import com.sanket.jms.model.MessageObject;
import jakarta.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

//This is the Producer class which will send messages to the queue
@Component
public class JmsSender {

    @Autowired
    private JmsTemplate template;

    public void sendMessage(String destination, MessageObject message){
        template.send(destination, session -> {
            TextMessage textMessage = session.createTextMessage(message.content());
            textMessage.setStringProperty("recipient", message.recipient());
            return textMessage;
        });
    }

}
