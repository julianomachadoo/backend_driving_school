package hello.dev.DrivingSchool.repository;

import hello.dev.DrivingSchool.model.DadosUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosUsuarioRepository extends JpaRepository<DadosUsuario, Long> {

}
