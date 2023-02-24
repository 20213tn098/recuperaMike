package mx.edu.utez.examenRecu.services.usuarios;

import mx.edu.utez.examenRecu.models.usuarios.Usuarios;
import mx.edu.utez.examenRecu.models.usuarios.UsuariosRepository;
import mx.edu.utez.examenRecu.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuariosService {
    @Autowired
    private UsuariosRepository repository;

    public Response getAll() {
        return new Response<List<Usuarios>>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    public Response getOne(long id) {
        return new Response<Object>(
                this.repository.findById(id),
                false,
                200,
                "OK"
        );
    }

    public Response insert(Usuarios usuarios) {
        if (this.repository.existsByUsername(usuarios.getUsername(),
                usuarios.getId()))
            return new Response(
                    null,
                    true,
                    200,
                    "Ya existe este usuario"
            );
        return new Response(
                this.repository.saveAndFlush(usuarios),
                false,
                200,
                "Usuario registrado correctamente"
        );
    }

    public Response update(Usuarios usuarios) {
        if (this.repository.existsById(usuarios.getId()))
            return new Response(
                    this.repository.saveAndFlush(usuarios),
                    false,
                    200,
                    "Usuario actualizado correctamente"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este usuario"
        );
    }

    public Response delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "Usuario eliminado correctamente"
            );
        }
        return new Response(
                null,
                true,
                200,
                "No existe este usuario"
        );
    }
}
