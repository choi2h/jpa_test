package ffs.dto.response.member;

import ffs.domain.Lesson;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class SearchMemberResponse {

    private String name;
    private String phoneNumber;

    private LocalDate startDate;
    private LocalDate endDate;

    private boolean isPersonalTraining;

    private int totalLessonCount;
    private int useLessonCount;

    private String trainerName;

    private List<Lesson> lessonList;
}
