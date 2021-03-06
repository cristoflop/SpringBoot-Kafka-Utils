package com.indra.hiperion.kafka.services;

import com.indra.hiperion.kafka.services.dto.MessageDto;
import com.indra.hiperion.kafka.services.dto.TopicInfoDto;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TopicsUtilsService {

    @Autowired
    private ConsumerFactory<String, String> consumerFactory;

    @Autowired
    private KafkaTemplate<String, String> kt;

    public Set<TopicInfoDto> getTopics() {
        try {
            Consumer<String, String> consumer = consumerFactory.createConsumer();
            Set<TopicInfoDto> topics = new HashSet<>();

            Map<String, List<PartitionInfo>> map = consumer.listTopics();
            map.forEach((key, value) -> {
                TopicInfoDto topic = new TopicInfoDto(
                        key,
                        value.size(),
                        value.stream().map(PartitionInfo::toString).collect(Collectors.toList())
                );
                topics.add(topic);
            });

            return topics;
        } catch (Exception e) {
            return null;
        }
    }

    public void addMessageInTopic(MessageDto messageDto) {
        kt.send(messageDto.getTopic(), messageDto.getMessage());
    }

    public void cleanUpTopics() {
        String testMessage = "{'message': 'message from code'}";
        this.getTopics().forEach(item -> {
            if (item.getName().contains("BCN_") && item.getName().contains("_JSON"))
                this.addMessageInTopic(new MessageDto(item.getName(), testMessage));
        });
    }

}
