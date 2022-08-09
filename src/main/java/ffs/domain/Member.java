package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AttributeOverride(name = "id", column = @Column(name="MEMBER_ID"))
public class Member extends User{

    @ManyToOne
    @JoinColumn(name="TRAINER_ID")
    private Trainer trainer;

    private LocalDate startDate;
    private LocalDate endDate;

    private boolean isPersonalTraining;

    @Embedded
    private PTMembership ptMembership;

    @OneToMany(mappedBy = "member")
    private List<Lesson> lessonList;

    public Member() {
        lessonList = new ArrayList<>();
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setStartDate(LocalDate date) {
        this.startDate = date;
    }

    public void setEndDate(LocalDate date) {
        this.endDate = date;
    }

    public void setPersonalTraining(Boolean isPersonalTraining) {
        this.isPersonalTraining = isPersonalTraining;
    }

    public void addLesson(Lesson lesson) {
        lessonList.add(lesson);
    }

    public void setPtMembership(PTMembership ptMembership) {
        this.ptMembership = ptMembership;
    }
}
