package ffs.service.lesson;

import ffs.domain.Lesson;
import ffs.dto.response.lesson.LessonInfo;
import ffs.repository.lesson.LessonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchLessonService {

    private final LessonRepository lessonRepository;

    public List<LessonInfo> getAllLesson() {
        List<Lesson> lessons = lessonRepository.findAll();
        log.info("Get all lesson list. size={}", lessons.size());

        return changeLessonToLessonInfo(lessons);
    }

    public List<LessonInfo> getAllLessonByTrainer(String trainerName) {
        List<Lesson> lessons = lessonRepository.findByTrainer(trainerName);
        log.info("Get lessons by trainer name. name={}, size={}", trainerName, lessons.size());

        return changeLessonToLessonInfo(lessons);
    }

    public List<LessonInfo> getAllLessonByMember(String memberName) {
        List<Lesson> lessons = lessonRepository.findByMember(memberName);
        log.info("Get lessons by member name. name={}, size={}", memberName, lessons.size());

        return changeLessonToLessonInfo(lessons);
    }

    public List<LessonInfo> getLessonsByNameOfTrainerAndMember(String trainerName, String memberName) {
        List<Lesson> lessons = lessonRepository.findByNameOfTrainerAndMember(trainerName, memberName);
        log.info("Get lessons by name of trainer and member. trainer={}, member={}, size={}",
                trainerName, memberName, lessons.size());

        return changeLessonToLessonInfo(lessons);
    }

    private List<LessonInfo> changeLessonToLessonInfo(List<Lesson> lessons){
        List<LessonInfo> lessonInfoList = new ArrayList<>();

        for(Lesson lesson : lessons) {
            LessonInfo lessonInfo = new LessonInfo(lesson.getTrainer().getName(), lesson.getMember().getName(),
                    lesson.getDateTime(), lesson.getDescribe());
            lessonInfoList.add(lessonInfo);
        }

        return lessonInfoList;
    }
}
