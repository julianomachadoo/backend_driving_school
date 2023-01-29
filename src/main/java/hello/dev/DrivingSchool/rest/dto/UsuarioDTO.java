package hello.dev.DrivingSchool.rest.dto;

import hello.dev.DrivingSchool.model.Endereco;
import hello.dev.DrivingSchool.model.TipoCNH;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
    private Set<TipoCNH> tipoCNHList = new HashSet<>();

    public UsuarioDTO(Long id, String nome, String email, String senha, String cpf, LocalDate dataDeNascimento, LocalDate dataCadastro, Endereco endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
        this.telefone = telefone;
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

    public Set<TipoCNH> getTipoCNHList() {
        return tipoCNHList;
    }
}
