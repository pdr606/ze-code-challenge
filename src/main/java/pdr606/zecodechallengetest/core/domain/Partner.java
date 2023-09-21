package pdr606.zecodechallengetest.core.domain;

import lombok.Data;

@Data
public class Partner {

    private String id;
    private String tradingName;
    private String ownerName;
    private String document;
    private GeoJsonMultiPolygon coverageArea;
    private GeoJsonPoint address;
}
