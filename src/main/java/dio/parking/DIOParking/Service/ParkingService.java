package dio.parking.DIOParking.Service;

import dio.parking.DIOParking.Exception.ParkingNotFoundException;
import dio.parking.DIOParking.Model.Parking;
import dio.parking.DIOParking.Repository.ParkingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ParkingService {

    final private ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Transactional
    public Parking addParking(Parking parking){
        parking.setId(UUID.randomUUID().toString().split("-")[0]);
        parking.setEntrada(LocalDateTime.now());
        return parkingRepository.save(parking);
    }

    @Transactional(readOnly = true)
    public Parking findById(String id) {
        return parkingRepository.findById(id).orElseThrow(() ->
                new ParkingNotFoundException(id));
    }



    @Transactional
    public void delete(String id) {
        findById(id);
        parkingRepository.deleteById(id);
    }

    @Transactional
    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setCor(parkingCreate.getCor());
        parking.setEstado(parkingCreate.getEstado());
        parking.setModelo(parkingCreate.getModelo());
        parking.setPlaca(parkingCreate.getPlaca());
        parkingRepository.save(parking);
        return parking;
    }

//    @Transactional
//    public Parking checkOut(String id) {
//        Parking parking = findById(id);
//        parking.setExitDate(LocalDateTime.now());
//        parking.setBill(ParkingCheckOut.getBill(parking));
//        parkingRepository.save(parking);
//        return parking;
//    }

}
