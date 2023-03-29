package hello.dev.DrivingSchool.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String logradouro;
    private String CEP;
    private Integer numero;
    private String cidade;
    private String estado;
    private String complemento;

    public Endereco() {
    }

    public Endereco(String logradouro, String CEP, Integer numero, String cidade, String estado, String complemento) {
        this.logradouro = logradouro;
        this.CEP = CEP;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
