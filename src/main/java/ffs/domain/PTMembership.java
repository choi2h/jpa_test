package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.List;

@Embeddable
@Getter @Setter
public class PTMembership {

    private int totalLessonCount;
    private int useLessonCount;

    @OneToMany
    private List<Lesson> lesson;

}
