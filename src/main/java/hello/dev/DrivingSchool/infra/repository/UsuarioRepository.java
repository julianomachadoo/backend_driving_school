package hello.dev.DrivingSchool.infra.repository;

import hello.dev.DrivingSchool.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
