package dio.parking.DIOParking.Controller;

import dio.parking.DIOParking.Model.Parking;
import dio.parking.DIOParking.Repository.ParkingRepository;
import dio.parking.DIOParking.Service.ParkingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    @Autowired
    private final ParkingService parkingService;

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

    @GetMapping("/{id}")
    public ResponseEntity<Parking> findById(@PathVariable String id) {
        Parking parking = parkingService.findById(id);
        return ResponseEntity.ok(parking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Parking> update(@PathVariable String id, @RequestBody Parking parkingUpdate) {
        Parking parking = parkingService.update(id, parkingUpdate);
        return ResponseEntity.ok(parking);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Parking> checkOut(@PathVariable String id) {
        Parking parking = parkingService.checkOut(id);
        return ResponseEntity.ok(parking);
    }
}

