package be.rombit.station.favorite;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.junit.JUnitRule;
import org.mockito.junit.MockitoRule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
class FavoriteStationControllerTest {

    public static final String STATION_ID = "123A";

//    @Rule
//    public MockitoRule mockitoRule = new JUnitRule();

    @Mock
    private FavoriteStationService service;
    @InjectMocks
    private FavoriteStationController controller;


    @Test
    void getAllStations() {
        Set<UserStation> expectedUserStationsMock = mock(Set.class);
        when(service.getAllStations()).thenReturn(expectedUserStationsMock);

        ResponseEntity<Set<UserStation>> actualResponse = controller.getAllStations();

        assertThat(actualResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualResponse.getBody()).isEqualTo(expectedUserStationsMock);
        verify(service).getAllStations();
    }

    @Test
    void addFavorite_success() {
        when(service.addFavorite(STATION_ID)).thenReturn(true);

        ResponseEntity<Boolean> actualResponse = controller.addFavorite(STATION_ID);

        assertThat(actualResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualResponse.getBody()).isTrue();
        verify(service).addFavorite(STATION_ID);
    }

    @Test
    void addFavorite_badRequest() {
        when(service.addFavorite(STATION_ID)).thenReturn(false);

        ResponseEntity<Boolean> actualResponse = controller.addFavorite(STATION_ID);

        assertThat(actualResponse.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(actualResponse.getBody()).isFalse();
        verify(service).addFavorite(STATION_ID);
    }

    @Test
    void removeFavorite_success() {
        when(service.removeFavorite(STATION_ID)).thenReturn(true);

        ResponseEntity<Boolean> actualResponse = controller.removeFavorite(STATION_ID);

        assertThat(actualResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualResponse.getBody()).isTrue();
        verify(service).removeFavorite(STATION_ID);
    }

    @Test
    void removeFavorite_badRequest() {
        when(service.removeFavorite(STATION_ID)).thenReturn(false);

        ResponseEntity<Boolean> actualResponse = controller.removeFavorite(STATION_ID);

        assertThat(actualResponse.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(actualResponse.getBody()).isFalse();
        verify(service).removeFavorite(STATION_ID);
    }
}