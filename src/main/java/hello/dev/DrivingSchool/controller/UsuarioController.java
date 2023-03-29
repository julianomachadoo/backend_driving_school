package hello.dev.DrivingSchool.controller;

import hello.dev.DrivingSchool.model.form.AtualizaUsuarioForm;
import hello.dev.DrivingSchool.model.form.CadastroDeUsuarioForm;
import hello.dev.DrivingSchool.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

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
    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastroDeUsuario(
            @RequestBody @Valid CadastroDeUsuarioForm cadastroDeUsuarioForm) {
        usuarioService.cadastrar(cadastroDeUsuarioForm);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizaUsuario(
            @RequestBody @Valid AtualizaUsuarioForm atualizaUsuarioForm,
            @PathVariable Long id) {

        usuarioService.atualizarUsuario(atualizaUsuarioForm, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok().build();
    }
}
