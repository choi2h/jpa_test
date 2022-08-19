package ffs.repository.impl;

import ffs.domain.Lesson;
import ffs.domain.Member;
import ffs.domain.Trainer;
import ffs.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LessonRepositoryImpl implements LessonRepository {

    private final EntityManager em;

    @Override
    public List<Lesson> findAll() {
        return em.createQuery("select l from Lesson l", Lesson.class).getResultList();
    }

    public Long save(Lesson lesson) {
        em.persist(lesson);

        return lesson.getId();
    }

    public Lesson findOne(Long id) {
        return em.find(Lesson.class, id);
    }

    public List<Lesson> findByTrainer(Trainer trainer) {
        return em.createQuery("select l from Lesson l where l.trainer = :trainer", Lesson.class)
                .setParameter("trainer", trainer)
                .getResultList();
    }

    public List<Lesson> findByMember(Member member) {
        return em.createQuery("select l from Lesson l where l.member = :member", Lesson.class)
                .setParameter("member", member)
                .getResultList();
    }

    public List<Lesson> fineByTrainerAndMember(Trainer trainer, Member member) {
        return em.createQuery("select l from Lesson l where l.trainer = :trainer and l.member = :member", Lesson.class)
                .setParameter("trainer", trainer)
                .setParameter("member", member)
                .getResultList();
    }

}
