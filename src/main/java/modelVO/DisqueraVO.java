package modelVO;

public class DisqueraVO {
    String idDisquera, nitDisquera, nombreDisquera, telefonoDisquera, direccionDisquera, estadoDisquera;

    public DisqueraVO(String idDisquera, String nitDisquera, String nombreDisquera, String telefonoDisquera, String direccionDisquera, String estadoDisquera) {
        this.idDisquera = idDisquera;
        this.nitDisquera = nitDisquera;
        this.nombreDisquera = nombreDisquera;
        this.telefonoDisquera = telefonoDisquera;
        this.direccionDisquera = direccionDisquera;
        this.estadoDisquera = estadoDisquera;
    }

    public DisqueraVO(String nitDisquera, String nombreDisquera, String telefonoDisquera, String direccionDisquera, String estadoDisquera) {
        this.nitDisquera = nitDisquera;
        this.nombreDisquera = nombreDisquera;
        this.telefonoDisquera = telefonoDisquera;
        this.direccionDisquera = direccionDisquera;
        this.estadoDisquera = estadoDisquera;
    }

    public DisqueraVO() {
    }

    public String getIdDisquera() {
        return idDisquera;
    }

    public void setIdDisquera(String idDisquera) {
        this.idDisquera = idDisquera;
    }

    public String getNitDisquera() {
        return nitDisquera;
    }

    public void setNitDisquera(String nitDisquera) {
        this.nitDisquera = nitDisquera;
    }

    public String getNombreDisquera() {
        return nombreDisquera;
    }

    public void setNombreDisquera(String nombreDisquera) {
        this.nombreDisquera = nombreDisquera;
    }

    public String getTelefonoDisquera() {
        return telefonoDisquera;
    }

    public void setTelefonoDisquera(String telefonoDisquera) {
        this.telefonoDisquera = telefonoDisquera;
    }

    public String getDireccionDisquera() {
        return direccionDisquera;
    }

    public void setDireccionDisquera(String direccionDisquera) {
        this.direccionDisquera = direccionDisquera;
    }

    public String getEstadoDisquera() {
        return estadoDisquera;
    }

    public void setEstadoDisquera(String estadoDisquera) {
        this.estadoDisquera = estadoDisquera;
    }
}
