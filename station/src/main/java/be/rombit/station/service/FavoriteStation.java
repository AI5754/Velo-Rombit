package be.rombit.station.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "FAVORITE_STATION",
        uniqueConstraints = @UniqueConstraint(columnNames = {"USERNAME", "STATION_ID"})
)
@Getter
@Setter
public class FavoriteStation {

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="FAV_STA_SEQ")
    @Column(name = "FAVORITE_STATION_ID")
    private int favoriteStationId;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "STATION_ID")
    private String stationId;

}
