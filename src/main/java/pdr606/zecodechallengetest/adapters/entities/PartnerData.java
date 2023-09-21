package pdr606.zecodechallengetest.adapters.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import pdr606.zecodechallengetest.core.domain.GeoJsonMultiPolygon;
import pdr606.zecodechallengetest.core.domain.GeoJsonPoint;
import pdr606.zecodechallengetest.core.domain.Partner;

import java.util.ArrayList;
import java.util.List;


@Document("partner")
@Data
@AllArgsConstructor
public class PartnerData {

    @Id
    private String id;
    private String tradingName;
    private String ownerName;
    private String document;
    private GeoJsonPoint address;
    private GeoJsonMultiPolygon coverageArea;

    public static PartnerData convert (Partner partner){
        return new PartnerData(partner.getId(), partner.getTradingName(), partner.getOwnerName(), partner.getDocument(), partner.getAddress(), partner.getCoverageArea());

    }
    public static List<PartnerData> toDomainObj(List<Partner> partners){
        List<PartnerData> partnerDataList = new ArrayList<>();
        for(Partner partner : partners){
            partnerDataList.add(convert(partner));
        }
        return partnerDataList;
    }

}
