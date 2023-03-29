package hello.dev.DrivingSchool.controller;

import hello.dev.DrivingSchool.model.dto.UsuarioDTO;
import hello.dev.DrivingSchool.model.form.AtualizaUsuarioForm;
import hello.dev.DrivingSchool.model.form.CadastroDeUsuarioForm;
import hello.dev.DrivingSchool.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> pesquisaPorNomeCPFOuEmail(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String tipoUsuario,
            @RequestParam(required = false) String dataInicio,
            @RequestParam(required = false) String dataFim)
    {

        return usuarioService.buscarPorNomeCpfEmailTipoUsuario(nome, cpf, email, tipoUsuario, dataInicio, dataFim);
    }

    @GetMapping("/todos")
    public List<UsuarioDTO> pesquisarTodos() {
        return usuarioService.buscarTodos();
    }

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
