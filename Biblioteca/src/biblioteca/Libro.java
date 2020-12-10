package biblioteca;

import java.io.File;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private int cantBiblioteca;
    //private int cantDisponible;
 //   private File imagen; //averiguar bien como agregar imagen 

    public Libro(String ISBN, String titulo, String autor, int cantBiblioteca) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.cantBiblioteca = cantBiblioteca;
       // this.cantDisponible = cantDisponible;
        //this.imagen = imagen;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public int getCantBiblioteca() {
        return cantBiblioteca;
    }

    public void setCantBiblioteca(int cantBiblioteca) {
        if(Validation.validarCantBiblioteca(cantBiblioteca)){
            this.cantBiblioteca = cantBiblioteca;
        }else{
            System.out.println("Error, dato no valido");
        }
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + "- Titulo: " + titulo + "- Autor: " + autor + "- CantBiblioteca: " + cantBiblioteca ;
    }
    
    


     
    
     
 
}
