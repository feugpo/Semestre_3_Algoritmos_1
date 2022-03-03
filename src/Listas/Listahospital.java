
package Listas;

public class Listahospital implements IListahospital {
    Nodohospital primero;
    Nodohospital ultimo;
    int cantidad;

    public Listahospital() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad=0;
    }
    
    
    public Nodohospital getPrimero() {
        return primero;
    }

    public void setPrimero(Nodohospital primero) {
        this.primero = primero;
    }

    public Nodohospital getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodohospital ultimo) {
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
        return this.cantidad==0;
    }

    @Override
    public void agregarInicio(String nombreHospital, int capacidad, int estrellas, int ranking){
        Nodohospital nuevoHospital = new Nodohospital(nombreHospital, capacidad, estrellas, ranking);
        if (this.esVacia()){
            this.setPrimero(nuevoHospital);
            this.setUltimo(nuevoHospital);           
        }
        else{          
             nuevoHospital.setSiguiente(this.getPrimero());
             this.getPrimero().setAnterior(nuevoHospital);
             this.setPrimero(nuevoHospital);
            }       
          this.cantidad=this.cantidad +1;
        
        }

    @Override
    public void agregarFinal(String nombreHospital, int capacidad, int estrellas, int ranking) {
     Nodohospital nuevoHospital = new Nodohospital(nombreHospital, capacidad, estrellas, ranking);
        if (this.esVacia()){
            this.setPrimero(nuevoHospital);
            this.setUltimo(nuevoHospital);           
        }  
        else{
             this.getUltimo().setSiguiente(nuevoHospital);
             nuevoHospital.setAnterior(this.getUltimo());
             this.setUltimo(nuevoHospital);            
        }
        this.cantidad=this.cantidad+1;
    }


    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
            if (this.cantidad==1){
                this.setPrimero(null);
                this.setUltimo(null);
            }else{
                this.primero.getSiguiente().setAnterior(null);                       
                this.primero=this.primero.getSiguiente();                                       
            }
            this.cantidad=this.cantidad-1;
        }
    }

    @Override
    public void borrarFin() {
     if (!this.esVacia()){
            if (this.cantidad==1){
                this.setPrimero(null);
                this.setUltimo(null);
            }else{
                this.ultimo.getAnterior().setSiguiente(null);
                this.ultimo=this.ultimo.getAnterior();
             
            }
              this.cantidad=this.cantidad-1;  
            }        
        
    }

    @Override
    public void borrarElemento(String nombreHospital) {
        
        Nodohospital elementoaborrar = this.obtenerElemento(nombreHospital);
        if (elementoaborrar!=null){
            elementoaborrar.getAnterior().setSiguiente(elementoaborrar.getSiguiente());
            elementoaborrar.getSiguiente().setAnterior(elementoaborrar.getAnterior());
            this.cantidad=this.cantidad-1;
        }     
    }

    @Override
    public boolean buscarelemento(String nombreHospital) {
        Nodohospital aux= this.getPrimero();       
        while (aux!=null){
                if (aux.getNombreHospital().equals(nombreHospital)){
                    return true;
                }
                aux=aux.getSiguiente();
            }
        return false;
    }

    @Override
    public Nodohospital obtenerElemento(String nombreHospital) {
        if (this.esVacia()){
            return null;
        }else
        {
            Nodohospital aux = this.primero;
            while (aux!=null){
                if (aux.getNombreHospital().equals(nombreHospital)){
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
        this.cantidad=0;
    }

    @Override
    public String mostrar(){
        Nodohospital aux = this.getPrimero();
        String ret = " ";
        if (aux != null){
            while (aux != null){
                ret += aux.getNombreHospital() + " - " + aux.getEstrellas()+ " - " + aux.getRanking() + " \n ";
                aux=aux.getSiguiente();
            }
        }
        else
        {
            ret = "La ciudad no tiene ningun hospital ";
        }
        return ret;
    }
    
        @Override
        public String mostrar2(){
        Nodohospital aux = this.getPrimero();
        String ret = " ";
        if (aux != null){
            while (aux != null){
                ret += aux.getNombreHospital() + " - " + aux.getRanking() + " \n ";
                aux=aux.getSiguiente();
            }
        }
        else
        {
            ret = " La ciudad no tiene ningun hospital " + "\n";
        }
        return ret;
    }
    
   

   
    public void mostrarultimoalprimero() {
        Nodohospital aux=this.ultimo;
        if (aux!=null){
            while (aux!=null){
                System.out.print(aux.getNombreHospital()+ " - ");
                aux=aux.getAnterior();
            }
        }
        else
        {
            System.out.println("La lista esta vacia :");
        
        }
    }
      
    @Override
    public void mostrarREC(Nodohospital nodo) {
        
        if (nodo==null){
            System.out.print("");
        }
        else{
             System.out.print(nodo.getNombreHospital() + " ") ; 
            mostrarREC(nodo.getSiguiente());
          
        }

    }
    
    public void mostrarRECDSC(Nodohospital nodo) {
        
        if (nodo==null){
            System.out.print("");
        }
        else{
             
            mostrarREC(nodo.getSiguiente());
            System.out.print(nodo.getNombreHospital() + " ") ; 
          
        }

    }
    @Override
    public int cantElementos() {
        return this.cantidad;
    }
    
}
