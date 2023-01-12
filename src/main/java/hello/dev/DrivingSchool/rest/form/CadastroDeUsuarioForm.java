package hello.dev.DrivingSchool.rest.form;

import java.time.LocalDate;
import java.util.List;

public class CadastroDeUsuarioForm {

    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private LocalDate dataDeNascimento;
    private String telefone;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private String complemento;
    private String tipoUsuario;
    private List<String> tiposCNH;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCep() {
        return cep;
    }

    public Integer getNumero() {
        return Integer.parseInt(numero);
    }

    public String getCidade() {
        return cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public List<String> getTiposCNH() {
        return tiposCNH;
    }
}