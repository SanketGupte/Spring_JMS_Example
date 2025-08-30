package com.sanket.jms.scheduler;

import com.sanket.jms.model.MessageObject;
import com.sanket.jms.sender.JmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledMessageSender {

    @Autowired
    private JmsSender sender;

    private final MessageObject infoMessage = new MessageObject("info", "info@example.com", 5000);
    private final MessageObject testMessage = new MessageObject("test", "test@example.com", 8000);

    @Scheduled(fixedRate = 5000)
    public void sendInfoMessage(){
        sender.sendMessage("test-message", infoMessage);
    }

    @Scheduled(fixedRate = 8000)
    public void sendTestMessage(){
        sender.sendMessage("test-message", testMessage);
    }

}
