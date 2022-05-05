package be.rombit.station.favorite;

import be.rombit.station.favorite.velo.UserVeloStation;
import be.rombit.station.user.User;
import be.rombit.station.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Set;

@Service
public class FavoriteStationService implements IFavoriteStationService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final URI veloStationUri;

    @Autowired
    public FavoriteStationService(@Value("${velo.stations.link}")
                                          String veloStationsLink) {
        veloStationUri = URI.create(veloStationsLink);
    }

    @Autowired
    private FavoriteStationRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Set<UserStation> getAllStations() {
        UserVeloStation[] userVeloStations = restTemplate.getForObject(veloStationUri, UserVeloStation[].class);

        return Set.of(userVeloStations);
    }

    @Override
    public boolean addFavorite(String stationId) {

        if (repository.existsByUserAndStationId(loggedInUser(), stationId)) {
            return false;
        }
        repository.save(new FavoriteStation(loggedInUser(), stationId));
        return true;
    }

    @Override
    public boolean removeFavorite(String stationId) {
        if (repository.existsByUserAndStationId(loggedInUser(), stationId)) {
            repository.deleteByUserAndStationId(loggedInUser(), stationId);
            return true;
        }
        return false;
    }

    private User loggedInUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userRepository.findByUsername(userDetails.getUsername()).get();
    }
}
