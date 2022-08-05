package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("T")
public class Trainer extends User{


    @OneToMany
    private List<Member> memberList;

    @OneToMany
    private List<Lesson> lessonList;
}
