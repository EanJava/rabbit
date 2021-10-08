package com.example.rabbit;

import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

import static org.apache.logging.log4j.LogManager.getLogger;

@EnableRabbit //нужно для активации обработки аннотаций @RabbitListener
@Component
public class RabbitMqListener {
    Logger logger = getLogger(RabbitMqListener.class);

    Random random = new Random();

    @RabbitListener(queues = "query-example-3-1")
    public void worker1(String message) {
        logger.info("accepted on worker 1 : " + message);
    }

    @RabbitListener(queues = "query-example-3-2")
    public void worker2(String message) {
        logger.info("accepted on worker 2 : " + message);
    }
}