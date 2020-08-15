package com.project.customer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerMessageQueue {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping ("/receiveMessage")
    public String get(){
        Object firstQueues = rabbitTemplate.receiveAndConvert("FirstQueue");
        return "Return value from the queue: "+firstQueues.toString();
    }

    @RabbitListener (queues = "SecondQueue")
    public void rabbitListner(String message){
        System.out.println("Return value from the Rabbit Listner Queue: "+message);
    }


}
