package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.model.Endereco;
import hello.dev.DrivingSchool.model.Instrutor;
import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.repository.UsuarioRepository;
import hello.dev.DrivingSchool.rest.form.CadastroDeUsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrutorService extends UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm) {
        Instrutor instrutor = new Instrutor();
        instrutor.setNome(cadastroDeUsuarioForm.getNome());
        instrutor.setEmail(cadastroDeUsuarioForm.getEmail());
        instrutor.setSenha(cadastroDeUsuarioForm.getSenha());
        instrutor.setCpf(cadastroDeUsuarioForm.getCpf());
        instrutor.setDataDeNascimento(cadastroDeUsuarioForm.getDataDeNascimento());
        instrutor.setEndereco(
                new Endereco(cadastroDeUsuarioForm.getLogradouro(),
                        cadastroDeUsuarioForm.getCep(),
                        cadastroDeUsuarioForm.getNumero(),
                        cadastroDeUsuarioForm.getCidade(),
                        cadastroDeUsuarioForm.getComplemento()

                ));
        instrutor.setTelefone(cadastroDeUsuarioForm.getTelefone());
        return usuarioRepository.save(instrutor);
    }
}
