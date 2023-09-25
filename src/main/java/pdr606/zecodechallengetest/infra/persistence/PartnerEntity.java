package pdr606.zecodechallengetest.infra.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pdr606.zecodechallengetest.core.domain.geoJson.GeoJsonMultiPolygon;
import pdr606.zecodechallengetest.core.domain.geoJson.GeoJsonPoint;
import pdr606.zecodechallengetest.core.domain.partner.Partner;

import java.util.List;
import java.util.stream.Collectors;


@Document("partner")
@Data
@AllArgsConstructor
public class PartnerEntity {

    @Id
    private String id;
    private String tradingName;
    private String ownerName;
    @Indexed(unique = true)
    private String document;
    private GeoJsonPoint address;
    private GeoJsonMultiPolygon coverageArea;

}
