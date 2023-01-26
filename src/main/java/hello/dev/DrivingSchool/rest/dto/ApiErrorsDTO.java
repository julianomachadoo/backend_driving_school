package hello.dev.DrivingSchool.rest.dto;

public class ApiErrorsDTO {

    private final String campo;
    private final String erro;

    public ApiErrorsDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
