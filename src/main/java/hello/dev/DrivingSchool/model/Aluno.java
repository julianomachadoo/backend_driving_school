package hello.dev.DrivingSchool.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Aluno {

    private String nome;
    private String email;
    private String senha;
    @Id
    private String cpf;
    private LocalDate dataDeNascimento;
    private LocalDate dataCadastro = LocalDate.now();
    @Embedded
    private Endereco endereco;
    private String telefone;

    @ElementCollection(targetClass = TipoCNH.class)
    @JoinTable(name = "tblTipoCNH", joinColumns = @JoinColumn(name = "cpfAluno"))
    @Column(name = "tipoCNH", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<TipoCNH> tipoCNHList = new ArrayList<>();

    public Aluno() {
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

    public List<TipoCNH> getTipoCNHList() {
        return tipoCNHList;
    }

    public void addTipoCNH(TipoCNH tipoCNH) {
        tipoCNHList.add(tipoCNH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(cpf, aluno.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
