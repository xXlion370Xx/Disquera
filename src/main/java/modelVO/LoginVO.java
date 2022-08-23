package modelVO;

public class LoginVO {
    //encapsular los datos a recibir
    private String idUsuario, nombreUsuario, passwordUsuario, rolUsuario, estadoUsuario;


    //creacion de constructor lleno y vacio
    public LoginVO(String nombreUsuario, String passwordUsuario, String rolUsuario, String estadoUsuario, String idUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.rolUsuario = rolUsuario;
        this.estadoUsuario = estadoUsuario;
        this.idUsuario = idUsuario;
    }

    public LoginVO(String idUsuario, String nombreUsuario, String passwordUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    public LoginVO(String idUsuario, String nombreUsuario, String passwordUsuario, String rolUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.rolUsuario = rolUsuario;
    }

    public LoginVO() {
    }

    //metodos Getter and Setter
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
