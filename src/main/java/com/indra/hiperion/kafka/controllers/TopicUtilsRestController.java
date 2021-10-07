package com.indra.hiperion.kafka.controllers;

import com.indra.hiperion.kafka.services.TopicsUtilsService;
import com.indra.hiperion.kafka.services.dto.MessageDto;
import com.indra.hiperion.kafka.services.dto.TopicInfoDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class TopicUtilsRestController implements TopicUtilsApi {

    private final TopicsUtilsService topicsUtilsService;

    public TopicUtilsRestController(TopicsUtilsService topicsUtilsService) {
        this.topicsUtilsService = topicsUtilsService;
    }

    public Set<TopicInfoDto> getTopics() {
        return topicsUtilsService.getTopics();
    }

    public void addMessageInTopic(@RequestBody MessageDto messageDto) {
        topicsUtilsService.addMessageInTopic(messageDto);
    }

    public void cleanUpTopics() {
        topicsUtilsService.cleanUpTopics();
    }

}
