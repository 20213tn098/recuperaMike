package mx.edu.utez.examenRecu.models.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    boolean existsByUsername(String username, Long id);
}
