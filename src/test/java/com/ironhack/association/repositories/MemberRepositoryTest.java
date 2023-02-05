package com.ironhack.association.repositories;

import com.ironhack.association.model.Member;
import com.ironhack.association.model.enums.Status;
import com.ironhack.association.repositories.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;
    private Member member;

    @BeforeEach
    void setUp() {
       member = new Member("Buenaventura", Status.ACTIVE, new Date(1936-11-20));
       memberRepository.save(member);
    }

    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
    }

    @Test
    void jpaGoesBrrr(){
        Optional<Member> optionalMember = memberRepository.findById(member.getId());
        assertEquals(member.getName(), optionalMember.get().getName());
    }
    @Test
    void test_ManyToOne() {

    }

}