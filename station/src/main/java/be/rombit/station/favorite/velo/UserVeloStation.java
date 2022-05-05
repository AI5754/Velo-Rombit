package be.rombit.station.favorite.velo;

import be.rombit.station.favorite.UserStation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVeloStation extends UserStation {

    private String id;
    private int emptySlots;
    private int freeBikes;
    private double lat;
    private double lng;
    private String name;
    private VeloStationExtraData extra;
    private String timestamp;

}
