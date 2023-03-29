package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.model.*;
import hello.dev.DrivingSchool.model.form.CadastroDeUsuarioForm;
import hello.dev.DrivingSchool.repository.DadosUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static java.lang.Integer.parseInt;

@Service
public class UsuarioService {

    @Autowired
    private DadosUsuarioRepository dadosUsuarioRepository;

    public Usuario cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm) {
        DadosUsuario dadosUsuario = new DadosUsuario(
                cadastroDeUsuarioForm.getEmail(),
                cadastroDeUsuarioForm.getSenha(),
                TipoUsuario.valueOf(cadastroDeUsuarioForm.getTipoUsuario().toUpperCase()),
                cadastroDeUsuarioForm.getNome(),
                cadastroDeUsuarioForm.getCpf(),
                converterData(cadastroDeUsuarioForm.getDataDeNascimento()),
                new Endereco(cadastroDeUsuarioForm.getLogradouro(),
                        cadastroDeUsuarioForm.getCep(),
                        cadastroDeUsuarioForm.getNumero(),
                        cadastroDeUsuarioForm.getCidade(),
                        cadastroDeUsuarioForm.getEstado(),
                        cadastroDeUsuarioForm.getComplemento()),
                cadastroDeUsuarioForm.getTelefone(),
                cadastroCNH(cadastroDeUsuarioForm.getTipoCNH())
        );
        return dadosUsuarioRepository.save(dadosUsuario);
    }

    private TipoCNH cadastroCNH(String tipoCNH) {
        if (tipoCNH == null) return null;
        return TipoCNH.valueOf(tipoCNH.toUpperCase());
    }

    protected LocalDate converterData (String data) {
        String[] split = data.split("-");
        return LocalDate.of(parseInt(split[2]), parseInt(split[1]), parseInt(split[0]));
    }
}

