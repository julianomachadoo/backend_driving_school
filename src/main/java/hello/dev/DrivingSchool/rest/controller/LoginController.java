package hello.dev.DrivingSchool.rest.controller;

import hello.dev.DrivingSchool.rest.form.LoginUsuarioForm;
import hello.dev.DrivingSchool.service.TodosUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

    @Autowired
    private TodosUsuariosService todosUsuariosService;

    @PostMapping
    public ResponseEntity<?> login(
            @RequestBody LoginUsuarioForm loginUsuario
    ) {
        todosUsuariosService.login(loginUsuario);
        return ResponseEntity.ok(null);
    }
}
