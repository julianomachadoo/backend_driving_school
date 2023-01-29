package hello.dev.DrivingSchool.rest.controller;

import hello.dev.DrivingSchool.model.TipoUsuario;
import hello.dev.DrivingSchool.model.Usuario;
import hello.dev.DrivingSchool.rest.dto.UsuarioDTO;
import hello.dev.DrivingSchool.rest.form.AtualizaUsuarioForm;
import hello.dev.DrivingSchool.rest.form.CadastroDeUsuarioForm;
import hello.dev.DrivingSchool.service.AdministrativoService;
import hello.dev.DrivingSchool.service.AlunoService;
import hello.dev.DrivingSchool.service.InstrutorService;
import hello.dev.DrivingSchool.service.TodosUsuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private TodosUsuariosService todosUsuariosService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private AdministrativoService administrativoService;

    @GetMapping
    public List<UsuarioDTO> pesquisaPorNomeCPFOuEmail(@RequestParam(required = false) String nome,
                                                      @RequestParam(required = false) String cpf,
                                                      @RequestParam(required = false) String email) {
        if (nome != null) {
            return todosUsuariosService.pesquisaPorNome(nome);
        }

        if (cpf != null) {
            return todosUsuariosService.pesquisaPorCPF(cpf);
        }
//
//        if (email != null) {
//            return todosUsuariosService.pesquisaPorEmail(email);
//        }
//
        return todosUsuariosService.listarTodos();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastroDeUsuario(@RequestBody @Valid CadastroDeUsuarioForm cadastroDeUsuarioForm,
                                               UriComponentsBuilder uriComponentsBuilder) {
        if (TipoUsuario.valueOf(cadastroDeUsuarioForm.getTipoUsuario().toUpperCase()) == TipoUsuario.ALUNO) {
            Usuario aluno = alunoService.cadastrar(cadastroDeUsuarioForm);
            URI uri = uriComponentsBuilder.path("/pessoas").buildAndExpand().toUri();
            return ResponseEntity.created(uri).body(aluno);
        }

        if (TipoUsuario.valueOf(cadastroDeUsuarioForm.getTipoUsuario().toUpperCase()) == TipoUsuario.INSTRUTOR) {
            Usuario instrutor = instrutorService.cadastrar(cadastroDeUsuarioForm);
            URI uri = uriComponentsBuilder.path("/pessoas").buildAndExpand().toUri();
            return ResponseEntity.created(uri).body(instrutor);
        }

        if (TipoUsuario.valueOf(cadastroDeUsuarioForm.getTipoUsuario().toUpperCase()) == TipoUsuario.ADMINISTRATIVO) {
            Usuario administrativo = administrativoService.cadastrar(cadastroDeUsuarioForm);
            URI uri = uriComponentsBuilder.path("/pessoas").buildAndExpand().toUri();
            return ResponseEntity.created(uri).body(administrativo);
        }
        throw new IllegalArgumentException();
    }

    @PutMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizaUsuario(@RequestBody @Valid AtualizaUsuarioForm atualizaUsuarioForm, @PathVariable String id) {
        todosUsuariosService.atualizaUsuario(atualizaUsuarioForm, id);
    }
}
