package br.com.guedes.jwt.dto;

public class CredenciaisDTO {

    private String email;
    private String password;

    public CredenciaisDTO() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
