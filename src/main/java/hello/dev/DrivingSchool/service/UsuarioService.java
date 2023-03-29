package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.exceptions.DadosNaoEncontradosException;
import hello.dev.DrivingSchool.model.*;
import hello.dev.DrivingSchool.model.form.AtualizaUsuarioForm;
import hello.dev.DrivingSchool.model.form.CadastroDeUsuarioForm;
import hello.dev.DrivingSchool.repository.DadosUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class UsuarioService {

    @Autowired
    private DadosUsuarioRepository dadosUsuarioRepository;

    public void cadastrar(CadastroDeUsuarioForm cadastroDeUsuarioForm) {
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
        dadosUsuarioRepository.save(dadosUsuario);
    }

    @Transactional
    public void atualizarUsuario(AtualizaUsuarioForm atualizaUsuarioForm, Long id) {
        Optional<DadosUsuario> dadosUsuario = dadosUsuarioRepository.findById(1l);
        if (dadosUsuario.isEmpty()) throw new DadosNaoEncontradosException("Usuario não encontrado");
        if (atualizaUsuarioForm.getNome() != null) dadosUsuario.get().setNome(atualizaUsuarioForm.getNome());
        if (atualizaUsuarioForm.getEmail() != null) dadosUsuario.get().setEmail(atualizaUsuarioForm.getEmail());
        if (atualizaUsuarioForm.getSenha() != null) dadosUsuario.get().setSenha(atualizaUsuarioForm.getSenha());
        if (atualizaUsuarioForm.getTelefone() != null) dadosUsuario.get().setTelefone(atualizaUsuarioForm.getTelefone());
        if (atualizaUsuarioForm.getLogradouro() != null) dadosUsuario.get().getEndereco().setLogradouro(atualizaUsuarioForm.getLogradouro());
        if (atualizaUsuarioForm.getCep() != null) dadosUsuario.get().getEndereco().setCEP(atualizaUsuarioForm.getCep());
        if (atualizaUsuarioForm.getNumero() != null) dadosUsuario.get().getEndereco().setNumero(parseInt(atualizaUsuarioForm.getNumero()));
        if (atualizaUsuarioForm.getCidade() != null) dadosUsuario.get().getEndereco().setCidade(atualizaUsuarioForm.getCidade());
        if (atualizaUsuarioForm.getEstado() != null) dadosUsuario.get().getEndereco().setEstado(atualizaUsuarioForm.getEstado());
        if (atualizaUsuarioForm.getComplemento() != null) dadosUsuario.get().getEndereco().setComplemento(atualizaUsuarioForm.getComplemento());
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

