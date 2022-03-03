
package Listas;

public class Nodociudad {
    private String nombreCiudad;
    private Listahospital listaHospitales;
    private Nodociudad siguiente; 
    private Nodociudad anterior;  

    public Nodociudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
        this.listaHospitales = new Listahospital();
        this.siguiente = null;
        this.anterior = null;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Listahospital getListaHospitales() {
        return listaHospitales;
    }

    public void setListaHospitales(Listahospital listaHospitales) {
        this.listaHospitales = listaHospitales;
    }

    public Nodociudad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodociudad siguiente) {
        this.siguiente = siguiente;
    }

    public Nodociudad getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodociudad anterior) {
        this.anterior = anterior;
    }
   
    
}
