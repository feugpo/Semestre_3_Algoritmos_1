package Listas;

public class Nodohospital {
    private String nombreHospital;
    private int capacidad;
    private int estrellas;
    private int ranking;
    private Listaservicio listaServicios;
    private Listapaciente listaPacientes;
    private ColaEspera colaEspera;
    private PilaComentarios pilaComentarios;
    private Nodohospital siguiente; 
    private Nodohospital anterior;  

    public Nodohospital(String nombreHospital, int capacidad, int estrellas, int ranking) {
        this.nombreHospital = nombreHospital;
        this.capacidad = capacidad;
        this.estrellas = estrellas;
        this.ranking = ranking;
        this.listaServicios = new Listaservicio();
        this.listaPacientes = new Listapaciente();
        this.colaEspera = new ColaEspera();
        this.pilaComentarios = new PilaComentarios();
        this.siguiente = null;
        this.anterior = null;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
        
    }

    public Listaservicio getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(Listaservicio listaServicios) {
        this.listaServicios = listaServicios;
    }

    public Listapaciente getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(Listapaciente listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public ColaEspera getColaEspera() {
        return colaEspera;
    }

    public void setColaEspera(ColaEspera colaEspera) {
        this.colaEspera = colaEspera;
    }

    public PilaComentarios getPilaComentarios() {
        return pilaComentarios;
    }

    public void setPilaComentarios(PilaComentarios pilaComentarios) {
        this.pilaComentarios = pilaComentarios;
    }

    public Nodohospital getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodohospital siguiente) {
        this.siguiente = siguiente;
    }

    public Nodohospital getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodohospital anterior) {
        this.anterior = anterior;
    }
 
}
