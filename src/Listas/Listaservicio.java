
package Listas;

public class Listaservicio implements IListaservicio {
    Nodoservicio inicio;
    Nodoservicio fin;

    public Listaservicio() {
        this.inicio = null;
        this.fin = null;
    }

    public Nodoservicio getInicio() {
        return inicio;
    }

    public void setInicio(Nodoservicio inicio) {
        this.inicio = inicio;
    }

    public Nodoservicio getFin() {
        return fin;
    }

    public void setFin(Nodoservicio fin) {
        this.fin = fin;
    }
    
    
   
   
    //impmementacion de los mètodos de IListaDoble
    @Override
    public boolean esVacia() {
    return (this.inicio==null);
    }

    @Override
    public void agregarInicio(String nombreServicio) {
        Nodoservicio nuevoServicio = new Nodoservicio(nombreServicio);
        if (this.esVacia()){
            this.setInicio(nuevoServicio);
            this.setFin(nuevoServicio);
        }  
        else{
            nuevoServicio.setSiguiente(this.inicio);
            this.inicio.setAnterior(nuevoServicio);
            this.setInicio(nuevoServicio);
        }
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
            if (inicio==fin){
                this.inicio=null;
                this.fin=null;
            }  
            else{
            this.setInicio(this.inicio.getSiguiente());
            this.inicio.setAnterior(null);
            }
        }
        
        
    }

    @Override
    public void agregarFinal(String nombreServicio) {
        
        if (this.esVacia()){
            this.agregarInicio(nombreServicio);    
        }
        else{
            Nodoservicio nuevoServicio=new Nodoservicio(nombreServicio);
            this.fin.setSiguiente(nuevoServicio);
            nuevoServicio.setAnterior(fin);
            this.fin=nuevoServicio;
        }


    }

    @Override
    public void borrarFin() {
          this.fin=this.fin.getAnterior();
          this.fin.setSiguiente(null);


    }

    @Override
    public void vaciar() {
        this.inicio=null;
        this.fin=null;

    }

    
    @Override
    public String mostrar() {
        String ret = "";
        int contador = 0;
        if (this.esVacia()) {
            ret += "No existen servicios registrados";
        } else {
            Nodoservicio aux = this.inicio;
            while (aux != null) {
                contador = contador + 1;
                ret += " \n ";
                ret +=  contador + " - " + aux.getNombreServicio() ;
                aux = aux.getSiguiente();
            }
        }
        return ret;
    }
    
    
    
//    @Override
//    public String mostrar(){
//        String ret = "";
//        if (this.esVacia())
//            ret += "La lista esta vacia. ";
//        else  {
//            Nodoservicio aux=this.inicio;
//            while (aux!=null)  {
//                ret += aux.getNombreServicio() + " - ";
//                aux=aux.getSiguiente();
//            }
//        }
//        return ret;
//    }


    @Override
    public Nodoservicio buscarelemento(String nombreServicio) {
         Nodoservicio aux=this.inicio;
         while (aux!=null){
             if (aux.getNombreServicio().equals(nombreServicio))
                 return aux;
             
             aux=aux.getSiguiente();
             
         }
         return aux;
    }

    @Override
    public void borrarelemento(String nombreServicio) {
        Nodoservicio aux=this.buscarelemento(nombreServicio);
        if(!esVacia() && aux != null){
        if (aux == inicio){
            this.borrarInicio();
        }else if(aux == fin){  
            this.borrarFin();
        }else{
            aux.getAnterior().setSiguiente(aux.getSiguiente());
            aux.getSiguiente().setAnterior(aux.getAnterior());
        }
        }
    }   
       
    
    
    
    
    
}
