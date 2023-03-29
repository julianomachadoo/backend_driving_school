package hello.dev.DrivingSchool.service;

import hello.dev.DrivingSchool.exceptions.DadosNaoEncontradosException;
import hello.dev.DrivingSchool.infra.SpecificationUsuario;
import hello.dev.DrivingSchool.model.DadosUsuario;
import hello.dev.DrivingSchool.model.Endereco;
import hello.dev.DrivingSchool.model.TipoCNH;
import hello.dev.DrivingSchool.model.TipoUsuario;
import hello.dev.DrivingSchool.model.dto.UsuarioDTO;
import hello.dev.DrivingSchool.model.form.AtualizaUsuarioForm;
import hello.dev.DrivingSchool.model.form.CadastroDeUsuarioForm;
import hello.dev.DrivingSchool.repository.DadosUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class UsuarioService {

    @Autowired
    private DadosUsuarioRepository dadosUsuarioRepository;

    public List<UsuarioDTO> buscarTodos() {
        return dadosUsuarioRepository.findAll().stream().map(UsuarioDTO::new).toList();
    }

    public List<UsuarioDTO> buscarPorNomeCpfEmailTipoUsuario(String nome, String cpf, String email, String tipoUsuario, String dataInicio, String dataFim) {
        TipoUsuario tipoUsuarioUpperCase;
        if (tipoUsuario == null) tipoUsuarioUpperCase = null;
        else tipoUsuarioUpperCase = TipoUsuario.valueOf(tipoUsuario.toUpperCase());

        return dadosUsuarioRepository
                .findAll(Specification.where(SpecificationUsuario.nome(nome))
                        .or(SpecificationUsuario.cpf(cpf))
                        .or(SpecificationUsuario.email(email))
                        .or(SpecificationUsuario.tipoUsuario(tipoUsuarioUpperCase))
                        .or(SpecificationUsuario.dataCadastro(converterData(dataInicio), converterData(dataFim)))
                ).stream().map(UsuarioDTO::new).toList();
    }

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

    public void atualizarUsuario(AtualizaUsuarioForm atualizaUsuarioForm, Long id) {
        Optional<DadosUsuario> dadosUsuario = dadosUsuarioRepository.findById(id);
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

        public void deletarUsuario(Long id) {
        try {
            dadosUsuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DadosNaoEncontradosException("Usuario não encontrado");
        }
    }

    private TipoCNH cadastroCNH(String tipoCNH) {
        if (tipoCNH == null) return null;
        return TipoCNH.valueOf(tipoCNH.toUpperCase());
    }

    protected LocalDate converterData (String data) {
        if (data == null) return null;
        String[] split = data.split("-");
        return LocalDate.of(parseInt(split[2]), parseInt(split[1]), parseInt(split[0]));
    }
}

