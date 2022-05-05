package be.rombit.station.favorite;

import be.rombit.station.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteStationRepository extends JpaRepository<FavoriteStation, Integer> {

    boolean existsByUserAndStationId(User user, String stationId);

    void deleteByUserAndStationId(User user, String stationId);

}
