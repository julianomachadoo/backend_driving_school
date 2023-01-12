package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.repository.UsuarioRepository;
import hello.dev.DrivingSchool.rest.form.AtualizaUsuarioForm;
import hello.dev.DrivingSchool.rest.form.CadastroDeUsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public abstract Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm);

    public void atualizaUsuario(AtualizaUsuarioForm atualizaUsuarioForm, String cpf) {
        Usuario usuarioEncontrado = repository.getReferenceById(cpf);

        if (atualizaUsuarioForm.getNome() != null) usuarioEncontrado.setNome(atualizaUsuarioForm.getNome());
        if (atualizaUsuarioForm.getEmail() != null) usuarioEncontrado.setEmail(atualizaUsuarioForm.getEmail());
        if (atualizaUsuarioForm.getSenha() != null) usuarioEncontrado.setSenha(atualizaUsuarioForm.getSenha());
        if (atualizaUsuarioForm.getTelefone() != null) usuarioEncontrado.setTelefone(atualizaUsuarioForm.getTelefone());
        if (atualizaUsuarioForm.getLogradouro() != null) usuarioEncontrado.getEndereco().setLogradouro(atualizaUsuarioForm.getLogradouro());
        if (atualizaUsuarioForm.getCep() != null) usuarioEncontrado.getEndereco().setCEP(atualizaUsuarioForm.getCep());
        if (atualizaUsuarioForm.getNumero() != null) usuarioEncontrado.getEndereco().setNumero(Integer.parseInt(atualizaUsuarioForm.getNumero()));
        if (atualizaUsuarioForm.getCidade() != null) usuarioEncontrado.getEndereco().setCidade(atualizaUsuarioForm.getCidade());
    }
}

