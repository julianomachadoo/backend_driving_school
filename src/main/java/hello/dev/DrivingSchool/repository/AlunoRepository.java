package hello.dev.DrivingSchool.repository;

import hello.dev.DrivingSchool.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String> {
}
