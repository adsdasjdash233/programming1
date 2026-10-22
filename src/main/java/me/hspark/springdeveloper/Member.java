package me.hspark.springdeveloper;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Member {
        @Id
        @GeneratedValue(strategy =  GenerationType.IDENTITY)
        @Column(name = "id",updatable = false) //primary key 이므로 null 여부 의미없음
        private Long id;
        @Column(name = "name", nullable = false) // id칸의 null을 비허용 name은 선택
        @Setter(AccessLevel.PUBLIC)
        private String name;
        public Member(String name){
                this.name=name;
        }

}
