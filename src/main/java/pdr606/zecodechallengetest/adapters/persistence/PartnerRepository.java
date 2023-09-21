package pdr606.zecodechallengetest.adapters.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pdr606.zecodechallengetest.adapters.entities.PartnerData;

@Repository
public interface PartnerRepository extends MongoRepository<PartnerData, String> {
}
