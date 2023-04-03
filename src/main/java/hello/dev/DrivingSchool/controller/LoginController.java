package hello.dev.DrivingSchool.controller;

import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.model.form.LoginUsuarioForm;
import hello.dev.DrivingSchool.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginUsuarioForm loginUsuarioForm) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(loginUsuarioForm.getEmail(), loginUsuarioForm.getSenha());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(tokenJWT);
    }
}
