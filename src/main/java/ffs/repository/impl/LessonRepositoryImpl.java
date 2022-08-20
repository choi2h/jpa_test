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

    public List<Lesson> findByTrainer(String trainerName) {
        return em.createQuery("select l from Lesson l join Trainer t " +
                "on l.trainer.name = t.name where t.name = :trainerName", Lesson.class)
                .setParameter("trainerName", trainerName)
                .getResultList();
    }

    public List<Lesson> findByMember(String memberName) {
        return em.createQuery("select l from Lesson l join Member m " +
                        "on l.member.name = m.name where m.name = :memberName", Lesson.class)
                .setParameter("memberName", memberName)
                .getResultList();
    }

    public List<Lesson> fineByTrainerAndMember(Trainer trainer, Member member) {
        return em.createQuery("select l from Lesson l where l.trainer = :trainer and l.member = :member", Lesson.class)
                .setParameter("trainer", trainer)
                .setParameter("member", member)
                .getResultList();
    }

}
