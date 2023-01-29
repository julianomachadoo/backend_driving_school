package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.rest.form.CadastroDeUsuarioForm;
import org.springframework.stereotype.Service;

@Service
public class TodosUsuariosService extends UsuarioService{
    @Override
    public Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm) {
        return null;
    }
}
