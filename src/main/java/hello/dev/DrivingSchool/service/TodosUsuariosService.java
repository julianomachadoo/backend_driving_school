package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.exceptions.DadosNaoEncontradosException;
import hello.dev.DrivingSchool.model.Aluno;
import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.rest.dto.UsuarioDTO;
import hello.dev.DrivingSchool.rest.form.CadastroDeUsuarioForm;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodosUsuariosService extends UsuarioService{

    @Override
    public Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm) {
        return null;
    }

    public List<UsuarioDTO> listarTodos() {
        List<UsuarioDTO> usuarios = usuarioRepository.findAll().stream().map(this::converterUsuario).toList();
        if (usuarios.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
        return usuarios;
    }

    public List<UsuarioDTO> pesquisaPorNome(String nome) {
        List<UsuarioDTO> usuarios = usuarioRepository.findByNomeContainingIgnoreCase(nome).stream().map(this::converterUsuario).toList();
        if (usuarios.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
        return usuarios;
    }

    public List<UsuarioDTO> pesquisaPorCPF(String cpf) {
        Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
        if (usuario.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
        return Collections.singletonList(converterUsuario(usuario.get()));
    }

    public List<UsuarioDTO> pesquisaPorEmail(String email) {
        List<UsuarioDTO> usuarios = usuarioRepository.findByEmailContainingIgnoreCase(email).stream().map(this::converterUsuario).collect(Collectors.toList());
        if (usuarios.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
        return usuarios;
    }


    public List<UsuarioDTO> pesquisaPorData(String dataInicio, String dataFim) {
        LocalDate localDateInicio = converterData(dataInicio);
        LocalDate localDateFim = converterData(dataFim);
        List<UsuarioDTO> usuarios = usuarioRepository.encontrarPorData(localDateInicio, localDateFim).stream().map(this::converterUsuario).toList();
        if (usuarios.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
        return usuarios;
    }

    protected UsuarioDTO converterUsuario (Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getCpf(),
                usuario.getDataDeNascimento(),
                usuario.getDataCadastro(),
                usuario.getEndereco(),
                usuario.getTelefone(),
                usuario.getClass().toString().substring(36)
        );

        if (usuario.getClass().equals(Aluno.class)) {
            ((Aluno) usuario).getTipoCNHList().forEach(tipoCNH -> usuarioDTO.getTipoCNHList().add(tipoCNH));
        }
        return usuarioDTO;
    }
}
