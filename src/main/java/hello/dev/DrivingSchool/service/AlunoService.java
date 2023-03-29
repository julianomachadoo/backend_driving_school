package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.model.Aluno;
import hello.dev.DrivingSchool.model.Endereco;
import hello.dev.DrivingSchool.model.TipoCNH;
import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.model.form.CadastroDeUsuarioForm;
import org.springframework.stereotype.Service;

@Service
public class AlunoService extends UsuarioService {

    public Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm) {
//        Aluno aluno = new Aluno();
//        aluno.setNome(cadastroDeUsuarioForm.getNome());
//        aluno.setEmail(cadastroDeUsuarioForm.getEmail());
//        aluno.setSenha(cadastroDeUsuarioForm.getSenha());
//        aluno.setCpf(cadastroDeUsuarioForm.getCpf());
//        aluno.setDataDeNascimento(converterData(cadastroDeUsuarioForm.getDataDeNascimento()));
//        aluno.setEndereco(new Endereco
//                (cadastroDeUsuarioForm.getLogradouro(),
//                cadastroDeUsuarioForm.getCep(),
//                cadastroDeUsuarioForm.getNumero(),
//                cadastroDeUsuarioForm.getCidade(),
//                cadastroDeUsuarioForm.getComplemento()));
//        aluno.setTelefone(cadastroDeUsuarioForm.getTelefone());
//        cadastroDeUsuarioForm.getTiposCNH().forEach(t -> aluno.addTipoCNH(TipoCNH.valueOf(t)));
//        return usuarioRepository.save(aluno);
        return null;
    }
}
