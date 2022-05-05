package be.rombit.station.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "USER",
        uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME")
)
@Setter
public class User {

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="USER_SEQ")
    @Column(name = "USER_ID")
    @Getter
    private int userId;
    @Column(name = "USERNAME")
    @Getter
    private String username;
    @Column(name = "PASSWORD")
    private String password;

}
