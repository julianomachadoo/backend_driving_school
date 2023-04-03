package hello.dev.DrivingSchool;

import hello.dev.DrivingSchool.model.form.AtualizaUsuarioForm;
import hello.dev.DrivingSchool.model.form.CadastroDeUsuarioForm;
import hello.dev.DrivingSchool.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CommandRunner implements CommandLineRunner {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        CadastroDeUsuarioForm aluno = new CadastroDeUsuarioForm(
                "Fulano",
                "fulano@email.com",
                passwordEncoder.encode("123456"),
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
                passwordEncoder.encode("123456"),
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

        CadastroDeUsuarioForm administrativo = new CadastroDeUsuarioForm(
                "Beltrano",
                "beltrano@email.com",
                passwordEncoder.encode("123456"),
                "113.111.111-11",
                "12-12-1999",
                "79-99999-9992",
                "Rua de exemplo2",
                "49000-000",
                "1111",
                "Cidade",
                "Estado",
                "Complemento",
                "ADMINISTRATIVO",
                null
        );
        usuarioService.cadastrar(administrativo);

        AtualizaUsuarioForm atualizaUsuarioForm = new AtualizaUsuarioForm(
                "Nome atualizado",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                "novo complemento"
        );
        usuarioService.atualizarUsuario(atualizaUsuarioForm, 1L);
    }
}