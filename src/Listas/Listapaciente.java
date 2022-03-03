
package Listas;

public class Listapaciente implements IListapaciente {
    Nodopaciente primero;
    Nodopaciente ultimo;
    int cantidad ;
    int contador = 0;
    

    public Listapaciente() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

    @Override
    public boolean esVacia() {
        return this.contador == 0;
    }

    @Override
    public void agregarInicio(Object nroPaciente) {
        Nodopaciente nuevoPaciente = new Nodopaciente(nroPaciente);
        if (this.esVacia()){
            this.setPrimero(nuevoPaciente);
            this.setUltimo(nuevoPaciente);           
        }
        else {          
             nuevoPaciente.setSiguiente(this.getPrimero());
            // this.getPrimero().setAnterior(nuevoPaciente);
             this.setPrimero(nuevoPaciente);
            }       
          this.contador=this.contador +1;
        
        }

    @Override
    public void agregarFinal(Object nroPaciente) {
     Nodopaciente nuevoPaciente = new Nodopaciente(nroPaciente);
        if (this.esVacia()){
            this.setPrimero(nuevoPaciente);
            this.setUltimo(nuevoPaciente);           
        }  
        else{
             this.getUltimo().setSiguiente(nuevoPaciente);
             nuevoPaciente.setAnterior(this.getUltimo());
             this.setUltimo(nuevoPaciente);            
        }
        this.contador=this.contador+1;
    }

//    @Override
//    public void agregarOrd(int n) {
//        
//        if (this.esVacia() || n<this.primero.getDato()){
//            this.agregarInicio(n);
//        }else{
//            if (n>this.ultimo.getDato()){
//                this.agregarFinal(n);
//            }else{
//             Nodopaciente nuevo=new Nodopaciente(n);
//             Nodopaciente aux=this.getPrimero();
//             while( n>aux.getDato()){
//                aux=aux.getSiguiente();
//            }
//             nuevo.setSiguiente(aux);
//             aux.getAnterior().setSiguiente(nuevo);
//             nuevo.setAnterior(aux.getAnterior());
//             aux.setAnterior(nuevo);           
//            }
//               
//        this.cantidad=this.cantidad+1;
//                
//        }
//
//
//    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
            if (this.contador==1){
                this.setPrimero(null);
                this.setUltimo(null);
            }else{
                this.primero.getSiguiente().setAnterior(null);                       
                this.primero=this.primero.getSiguiente();                                       
            }
            this.contador=this.contador-1;
        }
    }

    @Override
    public void borrarFin() {
     if (!this.esVacia()){
            if (this.contador==1){
                this.setPrimero(null);
                this.setUltimo(null);
            }else{
                this.ultimo.getAnterior().setSiguiente(null);
                this.ultimo=this.ultimo.getAnterior();          
            }
              this.contador=this.contador-1;  
            }              
    }

    @Override
    public void borrarElemento(Object nroPaciente) {
        Nodopaciente elementoaborrar= this.obtenerElemento(nroPaciente);
        if (elementoaborrar!=null){
            if (elementoaborrar == primero){
            this.borrarInicio();
        }else if(elementoaborrar == ultimo){  
            this.borrarFin();
        }else{
            elementoaborrar.getAnterior().setSiguiente(elementoaborrar.getSiguiente());
            elementoaborrar.getSiguiente().setAnterior(elementoaborrar.getAnterior());
             }  
            this.contador=this.contador-1;
        }     
    }  

    @Override
    public boolean buscarelemento(Object nroPaciente) {
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
    public void vaciar() {
        this.setPrimero(null);
        this.setUltimo(null);
        this.contador=0;
    }

    @Override
    public String mostrar() {
        Nodopaciente aux=this.getPrimero();
        String ret = "";
        if (aux!=null){
            while (aux != null){
                ret += aux.getNroPaciente() + " \n ";
                aux = aux.getSiguiente();
            }
        }
        else
        {
            ret = ("La lista esta vacia :");
        
        }
        return ret;
    }
   
    public void mostrarultimoalprimero() {
        Nodopaciente aux=this.ultimo;
        if (aux!=null){
            while (aux!=null){
                System.out.print(aux.getNroPaciente()+ " - ");
                aux=aux.getAnterior();
            }
        }
        else
        {
            System.out.println("La lista esta vacia :");
        
        }
    }
      
    @Override
    public void mostrarREC(Nodopaciente nodo) {
        
        if (nodo==null){
            System.out.print("");
        }
        else{
            System.out.print(nodo.getNroPaciente() + " ") ; 
            mostrarREC(nodo.getSiguiente());
          
        }

    }
    
    public void mostrarRECDSC(Nodopaciente nodo) {
        
        if (nodo==null){
            System.out.print("");
        }
        else{
             
            mostrarREC(nodo.getSiguiente());
            System.out.print(nodo.getNroPaciente() + " ") ; 
          
        }

    }
    @Override
    public int cantElementos() {
        return this.contador;
    }
    
}
