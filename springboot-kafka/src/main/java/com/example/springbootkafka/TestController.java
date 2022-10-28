package com.example.springbootkafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private Producer producer;
    @GetMapping( value = "/hello")
    public void sendMessage(@RequestParam("msg")String message){
        //System.out.println(message);
        producer.send(message);
    }

}
