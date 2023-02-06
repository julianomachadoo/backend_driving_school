package hello.dev.DrivingSchool.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("instrutor")
public class Instrutor extends Usuario {
    public Instrutor() {
    }
}
