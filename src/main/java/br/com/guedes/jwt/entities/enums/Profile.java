package br.com.guedes.jwt.entities.enums;

public enum Profile {

    ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER");

    private int cod;
    private String description;

    Profile(int cod, String description) {}

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descricao) {
        this.description = descricao;
    }

    public static Profile toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (Profile x : Profile.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
