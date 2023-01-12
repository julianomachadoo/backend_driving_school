package hello.dev.DrivingSchool;

import hello.dev.DrivingSchool.model.Aluno;
import hello.dev.DrivingSchool.model.Endereco;
import hello.dev.DrivingSchool.model.TipoCNH;
import hello.dev.DrivingSchool.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class CommandRunner implements CommandLineRunner {

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public void run(String... args) throws Exception {
        Aluno aluno = new Aluno();
        aluno.setCpf("111.111.111-11");
        aluno.setNome("Aluno");
        aluno.setDataDeNascimento(LocalDate.of(1999, 12, 12));
        aluno.setEmail("aluno@email.com");
        aluno.setSenha("123456");
        aluno.setTelefone("79-99999-9999");
        aluno.setEndereco(
                new Endereco("Rua de exemplo", "49000-000", 1111, "Cidade"));
        aluno.addTipoCNH(TipoCNH.A);
        aluno.addTipoCNH(TipoCNH.B);
        alunoRepository.save(aluno);
    }
}