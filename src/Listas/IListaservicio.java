
package Listas;

public interface IListaservicio {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(String nombreServicio);
    public void borrarInicio();
    public void agregarFinal(String nombreServicio);
    public void borrarFin();
    public void vaciar();
    public String mostrar();
    public Nodoservicio buscarelemento(String nombreServicio);
    public void borrarelemento(String nombreServicio);

}
