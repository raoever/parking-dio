package dio.parking.DIOParking.Model;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Data
public class Parking {

    private String id;
    private String placa;
    private String estado;
    private String modelo;
    private String cor;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Double conta;

}
