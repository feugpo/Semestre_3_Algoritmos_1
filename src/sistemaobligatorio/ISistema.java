
package sistemaobligatorio;

public interface ISistema {
   public Retorno crearSistemaIngreso(int cantCiudades);
   public Retorno destruirSistemaIngreso();
   public Retorno registrarCiudad(String Ciudad);
   public Retorno RegistrarHospital(String Ciudad, String Nombre, int Estrellas, int Capacidad, int ranking);
   public Retorno ingresarServicio(String Ciudad, String Hospital, String Servicio);
   public Retorno borrarServicio(String Ciudad, String Hospital, String Servicio);
   public Retorno ingresarComentario(String Ciudad, String Hospital, String Comentario, int Ranking);
   public Retorno realizarIngreso(int Paciente, String Ciudad, String Hospital);
   public Retorno cancelarIngreso(int Paciente, String Ciudad, String Hospital);
   public Retorno trasladarPaciente(int Paciente, String CiudadOrigen,String HospitalOrigen,String CiudadDestino, String HospitalDestino);
   public Retorno listarServicios(String Ciudad, String Hospital);
   public Retorno listarHospitalesCiudad(String Ciudad);
   public Retorno listarHospitalesRanking();
   public Retorno listarComentarios(String Ciudad, String Hospital);
   public Retorno listarEspera(String Ciudad, String Hospital);
   public Retorno cargoDistancia(int[][] Ciudades, int origen, int destino, int distancia);
   public Retorno BuscarCamino( int [][] M, String origen, String destino);
   public Retorno listarPacientesXHospital(String Ciudad, String Hospital);

  
    
}
