package com.demo.quickfix.initiator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quickfix.*;

@Configuration
public class InitiatorConfiguration {

    @Bean
    public MessageFactory messageFactory() {
        return new DefaultMessageFactory();
    }

    @Bean
    public SessionSettings sessionSettings() throws ConfigError {
        return new SessionSettings("quickfixj-initiator.cfg");
    }

    @Bean
    public LogFactory logFactory() {
        return new ScreenLogFactory();
    }

    @Bean
    public MessageStoreFactory messageStoreFactory() {
        return new MemoryStoreFactory();
    }
}
