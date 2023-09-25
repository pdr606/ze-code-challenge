package pdr606.zecodechallengetest.infra.persistence;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends MongoRepository<PartnerEntity, String> {

    @Query(value = "{ 'coverageArea' : { '$geoIntersects' : { '$geometry' : { 'type' : 'Point', 'coordinates' : [ ?0, ?1 ] } } } }")
    List<PartnerEntity> findNearestPartners(double lat, double lon);

}
