
package Listas;

public interface IColaFilaEspera {
    public void agregarCola (int nroPaciente);
    public void sacarPrimero();
    public void borrarFin();
    public boolean esVacia();
    public Object alFrente();
    public int cantElementosCola();
    public void borrarElemento(Object nroPaciente);
    public boolean buscarelemento(Nodopaciente nroPaciente);
    public Nodopaciente obtenerElemento(Object nroPaciente);
    public String mostrar();
}
