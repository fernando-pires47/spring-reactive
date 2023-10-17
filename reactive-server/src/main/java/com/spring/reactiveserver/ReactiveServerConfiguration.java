package com.spring.reactiveserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReactiveServerConfiguration {
    @Value("${custom.event.request.url}")
    private String url;

    public String getUrl() {
        return this.url;
    }
}
