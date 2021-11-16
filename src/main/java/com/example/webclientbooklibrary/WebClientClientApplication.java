package com.example.webclientbooklibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebClientClientApplication.class, args);

        WebClient bookClient = WebClient.create("http://localhost/7070/books");
        WebClient booksClient = WebClient.create("http://localhost/7070/books/{id}");
    }
    private static void bookClient(WebClient client, String book){
        Mono<String> response = client.get()
                .uri("/")
                .retrieve()
                .bodyToMono(String.class);
        System.out.println(response.block());
    }

    private static void booksClient(WebClient client, String book) {
        Mono<String> response = client.get()
                .uri("books/{id}")
                .retrieve()
                .bodyToMono(String.class);
        response.subscribe(System.out::println);
    }

}
