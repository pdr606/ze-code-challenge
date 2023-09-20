package pdr606.zecodechallengetest.adapters.entities;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pdr606.zecodechallengetest.core.domain.GeoJsonMultiPolygon;
import pdr606.zecodechallengetest.core.domain.GeoJsonPoint;

@Document
public class PartnerData {

    @Id
    private Long id;
    private String ownerName;
    private String document;
    private GeoJsonPoint address;
    private GeoJsonMultiPolygon coordinates;

}
