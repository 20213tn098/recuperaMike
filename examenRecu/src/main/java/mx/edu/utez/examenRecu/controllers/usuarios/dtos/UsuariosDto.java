package mx.edu.utez.examenRecu.controllers.usuarios.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examenRecu.models.usuarios.Usuarios;
import mx.edu.utez.examenRecu.models.viajes.Viajes;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuariosDto {
    private Long id;
    private String username;
    private String email;
    private Date birthday;
    private Viajes trip;

    public Usuarios parseToUsuario(){
        return new Usuarios(
                getId(),
                getUsername(),
                getEmail(),
                getBirthday(),
                getTrip()
        );
    }
}
