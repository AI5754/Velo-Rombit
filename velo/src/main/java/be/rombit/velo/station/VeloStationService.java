package be.rombit.velo.station;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class VeloStationService {

    private final URL veloStationUrl;

    @Autowired
    public VeloStationService(@Value("${velo.stations.link}")
                                      String veloStationsLink) {

        try {
            veloStationUrl = new URL(veloStationsLink);

        } catch (MalformedURLException e) {
            throw new VeloException(e);
        }
    }

    public String getAll() {

        try {
            JSONObject json = new JSONObject(IOUtils.toString(veloStationUrl, StandardCharsets.UTF_8));
            return json.getJSONObject("network").getJSONArray("stations").toString();

        } catch (IOException e) {
            throw new VeloException(e);
        }
    }
}
