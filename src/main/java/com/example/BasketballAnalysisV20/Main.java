package com.example.BasketballAnalysisV20;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class Main{
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Bean
  public CommandLineRunner run() {
    return args -> {
      RestClient restClient = RestClient.create();
      String pythonUrl = "http://localhost:8000/receive";

      Map<String, Object> payload = new HashMap<>();
      payload.put("title", "Java");
      payload.put("Test", "123");
      payload.put("Work please", 123);

      try{
        String response = restClient.post().uri(pythonUrl).contentType(MediaType.APPLICATION_JSON).body(payload).retrieve().body(String.class);
        System.out.println("Response: " + response);
      }
      catch(Exception e){
        System.err.println("Error: " + e.getMessage());
      }
    };
  }
}
