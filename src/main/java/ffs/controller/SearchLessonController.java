package ffs.controller;

import ffs.dto.response.lesson.LessonInfo;
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
        List<LessonInfo> lessons = searchLessonService.getAllLesson();

        return getResponse(lessons);
    }

    @GetMapping("/lessons/trainer/{name}")
    public ResponseEntity<Object> getLessonsByTrainerName(@PathVariable String name) {
        List<LessonInfo> lessons = searchLessonService.getAllLessonByTrainer(name);

        return getResponse(lessons);
    }

    @GetMapping("/lessons/member/{name}")
    public ResponseEntity<Object> getLessonsByMemberName(@PathVariable String name) {
        List<LessonInfo> lessons = searchLessonService.getAllLessonByMember(name);

        return getResponse(lessons);
    }

    @GetMapping("/lessons/both")
    public ResponseEntity<Object> getLessonsByNameOfTrainerAndMember(@RequestParam String trainerName, @RequestParam String memberName) {
        List<LessonInfo> lessons = searchLessonService.getLessonsByNameOfTrainerAndMember(trainerName, memberName);

        return getResponse(lessons);
    }

    private ResponseEntity<Object> getResponse(List<LessonInfo> lessons){
        if(lessons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }
}
