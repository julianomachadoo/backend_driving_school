package hello.dev.DrivingSchool.model.form;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class AtualizaUsuarioForm {

    @Length(max = 50)
    private final String nome;
    @Pattern(regexp = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email inválido!")
    private final String email;
    private final String senha;
    @Pattern(regexp = "\\d{10,11}", message = "Telefone inválido")
    private final String telefone;
    private final String logradouro;
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido")
    private final String cep;
    private final String numero;
    private final String cidade;
    private final String estado;
    private final String complemento;

    public AtualizaUsuarioForm(String nome, String email, String senha, String telefone, String logradouro, String cep, String numero, String cidade, String estado, String complemento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
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

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getComplemento() {
        return complemento;
    }

}
