package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@AttributeOverride(name = "id", column = @Column(name="TRAINER_ID"))
public class Trainer extends User{

    private LocalDateTime startDate;
    private int workingHour;

    @OneToMany(mappedBy = "trainer")
    private List<Member> memberList;

    @OneToMany(mappedBy = "trainer")
    private List<Lesson> lessonList;
}
