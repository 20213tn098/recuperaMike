package mx.edu.utez.examenRecu.services.viajes;

import mx.edu.utez.examenRecu.models.viajes.Viajes;
import mx.edu.utez.examenRecu.models.viajes.ViajesRepository;
import mx.edu.utez.examenRecu.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViajesService {
    @Autowired
    private ViajesRepository repository;

    public Response getAll() {
        return new Response<List<Viajes>>(
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

    public Response insert(Viajes viajes) {
        if (this.repository.existsByUserAndDestiny(viajes.getUser().getId(),
                viajes.getDestiny().getId()))
            return new Response(
                    null,
                    true,
                    200,
                    "Ya existe este viaje"
            );
        return new Response(
                this.repository.saveAndFlush(viajes),
                false,
                200,
                "Viaje registrado correctamente"
        );
    }

    public Response update(Viajes viajes) {
        if (this.repository.existsById(viajes.getId()))
            return new Response(
                    this.repository.saveAndFlush(viajes),
                    false,
                    200,
                    "Viaje actualizado correctamente"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este viaje"
        );
    }

    public Response delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "Viaje eliminado correctamente"
            );
        }
        return new Response(
                null,
                true,
                200,
                "No existe este viaje"
        );
    }
}
