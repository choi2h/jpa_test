package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Lesson {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LESSON_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TRAINER_ID")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private LocalDateTime dateTime;

    private String describe;

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;

        trainer.addLesson(this);
    }

    public void setMember(Member member) {
        this.member = member;

        member.addLesson(this);
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

}
