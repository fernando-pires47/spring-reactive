# Spring Reactive
Project example using Flux and Mono to implements reactive programming.

### Dependencies
* Docker
* Docker Compose
* Java 17

### Services to run
* Reactive Service
* Mongo Reactive Database

### To Run with Docker

Execute in root directory:

```bash
sudo docker-compose up -d 
```

### To realize request

Execute in your browser or curl:

```bash
http://localhost:8080/events
```

### To see operation in docker logs 

```bash
sudo docker-compose logs spring-reactive -f
```

### To see difference between Flux and Mono access
https://www.baeldung.com/java-reactor-flux-vs-mono

## License

This application is available under the
[MIT license](https://opensource.org/licenses/MIT).
