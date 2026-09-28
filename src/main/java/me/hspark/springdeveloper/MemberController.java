package me.hspark.springdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    //요청을 받아서 적절한 비즈니스 로직으로 연결
    // http://localhost:8080/member 요청과 메서드를 연결
    @GetMapping ("/member")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();

    }
    // 회원 정보를 등록
    //https://localhost:8000/member 요청을 post방식을 했을때 회원 등록을 처리
    @PostMapping ("/member")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        //비즈니스 로직을 호출
        //return ResponseEntity.ok().body(memberService.saveMember(member));
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.saveMember(member));
    }
}
