package com.sanket.jms.receiver;

import com.sanket.jms.exception.InvalidRecipientException;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//This is the Consumer class which will receive messages from the queue
@Component
public class JmsReceiver {

    @JmsListener(destination = "test-message")
    public void receiveMessage(Message message) throws JMSException {
        try{
            if(message instanceof TextMessage){
                TextMessage textMessage = (TextMessage) message;
                String content = textMessage.getText();
                String recipient = textMessage.getStringProperty("recipient");
                if("test@example.com".equalsIgnoreCase(recipient)){
                    throw new InvalidRecipientException("Invalid recipient: " + recipient);
                } else if ("info@example.com".equalsIgnoreCase(recipient)) {
                    System.out.println("Dumping message to info log: " + content);
                } else {
                    System.out.println("Processing message for recipient " + recipient + ": " + content);
                }
            }
        } catch (InvalidRecipientException e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
    }

}
