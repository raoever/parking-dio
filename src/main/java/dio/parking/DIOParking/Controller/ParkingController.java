package dio.parking.DIOParking.Controller;

import dio.parking.DIOParking.Model.Parking;
import dio.parking.DIOParking.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parking createParking(@RequestBody Parking parking) {
        return parkingService.addParking(parking);
    }
}

