package hello.dev.DrivingSchool.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity @Table(name = "tbl_dados_usuario")
public class DadosUsuario extends Usuario {

    private String nome;
    private String cpf;
    private LocalDate dataDeNascimento;
    private LocalDate dataCadastro = LocalDate.now();
    @Embedded
    private Endereco endereco;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private TipoCNH tipoCNH;

    public DadosUsuario() {
    }

    public DadosUsuario(String email, String senha, TipoUsuario tipoUsuario, String nome, String cpf, LocalDate dataDeNascimento, Endereco endereco, String telefone, TipoCNH tipoCNH) {
        super(email, senha, tipoUsuario);
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoCNH = tipoCNH;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public TipoCNH getTipoCNH() {
        return tipoCNH;
    }

    public void setTipoCNH(TipoCNH tipoCNH) {
        this.tipoCNH = tipoCNH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DadosUsuario that = (DadosUsuario) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpf);
    }
}
