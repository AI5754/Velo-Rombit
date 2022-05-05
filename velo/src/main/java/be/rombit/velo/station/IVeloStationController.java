package be.rombit.velo.station;

import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface IVeloStationController {
    ResponseEntity<?> getVeloStations();
}
