package ffs.repository;

import ffs.domain.Lesson;
import ffs.domain.Member;
import ffs.domain.Trainer;

import java.util.List;

public interface LessonRepository {

    Long save(Lesson lesson);

    Lesson findOne(Long id);
    List<Lesson> fineByTrainerAndMember(Trainer trainer, Member member);
}
