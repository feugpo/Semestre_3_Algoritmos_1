
package Listas;

public class Nodopaciente {
    private Object nroPaciente;
    private Nodopaciente siguiente; 
    private Nodopaciente anterior;  

    public Nodopaciente(Object nroPaciente) {
        this.nroPaciente = nroPaciente;
        this.siguiente = null;
        this.anterior = null;
    }

    public Object getNroPaciente() {
        return nroPaciente;
    }

    public void setNroPaciente(Object nroPaciente) {
        this.nroPaciente = nroPaciente;
    }

    public Nodopaciente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodopaciente siguiente) {
        this.siguiente = siguiente;
    }

    public Nodopaciente getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodopaciente anterior) {
        this.anterior = anterior;
    }
     
}
