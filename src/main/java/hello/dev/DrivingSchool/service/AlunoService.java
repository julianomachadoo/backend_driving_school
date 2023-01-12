package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.model.Aluno;
import hello.dev.DrivingSchool.model.Endereco;
import hello.dev.DrivingSchool.repository.AlunoRepository;
import hello.dev.DrivingSchool.rest.form.AtualizaAlunoForm;
import hello.dev.DrivingSchool.rest.form.CadastroDeAlunoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Aluno atualizaAluno(AtualizaAlunoForm atualizaAlunoForm, String cpf) {
        Aluno alunoEncontrado = alunoRepository.getReferenceById(cpf);

        if (atualizaAlunoForm.getNome() != null) alunoEncontrado.setNome(atualizaAlunoForm.getNome());

        if (atualizaAlunoForm.getEmail() != null) alunoEncontrado.setEmail(atualizaAlunoForm.getEmail());

        if (atualizaAlunoForm.getSenha() != null) alunoEncontrado.setSenha(atualizaAlunoForm.getSenha());

        if (atualizaAlunoForm.getTelefone() != null) alunoEncontrado.setTelefone(atualizaAlunoForm.getTelefone());

        if (atualizaAlunoForm.getLogradouro() != null)
            alunoEncontrado.getEndereco().setLogradouro(atualizaAlunoForm.getLogradouro());

        if (atualizaAlunoForm.getCep() != null) alunoEncontrado.getEndereco().setCEP(atualizaAlunoForm.getCep());

        if (atualizaAlunoForm.getNumero() != null)
            alunoEncontrado.getEndereco().setNumero(Integer.parseInt(atualizaAlunoForm.getNumero()));

        if (atualizaAlunoForm.getCidade() != null) alunoEncontrado.getEndereco().setCidade(atualizaAlunoForm.getCidade());

        return alunoEncontrado;
    }
}
