package ffs.dto.response.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class LessonInfo {
    private String trainerName;
    private String memberName;
    private LocalDateTime dateTime;
    private String describe;
}
