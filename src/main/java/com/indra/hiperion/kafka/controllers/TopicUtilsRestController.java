package com.indra.hiperion.kafka.controllers;

import com.indra.hiperion.kafka.services.TopicsUtilsService;
import com.indra.hiperion.kafka.services.dto.MessageDto;
import com.indra.hiperion.kafka.services.dto.TopicInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class TopicUtilsRestController {

    @Autowired
    private TopicsUtilsService service;

    @GetMapping("/topics")
    public Set<TopicInfoDto> getTopics() {
        return service.getTopics();
    }

    @PostMapping("/topics")
    public void addMessageInTopic(@RequestBody MessageDto messageDto) {
        service.addMessageInTopic(messageDto);
    }

}
