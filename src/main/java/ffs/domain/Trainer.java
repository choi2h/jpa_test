package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter @Setter
@DiscriminatorValue("T")
public class Trainer extends User{


    @OneToMany(mappedBy = "trainer")
    private List<Member> memberList;

    @OneToMany(mappedBy = "trainer")
    private List<Lesson> lessonList;
}
