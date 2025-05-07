package model;

public class Usuario {
    private String nickname;  // Nombre de usuario para iniciar sesión
    private String contraseña; // Contraseña del usuario

    // Constructor que inicializa los atributos del usuario
    public Usuario(String nickname, String contraseña) {
        super();
        this.nickname = nickname;
        this.contraseña = contraseña;
    }

    // Métodos getter y setter para acceder y modificar los atributos

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
