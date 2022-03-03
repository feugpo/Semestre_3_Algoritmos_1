package Listas;

public interface IPilaComentarios {
    
   public void push(String comentario, int puntaje);
   public void pop();
   public boolean isEmpty();
   public int tamanioPila();
   public int topePila();
   public String mostrar();
   public int CalcularPromedio();   
   
}
