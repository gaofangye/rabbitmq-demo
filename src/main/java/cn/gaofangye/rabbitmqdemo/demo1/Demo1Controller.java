package cn.gaofangye.rabbitmqdemo.demo1;

import cn.gaofangye.rabbitmqdemo.demo1.service.Demo1ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo1")
@RestController
public class Demo1Controller {

    @Autowired
    private Demo1ProducerService demo1ProducerService;

    @PostMapping("/sendMessage")
    public String sendMessage(String message) {
        demo1ProducerService.sendMessage(message);
        return "SUCCESS";
    }
}
