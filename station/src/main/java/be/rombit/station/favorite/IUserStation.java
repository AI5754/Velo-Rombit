package be.rombit.station.favorite;

public interface IUserStation {

    String getId();
    String getName();
    double getLat();
    double getLng();
    boolean isFavorite();

}
