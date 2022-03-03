
package Listas;

public class ColaEspera implements IColaFilaEspera{
    int cantElementos;
    Nodopaciente primero;
    Nodopaciente ultimo;

    // maximo es la cantidad de elementos que soportara la cola
    public ColaEspera() {
        this.cantElementos = 0;
        this.primero = null;
        this.ultimo = null;
    }


    public int getCantElementos() {
        return cantElementos;
    }

    public void setCantElementos(int cantElementos) {
        this.cantElementos = cantElementos;
    }

    public Nodopaciente getPrimero() {
        return primero;
    }

    public void setPrimero(Nodopaciente primero) {
        this.primero = primero;
    }

    public Nodopaciente getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodopaciente ultimo) {
        this.ultimo = ultimo;
    }
    
// implementacion de los metodos de ICola

    @Override
    public void agregarCola(int nroPaciente) {
        Nodopaciente paciente = new Nodopaciente(nroPaciente);
                 
        if (!this.esVacia()){
           this.ultimo.setSiguiente(paciente);
           this.ultimo = paciente;
        }else{               
             this.ultimo=paciente;
             this.primero=paciente;
             }
      this.cantElementos=this.cantElementos+1;      
    }

    @Override
    public void sacarPrimero() {
      if (!this.esVacia()){
          this.primero = this.primero.getSiguiente();
          this.cantElementos = this.cantElementos-1;
      }
    }
    
    @Override
    public void borrarFin() {
     if (!this.esVacia()){
            if (this.cantElementos==1){
                this.setPrimero(null);
                this.setUltimo(null);
            }else{
                this.ultimo.getAnterior().setSiguiente(null);
                this.ultimo=this.ultimo.getAnterior();          
            }
              this.cantElementos=this.cantElementos-1;  
            }              
    }
    
    @Override
    public boolean esVacia() {
        return (this.primero == null);       
    }

    @Override
    public Object alFrente() {
        if (!this.esVacia())
            return primero.getNroPaciente();
        else
            return ("La cola de Espera esta vacia ");
    }

    @Override
    public int cantElementosCola() {
        return this.cantElementos;
    }
    
    
@Override
    public void borrarElemento(Object nroPaciente) {
        Nodopaciente elementoaborrar= this.obtenerElemento(nroPaciente);
        if (elementoaborrar!=null){
            if (elementoaborrar == primero){
            this.sacarPrimero();
        }else if(elementoaborrar == ultimo){  
            this.borrarFin();
        }else{
            elementoaborrar.getAnterior().setSiguiente(elementoaborrar.getSiguiente());
            elementoaborrar.getSiguiente().setAnterior(elementoaborrar.getAnterior());
             }  
            this.cantElementos=this.cantElementos-1;
        }     
    }  
    
    @Override
    public boolean buscarelemento(Nodopaciente nroPaciente) {
        Nodopaciente aux= this.getPrimero();       
        while (aux!=null){
                if (aux.getNroPaciente()== nroPaciente){
                    return true;
                }
                aux=aux.getSiguiente();
            }
        return false;
    }

  @Override
    public Nodopaciente obtenerElemento(Object nroPaciente) {
        if (this.esVacia()){
            return null;
        }else
        {
            Nodopaciente aux=this.primero;
            while (aux!=null){
                if (aux.getNroPaciente().equals(nroPaciente)){
                    return aux;
                }
                aux=aux.getSiguiente();
            }
            return null;
        }
    }
    
    
    @Override
    public String mostrar(){
        Nodopaciente aux = this.getPrimero();
        String ret = " ";
        if (aux != null ){
            while (aux != null){
                ret += aux.getNroPaciente() + " \n ";
                aux=aux.getSiguiente();
            }
        }
        else
        {
            ret = "El hospital no tiene ningun paciente en Fila de Espera ";
        }
        return ret;
    }
    
    
    
}
