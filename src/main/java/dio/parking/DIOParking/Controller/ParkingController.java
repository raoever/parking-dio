package dio.parking.DIOParking.Controller;

import dio.parking.DIOParking.Model.Parking;
import dio.parking.DIOParking.Repository.ParkingRepository;
import dio.parking.DIOParking.Service.ParkingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private ParkingRepository parkingRepository;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping
    public List<Parking> findAll(){
        return parkingRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parking createParking(@RequestBody Parking parking) {
        return parkingService.addParking(parking);
    }
}

