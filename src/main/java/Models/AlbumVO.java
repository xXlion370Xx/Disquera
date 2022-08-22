package Models;

public class AlbumVO {

    private String idAlbum, nombreAlbum, anioPublicacion, idArtistaFK, estadoAlbum, generoAlbum ;

    public AlbumVO (String idAlbum, String nombreAlbum, String anioPublicacion, String idArtistaFK, String estadoAlbum, String generoAlbum) {
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.anioPublicacion = anioPublicacion;
        this.idArtistaFK = idArtistaFK;
        this.estadoAlbum = estadoAlbum;
        this.generoAlbum = generoAlbum;
    }

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getIdArtistaFK() {
        return idArtistaFK;
    }

    public void setIdArtistaFK(String idArtistaFK) {
        this.idArtistaFK = idArtistaFK;
    }

    public String getEstadoAlbum() {
        return estadoAlbum;
    }

    public void setEstadoAlbum(String estadoAlbum) {
        this.estadoAlbum = estadoAlbum;
    }

    public String getGeneroAlbum() {
        return generoAlbum;
    }

    public void setGeneroAlbum(String generoAlbum) {
        this.generoAlbum = generoAlbum;
    }
}
