package hello.dev.DrivingSchool.controller;

import hello.dev.DrivingSchool.service.TodosUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private TodosUsuariosService todosUsuariosService;

//    @GetMapping
//    public List<UsuarioDTO> pesquisaPorNomeCPFOuEmail(
//            @RequestParam(required = false) String nome,
//            @RequestParam(required = false) String cpf,
//            @RequestParam(required = false) String email,
//            @RequestParam(required = false) String tipoUsuario) {
//
//        if (nome != null) return todosUsuariosService.pesquisaPorNome(nome);
//        if (cpf != null) return todosUsuariosService.pesquisaPorCPF(cpf);
//        if (email != null) return todosUsuariosService.pesquisaPorEmail(email);
//        if (tipoUsuario != null) return todosUsuariosService.pesquisaPorTipoUsuario(tipoUsuario);
//        return todosUsuariosService.listarTodos();
//    }
//
//    @GetMapping("/data")
//    public List<UsuarioDTO> pesquisaPorData(
//            @RequestParam String dataInicio,
//            @RequestParam String dataFim) {
//
//        return todosUsuariosService.pesquisaPorData(dataInicio, dataFim);
//    }
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity<?> cadastroDeUsuario(
//            @RequestBody @Valid CadastroDeUsuarioForm cadastroDeUsuarioForm,
//            UriComponentsBuilder uriComponentsBuilder) {
//
//        if (TipoUsuario.valueOf(cadastroDeUsuarioForm.getTipoUsuario().toUpperCase()) == TipoUsuario.ALUNO) {
//            Usuario aluno = alunoService.cadastrar(cadastroDeUsuarioForm);
//            URI uri = uriComponentsBuilder.path("/pessoas").buildAndExpand().toUri();
//            return ResponseEntity.created(uri).body(aluno);
//        }
//
//        if (TipoUsuario.valueOf(cadastroDeUsuarioForm.getTipoUsuario().toUpperCase()) == TipoUsuario.INSTRUTOR) {
//            Usuario instrutor = instrutorService.cadastrar(cadastroDeUsuarioForm);
//            URI uri = uriComponentsBuilder.path("/pessoas").buildAndExpand().toUri();
//            return ResponseEntity.created(uri).body(instrutor);
//        }
//
//        if (TipoUsuario.valueOf(cadastroDeUsuarioForm.getTipoUsuario().toUpperCase()) == TipoUsuario.ADMINISTRATIVO) {
//            Usuario administrativo = administrativoService.cadastrar(cadastroDeUsuarioForm);
//            URI uri = uriComponentsBuilder.path("/pessoas").buildAndExpand().toUri();
//            return ResponseEntity.created(uri).body(administrativo);
//        }
//        throw new IllegalArgumentException();
//    }
//
//    @PutMapping("/{id}")
//    @Transactional
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void atualizaUsuario(
//            @RequestBody @Valid AtualizaUsuarioForm atualizaUsuarioForm,
//            @PathVariable String id) {
//
//        todosUsuariosService.atualizaUsuario(atualizaUsuarioForm, id);
//    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity<?> remover(@PathVariable Long id) {
//        todosUsuariosService.removerUsuario(id);
//        return ResponseEntity.ok().build();
//    }
}
