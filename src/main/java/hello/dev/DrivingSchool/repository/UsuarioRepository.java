package hello.dev.DrivingSchool.repository;

import hello.dev.DrivingSchool.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
    Optional<Usuario> findByCpf(String cpf);
    List<Usuario> findByEmailContainingIgnoreCase(String email);
    @Query(value = "select u from Usuario u where u.dataCadastro BETWEEN :startDate AND :endDate")
    List<Usuario> encontrarPorData(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
