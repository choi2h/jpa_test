package domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Membership {

    private int totalLessonCount;
    private int useLessonCount;

}
