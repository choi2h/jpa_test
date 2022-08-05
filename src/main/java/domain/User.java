package domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "UTYPE")
public abstract class User {

    @Id @GeneratedValue
    @Column(name = "User_id")
    private long id;

    private String name;
    private String phoneNumber;

}
