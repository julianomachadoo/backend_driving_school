package hello.dev.DrivingSchool.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("aluno")
public class Aluno extends Usuario {
    @ElementCollection(targetClass = TipoCNH.class)
    @JoinTable(name = "tblTipoCNH", joinColumns = @JoinColumn(name = "idAluno"))
    @Column(name = "tipoCNH", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<TipoCNH> tipoCNHList = new HashSet<>();

    public Aluno() {
    }

    public Set<TipoCNH> getTipoCNHList() {
        return tipoCNHList;
    }

    public void addTipoCNH(TipoCNH tipoCNH) {
        tipoCNHList.add(tipoCNH);
    }
}
