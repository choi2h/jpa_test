package ffs;

import ffs.domain.Lesson;
import ffs.domain.Member;
import ffs.domain.PTMembership;
import ffs.domain.Trainer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.insertDB();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void insertDB() {
            Member member1 = getMember("member1");
            member1.setPtMembership(getMembership(5));
            em.persist(member1);

            Member member2 = getMember("member2");
            member2.setPtMembership(getMembership(9));
            em.persist(member2);

            Trainer trainer = getTrainer("hwa");
            trainer.addMember(member1);
            trainer.addMember(member2);
            em.persist(trainer);

            Lesson lesson = getLesson(member1, trainer);
            em.persist(lesson);
        }

        private Member getMember(String name) {
            Member member = new Member();
            member.setName(name);
            member.setPhoneNumber("1234-1234");
            member.setStartDate(LocalDate.now());
            member.setEndDate(LocalDate.of(2023, 12, 23));
            member.setPersonalTraining(true);

            return member;
        }

        private Trainer getTrainer(String name) {
            Trainer trainer = new Trainer();
            trainer.setName(name);
            trainer.setPhoneNumber("6789-6789");
            trainer.setStartDate(LocalDate.now());
            trainer.setWorkingHour(8);

            return trainer;
        }

        private PTMembership getMembership(int useCount) {
            PTMembership membership = new PTMembership();
            membership.addTotalLessonCount(20);

            for (int i = 0; i < useCount; i++) {
                membership.increaseUseLessonCount();
            }

            return membership;
        }

        private Lesson getLesson(Member member, Trainer trainer) {
            Lesson lesson = new Lesson();
            lesson.setMember(member);
            lesson.setTrainer(trainer);
            lesson.setDateTime(LocalDateTime.of(2022, 8, 9, 7, 0));
            lesson.setDescribe("side lateral raise");

            return lesson;
        }
    }
}
