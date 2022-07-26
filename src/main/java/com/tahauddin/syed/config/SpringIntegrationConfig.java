package com.tahauddin.syed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class SpringIntegrationConfig {

    @Bean
    @InboundChannelAdapter(value = "fileInputChannel", poller = @Poller(fixedDelay = "1000"))
    public FileReadingMessageSource fileReadingMessageSource(){

        CompositeFileListFilter<File> filter = new CompositeFileListFilter<>();
        filter.addFilter(new SimplePatternFileListFilter("*.jpg"));

        FileReadingMessageSource messageSource = new FileReadingMessageSource();
        messageSource.setDirectory(new File("C:\\Users\\tahau\\Downloads\\Images"));
        messageSource.setFilter(filter);

        return messageSource;
    }

    @Bean
    @ServiceActivator(inputChannel = "fileInputChannel")
    public FileWritingMessageHandler fileWritingMessageHandler(){

        FileWritingMessageHandler messageHandler = new FileWritingMessageHandler(new File("C:\\Users\\tahau\\Desktop\\Images"));
        messageHandler.setAutoCreateDirectory(true);
        messageHandler.setExpectReply(false);

        return messageHandler;
    }



}
