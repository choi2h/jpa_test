package ffs.repository.lesson.impl;

import ffs.domain.Lesson;
import ffs.repository.lesson.LessonRepository;
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
        return em.createQuery("select l from Lesson l join l.trainer t " +
                "where t.name = :trainerName", Lesson.class)
                .setParameter("trainerName", trainerName)
                .getResultList();
    }

    public List<Lesson> findByMember(String memberName) {
        return em.createQuery("select l from Lesson l join l.member m " +
                        " where m.name = :memberName", Lesson.class)
                .setParameter("memberName", memberName)
                .getResultList();
    }

    @Override
    public List<Lesson> findByNameOfTrainerAndMember(String trainerName, String memberName) {
        return em.createQuery("select l from Lesson l " +
                "join fetch l.trainer t " +
                "join fetch l.member m " +
                "where t.name = :trainerName " +
                "and m.name = :memberName")
                .setParameter("trainerName", trainerName)
                .setParameter("memberName", memberName)
                .getResultList();
    }
}
