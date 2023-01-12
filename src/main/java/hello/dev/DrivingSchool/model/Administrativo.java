package hello.dev.DrivingSchool.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("administrativo")
public class Administrativo extends Usuario {

    public Administrativo() {
    }
}
