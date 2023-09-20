package pdr606.zecodechallengetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ZeCodeChallengeTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeCodeChallengeTestApplication.class, args);
	}

}
