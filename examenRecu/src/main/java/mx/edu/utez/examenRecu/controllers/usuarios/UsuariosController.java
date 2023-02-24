package mx.edu.utez.examenRecu.controllers.usuarios;

import mx.edu.utez.examenRecu.controllers.usuarios.dtos.UsuariosDto;
import mx.edu.utez.examenRecu.services.usuarios.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-examenRecu/usuarios")
@CrossOrigin(origins = {"*"})
public class UsuariosController {
    @Autowired
    private UsuariosService service;

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
            @RequestBody UsuariosDto pokemon
    ) {
        return new ResponseEntity(
                this.service.insert(pokemon.parseToUsuario()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity update(
            @RequestBody UsuariosDto pokemon
    ) {
        return new ResponseEntity(
                this.service.update(pokemon.parseToUsuario()),
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
