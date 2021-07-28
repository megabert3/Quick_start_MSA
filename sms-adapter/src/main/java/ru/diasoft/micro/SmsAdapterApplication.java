package ru.diasoft.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import ru.diasoft.micro.consumer.ConsumerChannels;
import ru.diasoft.micro.producer.ProducerChanel;

@SpringBootApplication
@EnableBinding({ConsumerChannels.class, ProducerChanel.class})
public class SmsAdapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmsAdapterApplication.class, args);
    }
}
