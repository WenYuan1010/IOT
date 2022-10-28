package com.example.springbootkafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class Consumer {
    @KafkaListener(topics = {"hello"})
    public void listen(ConsumerRecord<?,?> record){
        Optional.ofNullable(record.value())
                .ifPresent(myMessage->{
                    System.out.println(" record = "+ record);
                    System.out.println(" message = "+myMessage);
                });
    }

}
