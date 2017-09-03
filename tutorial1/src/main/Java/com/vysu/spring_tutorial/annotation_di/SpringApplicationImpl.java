package com.vysu.spring_tutorial.annotation_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SpringApplicationImpl implements SpringApplication {
    private MessageContainerService mcs;

    @Autowired
    @Qualifier("messageContainerService")
    public void setMessages(MessageContainerService mcs) {
        this.mcs=mcs;
    }

    public void outStringScope(int count){
        mcs.showMessages(count);
    }
}
