package be.rombit.station.favorite;

import be.rombit.station.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(
        name = "FAVORITE_STATION",
        uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "stationId"})
)
@Getter
@Setter
@NoArgsConstructor
public class FavoriteStation {

    @Id
    @GeneratedValue
    @Column
    private int favoriteUserStationId;
    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;
    @Column(nullable = false)
    private String stationId;

    public FavoriteStation(User user, String stationId) {
        this.user = user;
        this.stationId = stationId;
    }
}
