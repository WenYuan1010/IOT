package com.example.springbootkafka;
import java.util.Date;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j//日志用 log
public class Producer {
    private Logger log = LoggerFactory.getLogger(Producer.class);
    private final KafkaTemplate<String,String> kafkaTemplate;
    public Producer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }
    private Gson gson=new Gson();
    public void send(String msg){
        MyMessage myMessage=new MyMessage();
        myMessage.setId(System.currentTimeMillis());
        myMessage.setMsg(msg);
        myMessage.setSendTime(new Date());
        kafkaTemplate.send("hello",gson.toJson(myMessage));
        log.info("\n发送消息成功！！！消息为："+gson.toJson(myMessage));
        log.info("\n发送消息成功！");
        //System.out.println("类型是："+gson.fromJson(gson.toJson(myMessage),HashMap.class).getClass());
        //先实例化map，要不然报错。
        /*HashMap<String,Object> map=gson.fromJson(gson.toJson(myMessage),HashMap.class);
        for(Map.Entry<String,Object> entry:map.entrySet()){
            System.out.println(entry.getValue());
        }
*/
    }
}
