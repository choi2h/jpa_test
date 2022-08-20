package ffs.service;

import ffs.domain.Lesson;
import ffs.domain.Member;
import ffs.domain.Trainer;
import ffs.repository.LessonRepository;
import ffs.repository.MemberRepository;
import ffs.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchLessonService {

    private final LessonRepository lessonRepository;

    public List<Lesson> getAllLesson() {
        List<Lesson> lessons = lessonRepository.findAll();
        log.info("Get all lesson list. size={}", lessons.size());

        return lessons;
    }

    public List<Lesson> getAllLessonByTrainer(String trainerName) {
        List<Lesson> lessons = lessonRepository.findByTrainer(trainerName);
        log.info("Get lessons by trainer name. name={}, size={}", trainerName, lessons.size());

        return lessons;
    }

    public List<Lesson> getAllLessonByMember(String memberName) {
        List<Lesson> lessons = lessonRepository.findByMember(memberName);
        log.info("Get lessons by member name. name={}, size={}", memberName, lessons.size());

        return lessons;
    }
}
