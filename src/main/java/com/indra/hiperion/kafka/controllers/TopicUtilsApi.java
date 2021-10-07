package com.indra.hiperion.kafka.controllers;


import com.indra.hiperion.kafka.services.dto.MessageDto;
import com.indra.hiperion.kafka.services.dto.TopicInfoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Tag(name = "Servicio de utilidades de topicos")
@RequestMapping("/api")
public interface TopicUtilsApi {

    @Operation(summary = "Devuelve una lista con todos los topicos del kafka conectado")
    @GetMapping("/topics")
    Set<TopicInfoDto> getTopics();

    @Operation(summary = "Produce un mensaje en un topico")
    @PostMapping("/topics")
    void addMessageInTopic(@RequestBody MessageDto messageDto);

    @Operation(summary = "Produce un mensaje en todos los topicos de patron BCN_*_JSON")
    @PatchMapping("/topics")
    void cleanUpTopics();

}
