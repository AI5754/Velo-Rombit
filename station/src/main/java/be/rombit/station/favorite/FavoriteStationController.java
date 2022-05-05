package be.rombit.station.favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/stations")
public class FavoriteStationController {

    @Autowired
    private FavoriteStationService service;

    @GetMapping
    public ResponseEntity<Set<UserStation>> getAllStations() {
        return ResponseEntity.ok(service.getAllStations());
    }

    @PostMapping("/favorite/{stationId}")
    public ResponseEntity<Boolean> addFavorite(@PathVariable("stationId") String stationId) {
        boolean isSuccess = service.addFavorite(stationId);
        return isSuccess ? ResponseEntity.ok(isSuccess) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/favorite/{stationId}")
    public ResponseEntity<Boolean> removeFavorite(@PathVariable("stationId") String stationId) {
        boolean isSuccess = service.removeFavorite(stationId);
        return isSuccess ? ResponseEntity.ok(isSuccess) : ResponseEntity.badRequest().build();
    }

}
