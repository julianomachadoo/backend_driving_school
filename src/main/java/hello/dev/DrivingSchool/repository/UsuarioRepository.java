package hello.dev.DrivingSchool.repository;

import hello.dev.DrivingSchool.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//    List<Usuario> findByNomeContainingIgnoreCase(String nome);
//    Optional<Usuario> findByCpf(String cpf);
//    List<Usuario> findByEmailContainingIgnoreCase(String email);
//    Optional<Usuario> findByEmail(String email);
//    @Query(value = "select * from tbl_usuario u where u.tipo_de_usuario = :tipoDeUsuario", nativeQuery = true)
//    List<Usuario> findByTipoDeUsuario(@Param("tipoDeUsuario") String tipoDeUsuario);
//    @Query(value = "select * from tbl_usuario u where u.data_cadastro BETWEEN :startDate AND :endDate", nativeQuery = true)
//    List<Usuario> encontrarPorData(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
