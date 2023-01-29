package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.repository.UsuarioRepository;
import hello.dev.DrivingSchool.rest.form.AtualizaUsuarioForm;
import hello.dev.DrivingSchool.rest.form.CadastroDeUsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public abstract class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public abstract Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm);

    public void atualizaUsuario(AtualizaUsuarioForm atualizaUsuarioForm, String id) {
        Usuario usuarioEncontrado = usuarioRepository.getReferenceById(id);

        if (atualizaUsuarioForm.getNome() != null) usuarioEncontrado.setNome(atualizaUsuarioForm.getNome());
        if (atualizaUsuarioForm.getEmail() != null) usuarioEncontrado.setEmail(atualizaUsuarioForm.getEmail());
        if (atualizaUsuarioForm.getSenha() != null) usuarioEncontrado.setSenha(atualizaUsuarioForm.getSenha());
        if (atualizaUsuarioForm.getTelefone() != null) usuarioEncontrado.setTelefone(atualizaUsuarioForm.getTelefone());
        if (atualizaUsuarioForm.getLogradouro() != null) usuarioEncontrado.getEndereco().setLogradouro(atualizaUsuarioForm.getLogradouro());
        if (atualizaUsuarioForm.getCep() != null) usuarioEncontrado.getEndereco().setCEP(atualizaUsuarioForm.getCep());
        if (atualizaUsuarioForm.getNumero() != null) usuarioEncontrado.getEndereco().setNumero(parseInt(atualizaUsuarioForm.getNumero()));
        if (atualizaUsuarioForm.getCidade() != null) usuarioEncontrado.getEndereco().setCidade(atualizaUsuarioForm.getCidade());
        if (atualizaUsuarioForm.getComplemento() != null) usuarioEncontrado.getEndereco().setComplemento(atualizaUsuarioForm.getComplemento());
    }

    protected LocalDate converterData (String data) {
        String[] split = data.split("-");
        return LocalDate.of(parseInt(split[2]), parseInt(split[1]), parseInt(split[0]));
    }
}

