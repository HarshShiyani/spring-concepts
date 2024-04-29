package com.harsh.springconcepts.evets.concept1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BlockedListNotifier implements ApplicationListener<BlockedListEvent> {

    @Override
    public void onApplicationEvent(BlockedListEvent event) {
        log.info("Notified that {} has been blocked", event.getAddress());
    }
}
