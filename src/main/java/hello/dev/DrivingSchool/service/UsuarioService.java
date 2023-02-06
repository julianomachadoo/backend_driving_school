package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.repository.UsuarioRepository;
import hello.dev.DrivingSchool.rest.form.CadastroDeUsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public abstract class UsuarioService {

    @Autowired
    protected UsuarioRepository usuarioRepository;

    public abstract Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm);

    protected LocalDate converterData (String data) {
        String[] split = data.split("-");
        return LocalDate.of(parseInt(split[2]), parseInt(split[1]), parseInt(split[0]));
    }
}

