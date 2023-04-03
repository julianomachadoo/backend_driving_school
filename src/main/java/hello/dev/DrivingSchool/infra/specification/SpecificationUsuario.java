package hello.dev.DrivingSchool.infra.specification;

import hello.dev.DrivingSchool.model.DadosUsuario;
import hello.dev.DrivingSchool.model.TipoUsuario;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class SpecificationUsuario {

    public static Specification<DadosUsuario> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (nome == null) return criteriaBuilder.disjunction();
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + nome + "%");
        };
    }

    public static Specification<DadosUsuario> cpf(String cpf) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (cpf == null) return criteriaBuilder.disjunction();
            return criteriaBuilder.equal(root.get("cpf"), cpf);
        };
    }

    public static Specification<DadosUsuario> email(String email) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (email == null) return criteriaBuilder.disjunction();
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + email + "%");
        };
    }

    public static Specification<DadosUsuario> tipoUsuario(TipoUsuario tipoUsuario) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (tipoUsuario == null) return criteriaBuilder.disjunction();
            return criteriaBuilder.equal((root.get("tipoUsuario")), tipoUsuario);
        };
    }

    public static Specification<DadosUsuario> dataCadastro(LocalDate dataInicio, LocalDate dataFinal) {
        if (dataFinal == null) dataFinal = LocalDate.now();
        LocalDate finalDataFinal = dataFinal;
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (dataInicio == null) return criteriaBuilder.disjunction();
            return criteriaBuilder.between(root.get("dataCadastro"), dataInicio, finalDataFinal);
        };
    }
}
