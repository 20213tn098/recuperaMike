package mx.edu.utez.examenRecu.models.viajes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajesRepository extends JpaRepository<Viajes, Long> {
    boolean existsByUserAndDestiny(Long user_id, Long destiny_id);
}
