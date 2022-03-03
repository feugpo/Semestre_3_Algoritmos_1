package Listas;

/**
 *
 * @author docenteFI
 */
public class Nodoservicio {
    private String nombreServicio;
    private Nodoservicio siguiente; 
    private Nodoservicio anterior;
    
    public Nodoservicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Nodoservicio getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodoservicio siguiente) {
        this.siguiente = siguiente;
    }

    public Nodoservicio getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodoservicio anterior) {
        this.anterior = anterior;
    }

  
    
    
}
