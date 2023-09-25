package pdr606.zecodechallengetest.controllers.dto;

import pdr606.zecodechallengetest.core.domain.geoJson.GeoJsonMultiPolygon;
import pdr606.zecodechallengetest.core.domain.geoJson.GeoJsonPoint;

public record PartnerRequestDto(String id, String tradingName, String ownerName,
                                String document,
                                GeoJsonPoint address,
                                GeoJsonMultiPolygon coverageArea) {
}
