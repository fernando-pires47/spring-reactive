package com.spring.reactiveserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;

@RestController
public class EventController {

    @Autowired
    private ReactiveServerConfiguration reactiveServerConfiguration;

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Event> get() {
        return this.eventRepository.findAll().delayElements(Duration.ofSeconds(5));
    }

    @PostMapping("/")
    public Mono<Event> save(@RequestBody Event hero) {
        return this.eventRepository.save(hero);
    }

    @GetMapping("/events")
    public String getEventsByRequest() {
        Flux<Map> response = WebClient
                .builder()
                .baseUrl(this.reactiveServerConfiguration.getUrl())
                .build()
                .get()
                .retrieve()
                .bodyToFlux(Map.class);

        response.subscribe(data -> {
            System.out.println(data);
        });

        return "started flux operation";
    }
}
