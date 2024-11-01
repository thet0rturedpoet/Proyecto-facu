public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private int anioPublicacion;
    private boolean prestado; // Nuevo campo

    public Libro(String titulo, String autor, String genero, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.prestado = false;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor; 
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public boolean isPrestado() {
        return prestado;
    }
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Género: " + genero + ", Año: " + anioPublicacion;
    }
}
