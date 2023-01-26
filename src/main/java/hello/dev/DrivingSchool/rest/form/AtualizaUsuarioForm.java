package hello.dev.DrivingSchool.rest.form;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class AtualizaUsuarioForm {

    @Length(max = 50)
    private String nome;
    @Pattern(regexp = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email inválido!")
    private String email;
    private String senha;
    @Pattern(regexp = "\\d{10,11}", message = "Telefone inválido")
    private String telefone;
    private String logradouro;
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido")
    private String cep;
    private String numero;
    private String cidade;
    private String complemento;

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

    public String getComplemento() {
        return complemento;
    }

}
