package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class Membership {

    private int totalLessonCount;
    private int useLessonCount;

}
