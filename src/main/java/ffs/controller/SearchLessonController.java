package ffs.controller;

import ffs.domain.Lesson;
import ffs.service.SearchLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchLessonController {

    private final SearchLessonService searchLessonService;

    @GetMapping("/lessons")
    public ResponseEntity<Object> getAllLesson() {
        List<Lesson> allLessonList = searchLessonService.getAllLesson();

        if(allLessonList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(allLessonList, HttpStatus.OK);
    }

    @GetMapping("/lessons/trainer/{name}")
    public ResponseEntity<Object> getLessonsByTrainerName(@PathVariable String name) {
        List<Lesson> lessons = searchLessonService.getAllLessonByTrainer(name);

        if(lessons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @GetMapping("/lessons/member/{name}")
    public ResponseEntity<Object> getLessonsByMemberName(@PathVariable String name) {
        List<Lesson> lessons = searchLessonService.getAllLessonByMember(name);

        if(lessons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }
}
