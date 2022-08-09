package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@AttributeOverride(name = "id", column = @Column(name="MEMBER_ID"))
public class Member extends User{

    @ManyToOne
    @JoinColumn(name="TRAINER_ID")
    private Trainer trainer;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private boolean isPersonalTraining;

    @Embedded
    private PTMembership ptMembership;

    @OneToMany(mappedBy = "member")
    private List<Lesson> lesson;
}
