package be.rombit.station.favorite;

import java.util.Set;

public interface IFavoriteStationService {

    Set<UserStation> getAllStations();

    boolean addFavorite(String stationId);

    boolean removeFavorite(String stationId);

}
