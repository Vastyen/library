package biblioteca;

public class Prestamo {
    private Libro libro;
    private Usuario usuario; 
    private float fechaPrestamo;
    private float fechaDevolucion;
    private int cantDiasPrestamo;
    
    public Prestamo(Libro libro,String nombre, String rut, String genero, String carrra, String prestamo, int multa, float fechaPrestamo, float fechaDevolucion, int cantDiasPrestamo) {
        this.libro = libro;
        this.usuario = new Usuario(nombre,rut,genero,carrra, prestamo);
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.cantDiasPrestamo = cantDiasPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public float getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(float fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public float getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(float fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getCantDiasPrestamo() {
        return cantDiasPrestamo;
    }

    public void setCantDiasPrestamo(int cantDiasPrestamo) {
        this.cantDiasPrestamo = cantDiasPrestamo;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "libro=" + libro + ", usuario=" + usuario + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", cantDiasPrestamo=" + cantDiasPrestamo + '}';
    }

  
}
