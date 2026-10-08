package me.hspark.springdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    //요청 URL과 요청 방식(GET ,POST ,PUT, DELETE)에 따라 그 요청을 실행할 메서드를 매핑
    @GetMapping("/quiz")
    public ResponseEntity<String> quiz(@RequestParam("code") int code) {
        switch (code) {
            case 1:
                return ResponseEntity.status(201).body("Created!"); //201
            case 2:
                return ResponseEntity.badRequest().body("Bed Request!"); //400
            default:
                return ResponseEntity.ok().body("OK"); //200
        }
    }

    @PostMapping("/quiz")
    public ResponseEntity<String> quiz2(@RequestBody Code code) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~" + code);
        switch (code.value()) {
            case 1:
                return ResponseEntity.status(403).body("Created!");
            default:
                return ResponseEntity.ok().body("OK");
        }
    }

    // [수정] Code record를 QuizController 클래스 내부로 이동하여 가시성 문제 해결
    public record Code(int value) {}
}