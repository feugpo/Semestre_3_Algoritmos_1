
package Listas;

public interface IListapaciente {
    public boolean esVacia();
    public void agregarInicio(Object dato);
    public void agregarFinal(Object dato);
//    public void agregarOrd(int n);
    public void borrarInicio(); 
    public void borrarFin();
    public void borrarElemento(Object n);
    public boolean buscarelemento(Object dato);    
    public Nodopaciente obtenerElemento(Object n); 
    public void vaciar();
    public String mostrar();    
    public void mostrarREC(Nodopaciente l); // implementar el mostrar recursivo    
    public int cantElementos();       
}
