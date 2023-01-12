package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.model.Aluno;
import hello.dev.DrivingSchool.model.Endereco;
import hello.dev.DrivingSchool.repository.AlunoRepository;
import hello.dev.DrivingSchool.rest.form.CadastroDeAlunoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public Aluno cadastrar(CadastroDeAlunoForm cadastroDeAlunoForm) {
        Aluno aluno = new Aluno();
        aluno.setNome(cadastroDeAlunoForm.getNome());
        aluno.setEmail(cadastroDeAlunoForm.getEmail());
        aluno.setSenha(cadastroDeAlunoForm.getSenha());
        aluno.setCpf(cadastroDeAlunoForm.getCpf());
        aluno.setDataDeNascimento(cadastroDeAlunoForm.getDataDeNascimento());
        aluno.setEndereco(
                new Endereco(cadastroDeAlunoForm.getLogradouro(),
                        cadastroDeAlunoForm.getCep(),
                        cadastroDeAlunoForm.getNumero(),
                        cadastroDeAlunoForm.getCidade())
        );
        aluno.setTelefone(cadastroDeAlunoForm.getTelefone());
        return alunoRepository.save(aluno);
    }
}
