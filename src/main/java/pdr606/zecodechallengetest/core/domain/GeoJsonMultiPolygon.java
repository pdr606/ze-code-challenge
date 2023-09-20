package pdr606.zecodechallengetest.core.domain;

import lombok.Data;

import java.util.List;

@Data
public class GeoJsonMultiPolygon {
    private String type;
    private double[][][][] coordinates;
}
