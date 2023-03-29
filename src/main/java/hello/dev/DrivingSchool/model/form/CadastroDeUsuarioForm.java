package hello.dev.DrivingSchool.model.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class CadastroDeUsuarioForm {

    @NotBlank
    @Length(max = 50)
    private String nome;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email inválido!")
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido!")
//    @CPF
    private String cpf;
    @NotNull
    private String dataDeNascimento;
    @NotBlank
    @Pattern(regexp = "\\d{10,11}", message = "Telefone inválido")
    private String telefone;
    @NotBlank
    private String logradouro;
    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido")
    private String cep;
    @Pattern(regexp = "\\d{2,8}", message = "Numero inválido")
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

    public String getDataDeNascimento() {
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
