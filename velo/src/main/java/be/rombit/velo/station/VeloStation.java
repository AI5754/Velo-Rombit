package be.rombit.velo.station;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeloStation {
    private String id;
    private int emptySlots;
    private int freeBikes;
    private double lat;
    private double lng;
    private String name;
    private VeloStationExtraData extra;
    private String timestamp;
}
