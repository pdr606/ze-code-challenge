package pdr606.zecodechallengetest.adapters.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import pdr606.zecodechallengetest.adapters.entities.PartnerData;

public interface PartnerRepository extends MongoRepository<PartnerData, String> {
}
