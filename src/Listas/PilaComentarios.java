package Listas;
public class PilaComentarios implements IPilaComentarios {
       private NodoPilaComentarios tope;
       private int cantElementos = 0;

    public PilaComentarios() {
        this.tope = null;
    }

    public NodoPilaComentarios getTope() {
        return tope;
    }

    public void setTope(NodoPilaComentarios tope) {
        this.tope = tope;
    }

    public int getCantElementos() {
        return cantElementos;
    }

    public void setCantElementos(int cantElementos) {
        this.cantElementos = cantElementos;
    }
       
    @Override
    public void push(String comentario, int puntaje) {
        NodoPilaComentarios nuevo= new NodoPilaComentarios(comentario, puntaje);
      
           nuevo.setSiguiente(tope);
           this.tope=nuevo;  
           this.cantElementos ++;
    }

    @Override
    public void pop() {               
        if(!isEmpty()){
            NodoPilaComentarios aux = this.tope;
            this.tope = this.tope.getSiguiente();
            aux.setSiguiente(null);
            this.cantElementos --;
        }

    }

    @Override
    public boolean isEmpty() {
          return (this.tope == null);                                      
    }

    // Post.: Retorna la cantidad de elementos que tienen el stack.
    @Override
    public int tamanioPila() {
        return this.getCantElementos();
    }

    // Pre.: El stack no es vacío.
   //Post.: Retorna el elemento ubicado en el tope del stack
    @Override
    public int topePila() {
          return tope.getPuntaje();
    }
    
    
    @Override
    public String mostrar(){
        NodoPilaComentarios aux = this.getTope();
        String ret = " ";
        if (aux != null){
            while (aux != null){
                ret += aux.getComentario()+ " - " + aux.getPuntaje() + " \n ";
                aux=aux.getSiguiente();
            }
        }
        else
        {
            ret = "La Pila no tiene ningun comentario ";
        }
        return ret;
    }
    
    
    
    
    @Override
    public int CalcularPromedio() {        
        int total = 0;
        int promedio = 0;
        int largo = 0;
   
	if (!isEmpty()){
            NodoPilaComentarios aux = this.tope;
          
		while (aux != null && largo != this.cantElementos){
			total += aux.getPuntaje();
			aux = aux.getSiguiente();
                        largo = largo+1;
		}
                promedio = total / largo;
                  	
        }  
        return promedio;          
    }


}











