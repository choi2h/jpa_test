package domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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
