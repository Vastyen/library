package biblioteca;

public class Devolucion extends Prestamo  {
    private int multa;
    public Devolucion(Libro libro, String nombre, String rut, String genero, String carrera,String prestamo, int multa, float fechaPrestamo, float fechaDevolucion, int cantDiasPrestamo) {
        super(libro, nombre, rut, genero,carrera, prestamo, multa, fechaPrestamo, fechaDevolucion, cantDiasPrestamo);
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }
    
}
