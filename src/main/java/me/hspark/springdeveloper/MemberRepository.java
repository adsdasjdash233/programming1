package me.hspark.springdeveloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    // findAll():
    // findBy():
    // deleteAll():
    // deleteByIn :
    // save:
    //public List<Member> findByName(String name);
    public Optional<Member> findByName(String name);



}