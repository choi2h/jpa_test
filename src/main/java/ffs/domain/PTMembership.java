package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class PTMembership {

    private int totalLessonCount;
    private int useLessonCount;

    public void addTotalLessonCount(int count) {
        this.totalLessonCount += count;
    }

    public void increaseUseLessonCount() {
        if (useLessonCount < totalLessonCount) {
            useLessonCount++;
        } else {
            throw new IllegalStateException("Already used all lesson count.");
        }
    }

}
