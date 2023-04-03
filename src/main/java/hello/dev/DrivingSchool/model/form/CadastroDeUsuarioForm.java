package hello.dev.DrivingSchool.model.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class CadastroDeUsuarioForm {

    @NotBlank
    @Length(max = 50)
    private final String nome;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email inválido!")
    private final String email;
    @NotBlank
    private final String senha;
    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido!")
//    @CPF
    private final String cpf;
    @NotNull
    private final String dataDeNascimento;
    @NotBlank
    @Pattern(regexp = "\\d{10,11}", message = "Telefone inválido")
    private final String telefone;
    @NotBlank
    private final String logradouro;
    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP inválido")
    private final String cep;
    @Pattern(regexp = "\\d{2,8}", message = "Numero inválido")
    private final String numero;
    private final String cidade;
    private final String estado;
    private final String complemento;
    private final String tipoUsuario;
    private final String tipoCNH;

    public CadastroDeUsuarioForm(String nome, String email, String senha, String cpf, String dataDeNascimento, String telefone, String logradouro, String cep, String numero, String cidade, String estado, String complemento, String tipoUsuario, String tipoCNH) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
        this.tipoUsuario = tipoUsuario;
        this.tipoCNH = tipoCNH;
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

    public String getEstado() {
        return estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getTipoCNH() {
        return tipoCNH;
    }
}
