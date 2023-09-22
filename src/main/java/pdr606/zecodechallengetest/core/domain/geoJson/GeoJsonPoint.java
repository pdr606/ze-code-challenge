package pdr606.zecodechallengetest.core.domain.geoJson;
import lombok.Data;
@Data
public class GeoJsonPoint {
    private String type;
    private double[] coordinates;
}
