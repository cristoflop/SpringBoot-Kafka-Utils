package com.indra.hiperion.kafka.amqp;

import com.indra.hiperion.kafka.services.TopicsUtilsService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MonitoringTopicConsumer {

    private final Logger log = LoggerFactory.getLogger(TopicsUtilsService.class);

    private int count = 0;

    @Value("${SPECIFIC_TOPIC_TO_CONSUME}")
    private String topicToSubscribe;

    @KafkaListener(topics = {"#{monitoringTopicConsumer.getTopicToSubscribe()}"})
    public void listenTopic(ConsumerRecord<?, ?> message, Acknowledgment ack) {
        log.info("Message {} in: \n Topic: {} \n Partition: {} \n Offset {}",
                count++,
                message.topic(),
                message.partition(),
                message.offset());
    }

    public String getTopicToSubscribe() {
        return topicToSubscribe;
    }

}
