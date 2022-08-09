package ffs.repository;

import ffs.domain.Lesson;
import ffs.domain.Member;
import ffs.domain.Trainer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LessonRepository {

    private final EntityManager em;

    public Long save(Lesson lesson) {
        em.persist(lesson);

        return lesson.getId();
    }

    public Lesson findOne(Long id) {
        return em.find(Lesson.class, id);
    }

    public List<Lesson> fineByTrainerAndMember(Trainer trainer, Member member) {
        return em.createQuery("select l from Lesson l where l.trainer = :trainer and l.member = :member", Lesson.class)
                .setParameter("trainer", trainer)
                .setParameter("member", member)
                .getResultList();
    }

}
