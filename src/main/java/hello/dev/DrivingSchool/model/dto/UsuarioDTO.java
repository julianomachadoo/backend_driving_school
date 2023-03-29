package hello.dev.DrivingSchool.model.dto;

import hello.dev.DrivingSchool.model.DadosUsuario;
import hello.dev.DrivingSchool.model.Endereco;

import java.time.LocalDate;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private LocalDate dataDeNascimento;
    private LocalDate dataCadastro;
    private Endereco endereco;
    private String telefone;
    private String tipoUsuario;
    private String tipoCNH;

    public UsuarioDTO(DadosUsuario dadosUsuario) {
        this.id = dadosUsuario.getId();
        this.nome = dadosUsuario.getNome();
        this.email = dadosUsuario.getEmail();
        this.senha = dadosUsuario.getSenha();
        this.cpf = dadosUsuario.getCpf();
        this.dataDeNascimento = dadosUsuario.getDataDeNascimento();
        this.dataCadastro = dadosUsuario.getDataCadastro();
        this.endereco = dadosUsuario.getEndereco();
        this.telefone = dadosUsuario.getTelefone();
        this.tipoUsuario = dadosUsuario.getTipoUsuario().toString();
        this.tipoCNH = String.valueOf(dadosUsuario.getTipoCNH());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoCNH() {
        return tipoCNH;
    }

    public void setTipoCNH(String tipoCNH) {
        this.tipoCNH = tipoCNH;
    }
}
