package ffs.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@MappedSuperclass
public abstract class User {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String phoneNumber;

}
