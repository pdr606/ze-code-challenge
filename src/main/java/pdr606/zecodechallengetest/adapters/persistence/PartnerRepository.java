package pdr606.zecodechallengetest.adapters.persistence;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pdr606.zecodechallengetest.adapters.entities.PartnerData;

import java.util.List;

@Repository
public interface PartnerRepository extends MongoRepository<PartnerData, String> {

    @Query(value = "{ 'coverageArea' : { '$geoIntersects' : { '$geometry' : { 'type' : 'Point', 'coordinates' : [ ?0, ?1 ] } } } }")
    List<PartnerData> findNearestPartners(double lat, double lon, int limit);

}
