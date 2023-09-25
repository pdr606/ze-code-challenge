package pdr606.zecodechallengetest.infra.gateways;

import org.springframework.dao.DataIntegrityViolationException;
import pdr606.zecodechallengetest.application.gateways.PartnerEntityMapper;
import pdr606.zecodechallengetest.application.gateways.PartnerGetaway;
import pdr606.zecodechallengetest.core.domain.exceptions.DataBaseException;
import pdr606.zecodechallengetest.core.domain.exceptions.NotFoundException;
import pdr606.zecodechallengetest.core.domain.partner.Partner;
import pdr606.zecodechallengetest.infra.persistence.PartnerEntity;
import pdr606.zecodechallengetest.infra.persistence.PartnerRepository;

import java.util.Comparator;
import java.util.List;


public class PartnerRepositoryGetaway implements PartnerGetaway {

    private final PartnerEntityMapper partnerEntityMapper;
    private final PartnerRepository partnerRepository;

    public PartnerRepositoryGetaway(PartnerEntityMapper partnerEntityMapper, PartnerRepository partnerRepository) {
        this.partnerEntityMapper = partnerEntityMapper;
        this.partnerRepository = partnerRepository;
    }

    @Override
    public void createPartner(List<Partner> partnerDomainObj) {
        try{
            List<PartnerEntity> partnerEntity = partnerEntityMapper.toEntity(partnerDomainObj);
            partnerRepository.saveAll(partnerEntity);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    @Override
    public Partner findProximPartner(double lat, double lon) {
        List<PartnerEntity> partners = partnerRepository.findNearestPartners(lat, lon);

        if (partners.isEmpty()) {
            throw new NotFoundException(
                    "No partners found in your region");
        }

        partners.sort(Comparator.comparingDouble(partnerEntity ->
                calculateDistance(lat, lon, partnerEntity.getAddress().getCoordinates()[0], partnerEntity.getAddress().getCoordinates()[1])));

        return partnerEntityMapper.toDomainObj(partners.get(0));
    }

    @Override
    public Partner findById(String id) {
        PartnerEntity partnerEntity = partnerRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Partner" + id + " not found"));

        return partnerEntityMapper.toDomainObj(partnerEntity);
    }

    @Override
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371.01;

        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double distance = R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return distance;
    }
}
