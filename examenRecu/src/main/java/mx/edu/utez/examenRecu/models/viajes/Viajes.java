package mx.edu.utez.examenRecu.models.viajes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examenRecu.models.destinos.Destinos;
import mx.edu.utez.examenRecu.models.usuarios.Usuarios;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "viajes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date start_date;
    private Date end_date;

    @OneToOne
    @JoinColumn(name = "destiny_id", referencedColumnName = "id")
    private Destinos destiny;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Usuarios user;
}
