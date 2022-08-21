package ffs.repository;

import ffs.domain.Lesson;
import ffs.domain.Member;
import ffs.domain.Trainer;
import ffs.repository.impl.LessonRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class LessonRepositoryTest {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void insertLessonTest() {
        Lesson lesson = getLesson("trainer", "member");
        Long id = lessonRepository.save(lesson);

        Assertions.assertEquals(lesson, lessonRepository.findOne(id));
    }

    @Test
    public void getLessonByMemberAndTrainerTest() {
        Lesson lesson = getLesson("trainer", "member");
        lessonRepository.save(lesson);

//        Assertions.assertEquals(lesson, lessonRepository.fineByTrainerAndMember(lesson.getTrainer(), lesson.getMember()).get(0));
    }

    @Test
    void getLessonsByTrainerTest() {
        Lesson lesson = getLesson("trainer", "member");
        lessonRepository.save(lesson);
        List<Lesson> lessons = lessonRepository.findByTrainer("trainer");

        Assertions.assertEquals(1, lessons.size());
    }

    @Test
    void getLessonsByMemberTest() {
        Lesson lesson = getLesson("trainer", "member");
        lessonRepository.save(lesson);
        List<Lesson> lessons = lessonRepository.findByMember("member");

        Assertions.assertEquals(1, lessons.size());
    }

    @Test
    void getLessonsByNameOfTrainerAndMemberTest(){
        Lesson lesson = getLesson("trainer", "member");
        lessonRepository.save(lesson);
        List<Lesson> lessons = lessonRepository.findByNameOfTrainerAndMember("trainer", "member");

        Assertions.assertEquals(1, lessons.size());
    }
    private Lesson getLesson(String trainerName, String memberName) {
        Lesson lesson = new Lesson();
        lesson.setDescribe("slr");
        lesson.setTrainer(getTrainer(trainerName));
        lesson.setMember(getMember(memberName));
        lesson.setDateTime(LocalDateTime.now());

        return lesson;
    }


    private Member getMember(String name) {
        Member member = new Member();
        member.setName(name);
        member.setPhoneNumber("1234-1234");
        member.setPersonalTraining(true);
        member.setStartDate(LocalDate.now());
        member.setEndDate(LocalDate.now());

        em.persist(member);

        return member;
    }

    private Trainer getTrainer(String name) {
        Trainer trainer = new Trainer();
        trainer.setName(name);
        trainer.setPhoneNumber("1234-1234");
        trainer.setStartDate(LocalDate.now());
        trainer.setWorkingHour(8);

        em.persist(trainer);

        return trainer;
    }
}