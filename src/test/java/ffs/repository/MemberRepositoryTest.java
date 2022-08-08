package ffs.repository;

import ffs.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager entityManager;

    @Test
    public void insertNewMemberTest() {
        Member member = new Member();
        member.setName("hwa");
        member.setPhoneNumber("1234");
        member.setPersonalTraining(false);
        member.setStartDate(LocalDateTime.now());
        member.setEndDate(LocalDateTime.now());

    }

}