package com.indra.hiperion.kafka.services.dto;

import java.util.List;

public class TopicInfoDto {

    private String name;

    private int partitions;

    private List<String> info;

    public TopicInfoDto(String name, int partitions, List<String> info) {
        this.name = name;
        this.partitions = partitions;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartitions() {
        return partitions;
    }

    public void setPartitions(int partitions) {
        this.partitions = partitions;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

}
