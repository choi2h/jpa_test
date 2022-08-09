package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@AttributeOverride(name = "id", column = @Column(name="TRAINER_ID"))
public class Trainer extends User{

    private LocalDate startDate;
    private int workingHour;

    @OneToMany(mappedBy = "trainer")
    private List<Member> memberList;

    @OneToMany(mappedBy = "trainer")
    private List<Lesson> lessonList;

    public Trainer() {
        memberList = new ArrayList<>();
        lessonList = new ArrayList<>();
    }

    public void setStartDate(LocalDate date) {
        this.startDate = date;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    public void addMember(Member member){
        memberList.add(member);
        member.setTrainer(this);
    }

    public void addLesson(Lesson lesson) {
        lessonList.add(lesson);
    }



}
