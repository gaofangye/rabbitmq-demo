package cn.gaofangye.rabbitmqdemo.demo1.service.impl;

import cn.gaofangye.rabbitmqdemo.demo1.service.Demo1ProducerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Demo1ProducerServiceImpl implements Demo1ProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "hello")
    public void handleMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @Override
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("", "hello", message);
    }
}
