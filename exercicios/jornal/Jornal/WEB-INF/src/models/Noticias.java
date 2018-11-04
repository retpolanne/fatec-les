package models;

public class Noticias {
    private String titulo;
    public Noticias () {
        
    }

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo () {
        return this.titulo;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}