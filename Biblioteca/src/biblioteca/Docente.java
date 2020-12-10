package biblioteca;

public class Docente extends Usuario {
    private String profesion;
    private String grado;
    
    public Docente(String nombre, String rut, String genero, String carrera,String prestamo, String profesion, String grado ){
        super(nombre,rut,genero,carrera,prestamo);

        this.profesion = profesion;
        this.grado = grado;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " - Rut: " + getRut() + " - Genero: " + getGenero() + " - Carrera: " + getCarrera()+ " - Profesion: " + getProfesion()+ " - Grado: " + getGrado();
        
    }
    
   
}
