package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@DiscriminatorValue("M")
public class Member extends User{

    @ManyToOne
    private Trainer trainer;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private boolean isPersonalTraining;

    @Embedded
    private Membership membership;
}