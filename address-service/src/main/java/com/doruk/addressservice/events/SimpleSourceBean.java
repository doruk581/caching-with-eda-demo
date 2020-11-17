package com.doruk.addressservice.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SimpleSourceBean {
    private Source source;

    @Autowired
    public SimpleSourceBean(Source source) {
        this.source = source;
    }

    public void publishAddressChange(String action, String id){
        log.info("Sending kafka message");

        final ChangedModel changedModel = ChangedModel.builder().action(action).id(id).build();

        source.output().send(MessageBuilder.withPayload(changedModel).build());
    }
}
