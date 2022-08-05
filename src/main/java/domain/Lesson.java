package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Lesson {

    @Id
    private long id;

    private LocalDateTime date;

}
