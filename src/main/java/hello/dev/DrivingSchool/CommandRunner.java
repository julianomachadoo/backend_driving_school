package hello.dev.DrivingSchool;

import hello.dev.DrivingSchool.model.form.CadastroDeUsuarioForm;
import hello.dev.DrivingSchool.repository.DadosUsuarioRepository;
import hello.dev.DrivingSchool.repository.UsuarioRepository;
import hello.dev.DrivingSchool.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandRunner implements CommandLineRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(String... args) {

        CadastroDeUsuarioForm aluno = new CadastroDeUsuarioForm(
                "Fulano",
                "fulano@email.com",
                "123456",
                "111.111.111-11",
                "12-12-1999",
                "79-99999-9999",
                "Rua de exemplo",
                "49000-000",
                "1111",
                "Cidade",
                "Estado",
                "Complemento",
                "ALUNO",
                "AB"
        );
        usuarioService.cadastrar(aluno);

        CadastroDeUsuarioForm instrutor = new CadastroDeUsuarioForm(
                "Cicrano",
                "cicrano@email.com",
                "123456",
                "112.111.111-11",
                "12-12-1999",
                "79-99999-9991",
                "Rua de exemplo1",
                "49000-000",
                "1111",
                "Cidade",
                "Estado",
                "Complemento",
                "INSTRUTOR",
                null
        );
        usuarioService.cadastrar(instrutor);
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