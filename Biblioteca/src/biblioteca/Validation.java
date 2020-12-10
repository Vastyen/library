package biblioteca;

public class Validation {
    
    //public static boolean validarRutUnico(String rut){   
    //}
    
    //public static boolean validarFormatoRut (){ 
   // }
    
    public static boolean validarGenero(String genero){
        if (genero=="Masculino" || genero=="Femenino"){
            return true;
        }else{
            return false;
        }
    }
   // public static boolean validarEstadoUsuario (){   
    //}
    
   // public static boolean validarExistenciaRut(String rut){
    //}
    
    //public static boolean validarIsbnUnico(String ISBN){
    //}
    
    public static boolean validarCantBiblioteca (int cantBiblioteca){
        if (cantBiblioteca>0)
            return true;
        else
            return false;
    }
    
    public static boolean validarCantDisponible (int cantDisponible,int cantBiblioteca){
        if (cantDisponible>0 && cantDisponible<=cantBiblioteca)
            return true;
        else
            return false;
    }
    
   //public static boolean validarExistenciaIsbn (String ISBN){  
    //}
    
    //public static boolean validarDiasPrestamo (int cantDiasPrestamo){     
   // }
   
}
