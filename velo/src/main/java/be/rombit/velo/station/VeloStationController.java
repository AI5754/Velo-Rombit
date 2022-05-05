package be.rombit.velo.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stations")
public class VeloStationController implements IVeloStationController {

    @Autowired
    private VeloStationService veloStationService;

    @Override
    @GetMapping
    public ResponseEntity<?> getVeloStations() {
        return ResponseEntity.ok(veloStationService.getAll());
    }
}
