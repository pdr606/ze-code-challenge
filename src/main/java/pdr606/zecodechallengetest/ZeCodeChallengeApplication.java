package pdr606.zecodechallengetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableCaching
public class ZeCodeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeCodeChallengeApplication.class, args);
	}

}
