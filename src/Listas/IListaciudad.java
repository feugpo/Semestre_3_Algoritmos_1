
package Listas;

public interface IListaciudad {
    public boolean esVacia();
    public void agregarInicio(String dato);
    public void agregarFinal(String dato);
    public void agregarOrd(String n);
    public void borrarInicio(); 
    public void borrarFin();
    public void borrarElemento(String n);
    public boolean buscarelemento(String dato);    
    public Nodociudad obtenerElemento(String n); 
    public void vaciar();
    public void mostrar();      
    public int cantElementos(); 
    public int obtenerposicion(String Ciudad);
    public String obtenerciudadenpos(int Ciudad);
}
