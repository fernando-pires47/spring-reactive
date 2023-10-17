package com.spring.reactiveserver;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Event {

    @Id
    private String id;

    private String name;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
