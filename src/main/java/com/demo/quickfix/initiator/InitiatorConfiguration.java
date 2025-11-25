package com.demo.quickfix.initiator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quickfix.*;

@Slf4j
@Configuration
public class InitiatorConfiguration {

    @Bean
    public MessageFactory messageFactory() {
        // OBJECTIVE: Creates FIX messages according to FIX specification
        return new DefaultMessageFactory();
    }

    @Bean
    public SessionSettings sessionSettings() throws ConfigError {
        // OBJECTIVE: Loads session settings to application
        return new SessionSettings("quickfixj-initiator.cfg");
    }

    @Bean
    public LogFactory logFactory() {
        // OBJECTIVE: Prints log on screen
        return new ScreenLogFactory();
    }

    @Bean
    public MessageStoreFactory messageStoreFactory() {
        // OBJECTIVE: Temporary stores messages on a HashMap
        return new MemoryStoreFactory();
    }

    @Bean
    public Initiator initiator(Application application, MessageStoreFactory messageStoreFactory, SessionSettings sessionSettings,
                               LogFactory logFactory, MessageFactory messageFactory) throws ConfigError {

        log.info("Starting up SocketInitiator");
        SocketInitiator socketInitiator = new SocketInitiator(application, messageStoreFactory, sessionSettings, logFactory, messageFactory);
        socketInitiator.start();

        return socketInitiator;
    }
}
