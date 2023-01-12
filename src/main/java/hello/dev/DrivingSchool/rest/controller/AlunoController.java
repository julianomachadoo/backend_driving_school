package hello.dev.DrivingSchool.rest.controller;

import hello.dev.DrivingSchool.model.Aluno;
import hello.dev.DrivingSchool.rest.form.CadastroDeAlunoForm;
import hello.dev.DrivingSchool.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> cadastroDeAluno(@RequestBody CadastroDeAlunoForm cadastroDeAlunoForm,
                                                 UriComponentsBuilder uriComponentsBuilder) {
        Aluno aluno = alunoService.cadastrar(cadastroDeAlunoForm);
        URI uri = uriComponentsBuilder.path("/pessoas").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(aluno);
    }
}
