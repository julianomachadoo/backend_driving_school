package hello.dev.DrivingSchool;

import hello.dev.DrivingSchool.model.*;
import hello.dev.DrivingSchool.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class CommandRunner implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) {
//        Aluno aluno = new Aluno();
//        aluno.setCpf("111.111.111-11");
//        aluno.setNome("Fulano");
//        aluno.setDataDeNascimento(LocalDate.of(1999, 12, 12));
//        aluno.setEmail("fulano@email.com");
//        aluno.setSenha("123456");
//        aluno.setTelefone("79-99999-9999");
//        aluno.setEndereco(
//                new Endereco("Rua de exemplo", "49000-000", 1111, "Cidade", "complemento"));
//        aluno.addTipoCNH(TipoCNH.A);
//        aluno.addTipoCNH(TipoCNH.B);
//        aluno.setDataCadastro(LocalDate.of(2022, 1, 13));
//        usuarioRepository.save(aluno);
//
//        Instrutor instrutor = new Instrutor();
//        instrutor.setCpf("112.111.111-11");
//        instrutor.setNome("Cicrano");
//        instrutor.setDataDeNascimento(LocalDate.of(1999, 12, 12));
//        instrutor.setEmail("cicrano@email.com");
//        instrutor.setSenha("123456");
//        instrutor.setTelefone("79-99999-9999");
//        instrutor.setEndereco(
//                new Endereco("Rua de exemplo", "49000-000", 1111, "Cidade", "complemento"));
//        instrutor.setDataCadastro(LocalDate.of(2022, 6, 13));
//        usuarioRepository.save(instrutor);
//
//        Administrativo administrativo = new Administrativo();
//        administrativo.setCpf("113.111.111-11");
//        administrativo.setNome("Beltrano");
//        administrativo.setDataDeNascimento(LocalDate.of(1999, 12, 12));
//        administrativo.setEmail("beltrano@email.com");
//        administrativo.setSenha("123456");
//        administrativo.setTelefone("79-99999-9999");
//        administrativo.setEndereco(
//                new Endereco("Rua de exemplo", "49000-000", 1111, "Cidade", "complemento"));
//        usuarioRepository.save(administrativo);
    }
}