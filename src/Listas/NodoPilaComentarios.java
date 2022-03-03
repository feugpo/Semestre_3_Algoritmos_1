
package Listas;

public class NodoPilaComentarios {
    private String comentario;
    private int puntaje;
    private NodoPilaComentarios siguiente;

    public NodoPilaComentarios(String comentario, int puntaje) {
        this.comentario = comentario;
        this.puntaje = puntaje;
        this.siguiente = null;
    }

    
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public NodoPilaComentarios getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPilaComentarios siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
