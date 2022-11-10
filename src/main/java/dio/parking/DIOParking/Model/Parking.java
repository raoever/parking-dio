package dio.parking.DIOParking.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Parking {

    @Id
    private String id;
    private String placa;
    private String estado;
    private String modelo;
    private String cor;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Double conta;

}
