package mx.edu.utez.examenRecu.models.destinos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examenRecu.models.viajes.Viajes;

import javax.persistence.*;

@Entity
@Table(name = "destinos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Destinos {
    @Id
    @GeneratedValue
    private Long id;
    private String destinyName;
    private String description;
    private Float price;
    private Float qualification;
    private Boolean availability;

    @OneToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    private Viajes trip;
}
