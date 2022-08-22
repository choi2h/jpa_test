package ffs.repository;

import ffs.domain.Member;
import ffs.repository.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void insertNewMemberTest() {
        Member member = getMember("hwa", "1234", false);

        Long id = memberRepository.save(member);

        Assertions.assertEquals(member, memberRepository.findOne(id));
    }

    @Test
    public void selectAllMemberTest() {
        Member member1 = getMember("member1", "1234-1234", true);
        Member member2 = getMember("member2", "1234-5678", true);

        memberRepository.save(member1);
        memberRepository.save(member2);

        Assertions.assertEquals(2, memberRepository.findAll().size());
    }

    @Test
    public void selectFromNameTest() {
        Member member1 = getMember("member1", "1234-1234", true);
        memberRepository.save(member1);

        Assertions.assertEquals(member1.getId(), memberRepository.findByName(member1.getName()).get(0).getId());
    }

    private Member getMember(String name, String phoneNumber, boolean isPersonalTraining) {
        Member member = new Member();
        member.setName(name);
        member.setPhoneNumber(phoneNumber);
        member.setPersonalTraining(isPersonalTraining);
        member.setStartDate(LocalDate.now());
        member.setEndDate(LocalDate.now());

        return member;
    }

}