package dio.parking.DIOParking.Repository;

import dio.parking.DIOParking.Model.Parking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParkingRepository extends MongoRepository<Parking, String> {
}

