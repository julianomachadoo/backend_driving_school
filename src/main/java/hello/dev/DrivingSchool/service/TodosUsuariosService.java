package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.exceptions.DadosNaoEncontradosException;
import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.rest.dto.UsuarioDTO;
import hello.dev.DrivingSchool.rest.form.CadastroDeUsuarioForm;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TodosUsuariosService extends UsuarioService{
    @Override
    public Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm) {
        return null;
    }

    public List<UsuarioDTO> pesquisaPorCPF(String cpf) {
        Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
        if (usuario.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
        return Collections.singletonList(converterUsuario(usuario.get()));
    }

}
