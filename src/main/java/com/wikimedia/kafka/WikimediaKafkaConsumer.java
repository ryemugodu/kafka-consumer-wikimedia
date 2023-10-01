package com.wikimedia.kafka;

import com.wikimedia.kafka.data.Wikimedia;
import com.wikimedia.kafka.data.WikimediaRepositroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikimediaKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(WikimediaKafkaConsumer.class);
    private WikimediaRepositroy repositroy;

    public WikimediaKafkaConsumer(WikimediaRepositroy repositroy) {
        this.repositroy = repositroy;
    }

    @KafkaListener(
            topics = "wikimedia_data_topic",
            groupId = "wikiGroup"
    )
    public void read(String message){
        logger.info(String.format("Event message = %s", message));
        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setWikiEventData(message.substring(0,100));
        repositroy.save(wikimedia);
    }

}