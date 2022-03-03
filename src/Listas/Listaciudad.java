
package Listas;

public class Listaciudad implements IListaciudad {
    Nodociudad primero;
    Nodociudad ultimo;
        int cantidad;
        int contador = 0;

    public Listaciudad() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
    }
    
    

    public Nodociudad getPrimero() {
        return primero;
    }

    public void setPrimero(Nodociudad primero) {
        this.primero = primero;
    }

    public Nodociudad getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodociudad ultimo) {
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
    public void agregarInicio(String dato) {
        Nodociudad nuevo = new Nodociudad(dato);
        
        if (this.esVacia()){
            this.setPrimero(nuevo);
            this.setUltimo(nuevo); 
            
        }
        else{          
             nuevo.setSiguiente(this.getPrimero());
             //this.getPrimero().setAnterior(nuevo);
             this.setPrimero(nuevo);
            }       
          this.contador=this.contador +1;
        }

    @Override
    public void agregarFinal(String dato) {
     Nodociudad nuevo = new Nodociudad(dato);

        if (this.esVacia()){
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);           
        }  
        else{
             this.getUltimo().setSiguiente(nuevo);
             nuevo.setAnterior(this.getUltimo());
             this.setUltimo(nuevo);            
        }
        this.contador=this.contador+1;
    }

    @Override
    public void agregarOrd(String n) {
        
        if (this.esVacia() || n.compareTo(this.primero.getNombreCiudad()) < 0){
            this.agregarInicio(n);
        }else{
            if (n.compareTo(this.ultimo.getNombreCiudad()) > 0){
                this.agregarFinal(n);
            }else{
             Nodociudad nuevo=new Nodociudad(n);
             Nodociudad aux=this.getPrimero();
             while( n.compareTo(aux.getNombreCiudad()) < 0){
                 aux=aux.getSiguiente();
            }
             
             nuevo.setSiguiente(aux);
             aux.getAnterior().setSiguiente(nuevo);
             nuevo.setAnterior(aux.getAnterior());
             aux.setAnterior(nuevo);           
            }
               
        this.cantidad=this.cantidad+1;
                
        }


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
    public void borrarElemento(String nombreCiudad) {
        Nodociudad elementoaborrar= this.obtenerElemento(nombreCiudad);
        if (elementoaborrar!=null){
            elementoaborrar.getAnterior().setSiguiente(elementoaborrar.getSiguiente());
            elementoaborrar.getSiguiente().setAnterior(elementoaborrar.getAnterior());
            this.cantidad=this.cantidad-1;
        }     
    }

    @Override
    public boolean buscarelemento(String nombreCiudad) {
        Nodociudad aux= this.getPrimero();       
        while (aux!=null){
                if (aux.getNombreCiudad().equals(nombreCiudad)){
                    return true;
                }
                aux=aux.getSiguiente();
            }
        return false;
    }

    @Override
    public Nodociudad obtenerElemento(String nombreCiudad) {
        if (this.esVacia()){
            return null;
        }else
        {
            Nodociudad aux=this.primero;
            while (aux!=null){
                if (aux.getNombreCiudad().equals(nombreCiudad)){
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
    public void mostrar() {
        Nodociudad aux=this.getPrimero();
        if (aux!=null){
            while (aux!=null){
                System.out.print(aux.getNombreCiudad()+ " - ");
                aux=aux.getSiguiente();
            }
        }
        else
        {
            System.out.println("La lista esta vacia: ");
        
        }
    }
   
    public void mostrarultimoalprimero() {
        Nodociudad aux=this.ultimo;
        if (aux!=null){
            while (aux!=null){
                System.out.print(aux.getNombreCiudad()+ " - ");
                aux=aux.getAnterior();
            }
        }
        else
        {
            System.out.println("La lista esta vacia :");
        
        }
    }
      
   
    @Override
    public int cantElementos() {
        return this.contador;
    }
    
    
     @Override
    public int obtenerposicion(String Ciudad) {
        if (this.esVacia()){
            return -1;
        }else
        {
            int posicion=0;
            Nodociudad aux=this.primero;
            while (aux!=null){
                if (aux.getNombreCiudad().equals(Ciudad)){
                    return posicion;
                }
                posicion=posicion +1;
                aux=aux.getSiguiente();
            }
            return posicion ;       
        }
    }        
   
    @Override
    public String obtenerciudadenpos(int Ciudad) {
        if (this.esVacia()){
            return "";
        }else
        {
            int posicion=0;
            Nodociudad aux=this.primero;
            while (aux!=null){
                if (posicion == Ciudad){
                    return aux.getNombreCiudad();
                }
                posicion=posicion +1;
                aux=aux.getSiguiente();
            }
            return "" ;       
        }
    }     
}
