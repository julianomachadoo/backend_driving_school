package hello.dev.DrivingSchool.repository;

import hello.dev.DrivingSchool.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    List<Usuario> findByNomeContainingIgnoreCase(String nome);

    Optional<Usuario> findByCpf(String cpf);

    List<Usuario> findByEmailContainingIgnoreCase(String email);
}
