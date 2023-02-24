package mx.edu.utez.examenRecu.controllers.viajes;

import mx.edu.utez.examenRecu.controllers.viajes.dtos.ViajesDto;
import mx.edu.utez.examenRecu.services.viajes.ViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-examenRecu/viajes")
@CrossOrigin(origins = {"*"})
public class ViajesController {
    @Autowired
    private ViajesService service;

    @GetMapping("/")
    public ResponseEntity getAll() {
        return new ResponseEntity(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity save(
            @RequestBody ViajesDto pokemon
    ) {
        return new ResponseEntity(
                this.service.insert(pokemon.parseToViaje()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity update(
            @RequestBody ViajesDto pokemon
    ) {
        return new ResponseEntity(
                this.service.update(pokemon.parseToViaje()),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
