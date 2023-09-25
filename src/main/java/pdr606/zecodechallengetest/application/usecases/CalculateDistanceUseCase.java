package pdr606.zecodechallengetest.application.usecases;

import pdr606.zecodechallengetest.application.gateways.PartnerGetaway;

public class CalculateDistanceUseCase {

    private PartnerGetaway partnerGetaway;

    public CalculateDistanceUseCase(PartnerGetaway partnerGetaway) {
        this.partnerGetaway = partnerGetaway;
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2){
         return partnerGetaway.calculateDistance(lat1, lon1, lat2, lon2);
     }
}
