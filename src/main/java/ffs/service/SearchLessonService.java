package ffs.service;

import ffs.domain.Lesson;
import ffs.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchLessonService {

    private final LessonRepository lessonRepository;

    public List<Lesson> getAllLesson() {
        return lessonRepository.findAll();
    }
}
