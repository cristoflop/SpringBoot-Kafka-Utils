package com.indra.hiperion.kafka.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TopicMonitoringFileWriter {

    private final Logger log = LoggerFactory.getLogger(TopicMonitoringFileWriter.class);

    @Value("${LOG_FILENAME}")
    private String logFilename;

    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    private BufferedWriter logFile;

    @PostConstruct
    public void setUp() {
        try {
            logFile = new BufferedWriter(new FileWriter(new File(logFilename)));
        } catch (IOException e) {
            log.info("Cannot generate log file");
        }
    }

    public void writeInLog(String msg) {
        try {
            String now = formatter.format(new Date());
            logFile.write(now + ": " + msg);
            logFile.newLine();
        } catch (IOException e) {
            log.info("Cannot write in log file");
        }
    }

}
