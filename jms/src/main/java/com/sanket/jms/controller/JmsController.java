package com.sanket.jms.controller;

import com.sanket.jms.model.MessageObject;
import com.sanket.jms.sender.JmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsController {

    @Autowired
    private JmsSender jmsSender;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageObject message){
        jmsSender.sendMessage("test-message", message);
        return ResponseEntity.ok("Message sent with the Delay of " + message.intervalMillis() + " ms");
    }

}
