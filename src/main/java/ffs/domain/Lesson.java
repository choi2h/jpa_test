package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Lesson {

    @Id @GeneratedValue
    @Column(name="LESSON_ID")
    private Long lessonId;

    private Long trainerId;

    private Long memberId;

    private LocalDateTime date;

    private String describe;

}
