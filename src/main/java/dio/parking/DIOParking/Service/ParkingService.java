package dio.parking.DIOParking.Service;

import dio.parking.DIOParking.Model.Parking;
import dio.parking.DIOParking.Repository.ParkingRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParkingService {

    final private ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public Parking addParking(Parking parking){
        parking.setId(UUID.randomUUID().toString().split("-")[0]);
        return parkingRepository.save(parking);
    }

}
