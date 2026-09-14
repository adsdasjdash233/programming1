package me.hspark.springdeveloper;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    // hello 요청을 보내면 hello() 메서드 호출
    //http://localhost:8080/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    //http://localhost:8080/test
  //  @GetMapping("/test")
  //  public String test() {
  //      return "Hello everyone!";
  //  }

    @PostMapping("/test")
    public String testPost() {
        return "Hello everyone!2";
    }
    @DeleteMapping("/test")
    public String testDelete() {
        return "Hello everyone!3";
    }
    @PutMapping("/test")
    public String testPut() {
        return "Hello everyone!4";
    }

}
