package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "UTYPE")
public abstract class User {

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    private String name;
    private String phoneNumber;

}
