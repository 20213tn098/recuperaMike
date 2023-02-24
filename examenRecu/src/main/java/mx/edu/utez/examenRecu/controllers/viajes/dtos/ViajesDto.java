package mx.edu.utez.examenRecu.controllers.viajes.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examenRecu.models.destinos.Destinos;
import mx.edu.utez.examenRecu.models.usuarios.Usuarios;
import mx.edu.utez.examenRecu.models.viajes.Viajes;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ViajesDto {
    private Long id;
    private Date start_date;
    private Date end_date;
    private Destinos destiny;
    private Usuarios user;


    public Viajes parseToViaje(){
        return new Viajes(
                getId(),
                getStart_date(),
                getEnd_date(),
                getDestiny(),
                getUser()
        );
    }
}
