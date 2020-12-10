package biblioteca;

public class Usuario {
    private String nombre;
    private String rut;
    private String genero;
    private String carrera;
    private String prestamo;

    public Usuario(String nombre, String rut, String genero, String carrera,String prestamo) {
        this.nombre = nombre;
        this.rut = rut;
        this.genero = genero;
        this.carrera = carrera;
        this.prestamo = prestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if(Validation.validarGenero(genero)==true){
            this.genero = genero;
        }else{
            System.out.println("Error, dato no valido");
        }    
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Rut: " + rut + " - Genero: " + genero + " Carrera: " + carrera ;
    }


    
   
    
    
    
    
    
    
}
