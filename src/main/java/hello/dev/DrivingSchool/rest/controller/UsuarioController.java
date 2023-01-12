package hello.dev.DrivingSchool.rest.controller;

import hello.dev.DrivingSchool.model.TipoUsuario;
import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.rest.form.AtualizaUsuarioForm;
import hello.dev.DrivingSchool.rest.form.CadastroDeUsuarioForm;
import hello.dev.DrivingSchool.service.AdministrativoService;
import hello.dev.DrivingSchool.service.AlunoService;
import hello.dev.DrivingSchool.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private AdministrativoService administrativoService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastroDeUsuario(@RequestBody CadastroDeUsuarioForm cadastroDeAlunoForm,
                                               UriComponentsBuilder uriComponentsBuilder) {
        if (TipoUsuario.valueOf(cadastroDeAlunoForm.getTipoUsuario()) == TipoUsuario.ALUNO) {
            Usuario aluno = alunoService.cadastrar(cadastroDeAlunoForm);
            URI uri = uriComponentsBuilder.path("/pessoas").buildAndExpand().toUri();
            return ResponseEntity.created(uri).body(aluno);
        }

        if (TipoUsuario.valueOf(cadastroDeAlunoForm.getTipoUsuario()) == TipoUsuario.INSTRUTOR) {
            Usuario instrutor = instrutorService.cadastrar(cadastroDeAlunoForm);
            URI uri = uriComponentsBuilder.path("/pessoas").buildAndExpand().toUri();
            return ResponseEntity.created(uri).body(instrutor);
        }

        if (TipoUsuario.valueOf(cadastroDeAlunoForm.getTipoUsuario()) == TipoUsuario.ADMINISTRATIVO) {
            Usuario administrativo = administrativoService.cadastrar(cadastroDeAlunoForm);
            URI uri = uriComponentsBuilder.path("/pessoas").buildAndExpand().toUri();
            return ResponseEntity.created(uri).body(administrativo);
        }
        throw new IllegalArgumentException();
    }

    @PutMapping("/{cpf}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizaUsuario(@RequestBody AtualizaUsuarioForm atualizaUsuarioForm, @PathVariable String cpf) {
        alunoService.atualizaUsuario(atualizaUsuarioForm, cpf);
    }
}
