package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.model.Aluno;
import hello.dev.DrivingSchool.model.Endereco;
import hello.dev.DrivingSchool.model.TipoCNH;
import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.repository.UsuarioRepository;
import hello.dev.DrivingSchool.rest.form.CadastroDeUsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService extends UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm) {
        Aluno aluno = new Aluno();
        aluno.setNome(cadastroDeUsuarioForm.getNome());
        aluno.setEmail(cadastroDeUsuarioForm.getEmail());
        aluno.setSenha(cadastroDeUsuarioForm.getSenha());
        aluno.setCpf(cadastroDeUsuarioForm.getCpf());
        aluno.setDataDeNascimento(cadastroDeUsuarioForm.getDataDeNascimento());
        aluno.setEndereco(
                new Endereco(cadastroDeUsuarioForm.getLogradouro(),
                        cadastroDeUsuarioForm.getCep(),
                        cadastroDeUsuarioForm.getNumero(),
                        cadastroDeUsuarioForm.getCidade())
        );
        aluno.setTelefone(cadastroDeUsuarioForm.getTelefone());
        cadastroDeUsuarioForm.getTiposCNH().forEach(t -> aluno.addTipoCNH(TipoCNH.valueOf(t)));
        return usuarioRepository.save(aluno);
    }
}
