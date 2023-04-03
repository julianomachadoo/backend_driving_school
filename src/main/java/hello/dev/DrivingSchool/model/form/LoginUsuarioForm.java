package hello.dev.DrivingSchool.model.form;

public class LoginUsuarioForm {

    private final String email;
    private final String senha;

    public LoginUsuarioForm(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}
