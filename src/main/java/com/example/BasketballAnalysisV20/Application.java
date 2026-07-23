package com.example.BasketballAnalysisV20;

import org.apache.logging.log4j.message.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api")
class Application{
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @PostMapping("/data")
  public String recivceData(@RequestBody MessagePayload payload){
        System.out.println("\n📬 [RECEIVED FROM PYTHON]: " + payload.getMessage() + "\n");
        return "Java successfully received your message!";
  }
}


class MessagePayload{
  private String message;
  public String getMessage(){return message;}
  public void setMessage(String message){this.message = message;}
}
