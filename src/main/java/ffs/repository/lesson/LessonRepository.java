package ffs.repository.lesson;

import ffs.domain.Lesson;
import ffs.domain.Member;
import ffs.domain.Trainer;

import java.util.List;

public interface LessonRepository {

    List<Lesson> findAll();

    Long save(Lesson lesson);

    Lesson findOne(Long id);

    List<Lesson> findByTrainer(String trainerName);
    List<Lesson> findByMember(String memberName);

    List<Lesson> findByNameOfTrainerAndMember(String trainerName, String memberName);
}
