package pdr606.zecodechallengetest.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pdr606.zecodechallengetest.application.gateways.PartnerEntityMapper;
import pdr606.zecodechallengetest.application.gateways.PartnerGetaway;
import pdr606.zecodechallengetest.application.usecases.CalculateDistanceUseCase;
import pdr606.zecodechallengetest.application.usecases.CreatePartnerUseCase;
import pdr606.zecodechallengetest.application.usecases.FindByIdPartnerUseCase;
import pdr606.zecodechallengetest.application.usecases.FindProximPartnerUseCase;
import pdr606.zecodechallengetest.controllers.dto.PartnerDtoMapper;
import pdr606.zecodechallengetest.infra.gateways.PartnerRepositoryGetaway;
import pdr606.zecodechallengetest.infra.persistence.PartnerRepository;

@Configuration
public class PartnerConfig {

    @Bean
    CreatePartnerUseCase createPartnerUseCase(PartnerGetaway partnerGetaway){
        return new CreatePartnerUseCase(partnerGetaway);
    }

    @Bean
    FindByIdPartnerUseCase findByIdPartnerUseCase(PartnerGetaway partnerGetaway){
        return new FindByIdPartnerUseCase(partnerGetaway);
    }

    @Bean
    FindProximPartnerUseCase findProximPartnerUseCase(PartnerGetaway partnerGetaway){
        return new FindProximPartnerUseCase(partnerGetaway);
    }

    @Bean
    CalculateDistanceUseCase calculateDistanceUseCase(PartnerGetaway partnerGetaway){
        return new CalculateDistanceUseCase(partnerGetaway);
    }


    @Bean
    PartnerGetaway partnerGetaway(PartnerRepository partnerRepository, PartnerEntityMapper partnerEntityMapper){
        return new PartnerRepositoryGetaway(partnerEntityMapper, partnerRepository);
    }

    @Bean
    PartnerEntityMapper partnerEntityMapper(){
        return new PartnerEntityMapper();
    }

    @Bean
    PartnerDtoMapper partnerDtoMapper(){
        return new PartnerDtoMapper();
    }

}
