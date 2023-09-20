package pdr606.zecodechallengetest.core.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Data
public class Partner {

    private Long id;
    private String ownerName;
    private String document;
    private GeoJsonPoint address;
    private GeoJsonMultiPolygon coordinates;
}
