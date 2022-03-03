
package Listas;

public interface IListahospital {
    
    public boolean esVacia();
    public void agregarInicio(String nombreHospital, int capacidad, int estrellas, int ranking);
    public void agregarFinal(String nombreHospital, int capacidad, int estrellas, int ranking);
//    public void agregarOrd();
    public void borrarInicio(); 
    public void borrarFin();
    public void borrarElemento(String nombreHospital);
    public boolean buscarelemento(String nombreHospital);    
    public Nodohospital obtenerElemento(String nombreHospital); 
    public void vaciar();
    public String mostrar();
    public String mostrar2();    
    public void mostrarREC(Nodohospital l); // implementar el mostrar recursivo    
    public int cantElementos(); 
    
}
