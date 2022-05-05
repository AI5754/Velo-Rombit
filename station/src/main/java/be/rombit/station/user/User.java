package be.rombit.station.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column
    private int userId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

}
