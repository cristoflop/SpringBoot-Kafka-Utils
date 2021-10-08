package com.indra.hiperion.kafka.Utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@Component
public class TopicMonitoringFileReader {

    private final Logger log = LoggerFactory.getLogger(TopicMonitoringFileReader.class);

    @Value("${LOG_FILENAME}")
    private String logFilename;

    /*
    public String getFileContent() {
        String content = null;
        try {
            Scanner scanner = new Scanner(new File(logFilename));
            content = scanner.useDelimiter("\\Z").next();
            scanner.close();
        } catch (FileNotFoundException e) {
            log.info("Cannot read file");
        }
        return content;
    }
     */

    public String getFileContent() {
        StringBuilder content = new StringBuilder();
        try {
            LineIterator it = FileUtils.lineIterator(new File(logFilename), "UTF-8");
            while (it.hasNext()) {
                String line = it.nextLine();
                content.append(line).append("\n");
            }
            it.close();
        } catch (IOException exc) {
            log.info("Cannot read file");
        }
        return content.toString();
    }

}
