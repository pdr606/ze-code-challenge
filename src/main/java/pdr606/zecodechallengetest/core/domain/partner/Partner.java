package pdr606.zecodechallengetest.core.domain.partner;

import lombok.AllArgsConstructor;
import lombok.Data;
import pdr606.zecodechallengetest.core.domain.geoJson.GeoJsonMultiPolygon;
import pdr606.zecodechallengetest.core.domain.geoJson.GeoJsonPoint;

@Data
@AllArgsConstructor
public class Partner {

    private String id;
    private String tradingName;
    private String ownerName;
    private String document;
    private GeoJsonPoint address;
    private GeoJsonMultiPolygon coverageArea;
}
