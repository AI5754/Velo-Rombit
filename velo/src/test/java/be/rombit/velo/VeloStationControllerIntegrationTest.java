package be.rombit.velo;

import be.rombit.velo.station.IVeloStationController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:test.properties")
class VeloStationControllerIntegrationTest {

//    private final Path expectedPath;

    @javax.annotation.Resource
    private IVeloStationController controller;

//    public VeloStationControllerIntegrationTest(@Value("${velo.stations.expected.json.path}") String expectedJsonPath) {
//        try {
//            expectedPath =
//                    Paths.get(getClass().getClassLoader().getResource(expectedJsonPath).toURI());
//        } catch (URISyntaxException e) {
//            throw new VeloException(e);
//        }
//    }

    @Test
    public void getVeloStations() {
        String expectedToContain = "\"extra\":{\"uid\":74,\"address\":\"Scheldestraat - Kronenburgstraat\",\"status\":\"OPN\"},\"latitude\":51.21233419740909,\"name\":\"074- Vismijn\",\"id\":\"ea663ed17d82410502a1ece1542a073f\",";
//        String expected = Files.readString(expectedPath);

        ResponseEntity<?> actual = controller.getVeloStations();

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actual.hasBody()).isTrue();
        assertThat(actual.getBody().toString()).contains(expectedToContain);
    }
}



