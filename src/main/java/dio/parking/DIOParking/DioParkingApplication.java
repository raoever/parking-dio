package dio.parking.DIOParking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories
public class DioParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioParkingApplication.class, args);
	}

}
