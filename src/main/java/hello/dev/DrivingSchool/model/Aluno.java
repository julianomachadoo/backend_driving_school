package hello.dev.DrivingSchool.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("aluno")
public class Aluno extends Usuario {

   @ElementCollection(targetClass = TipoCNH.class)
    @JoinTable(name = "tblTipoCNH", joinColumns = @JoinColumn(name = "cpfAluno"))
    @Column(name = "tipoCNH", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<TipoCNH> tipoCNHList = new ArrayList<>();

    public Aluno() {
    }

    public List<TipoCNH> getTipoCNHList() {
        return tipoCNHList;
    }

    public void addTipoCNH(TipoCNH tipoCNH) {
        tipoCNHList.add(tipoCNH);
    }

}
