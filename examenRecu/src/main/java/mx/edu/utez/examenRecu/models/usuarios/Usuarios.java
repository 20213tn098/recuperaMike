package mx.edu.utez.examenRecu.models.usuarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examenRecu.models.viajes.Viajes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private Date birthday;

    @OneToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    private Viajes trip;
}
