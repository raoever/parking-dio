package dio.parking.DIOParking.Controller;

import dio.parking.DIOParking.Model.Parking;
import dio.parking.DIOParking.Repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    ParkingRepository parkingRepository;

    @GetMapping("/")
    public List<Parking> findAll (){
//        ResponseEntity<List<Parking>>
        Parking parking = new Parking();
        parking.setCor("Azul");
        parking.setModelo("Gol");
        parking.setEstado("TO");
        parkingRepository.save(parking);

        return Arrays.asList(parking, parking);
//        List<Parking> candidatos = parkingRepository.findAll();
//        return new ResponseEntity<>(candidatos, HttpStatus.OK);
    }

}

