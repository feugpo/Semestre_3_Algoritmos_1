
package sistemaobligatorio;

public class SistemaObligatorio {

    public static void main(String[] args) {
        Prueba p = new Prueba();
        Sistema s = new Sistema();
        
        //pruebaObligatorio(s, p); 
        prueba1(s, p);
    }
    
    
    public static void prueba1(Sistema s, Prueba p){
    // agregar el juego de prueba aqui
   System.out.println("_____________________________________________________");
   System.out.println("AGREGAMOS LAS CIUDADES DEL SISTEMA");
   System.out.println("_____________________________________________________");
    
    p.ver(s.crearSistemaIngreso(6).resultado,Retorno.Resultado.OK," comentario");
    p.ver(s.registrarCiudad("MVD").resultado, Retorno.Resultado.OK, "Se agrego MCD"); 
    p.ver(s.registrarCiudad("SP").resultado, Retorno.Resultado.OK, "Se agrego SP");
    p.ver(s.registrarCiudad("RIO").resultado, Retorno.Resultado.OK, "Se agrego RIO");    
    p.ver(s.registrarCiudad("NYC").resultado, Retorno.Resultado.OK, "Se agrego NYC");
    p.ver(s.registrarCiudad("BA").resultado, Retorno.Resultado.OK, "Se agrego SP");
    p.ver(s.registrarCiudad("MAD").resultado, Retorno.Resultado.OK, "Se agrego RIO");    
    
    System.out.println("_____________________________________________________");
    System.out.println("PROBAMOS AGREGAR CIUDAD FUERA DE LIMITE O REPETIDAS");
    System.out.println("_____________________________________________________");
     
    p.ver(s.registrarCiudad("LON").resultado, Retorno.Resultado.ERROR, "Se intento agregar LON que sobrepasa el limite previsto");    
    p.ver(s.registrarCiudad("NYC").resultado, Retorno.Resultado.ERROR, "Se intento agregar NYC que supera el limite de ciudades");
    
    System.out.println("_____________________________________________________");
    System.out.println("AGREGAMOS HOSPITALES A LA CIUDAD MVD");
    System.out.println("_____________________________________________________");
           
    p.ver(s.RegistrarHospital("MVD", "H1", 1, 5, 0).resultado, Retorno.Resultado.OK,"se agrego h1 en MVD");
    p.ver(s.RegistrarHospital("MVD", "H2", 1, 5, 0).resultado, Retorno.Resultado.OK,"se agrego h2 en MVD");
    p.ver(s.RegistrarHospital("MVD", "H3", 1, 5, 0).resultado, Retorno.Resultado.OK,"se agrego h3 en MVD ");
    p.ver(s.RegistrarHospital("MVD", "H4", 1, 5, 0).resultado, Retorno.Resultado.OK,"se agrego h4 en MVD");

    System.out.println("_____________________________________________________");
    System.out.println("AGREGAMOS HOSPITALES A LA CIUDAD NYC");
    System.out.println("_____________________________________________________");
               
    p.ver(s.RegistrarHospital("NYC", "H1-NYC", 1, 5, 0).resultado, Retorno.Resultado.OK,"se agrego h1-NYC en NYC");
    p.ver(s.RegistrarHospital("NYC", "H2-NYC", 1, 5, 0).resultado, Retorno.Resultado.OK,"se agrego h2-NYC en NYC");
    p.ver(s.RegistrarHospital("NYC", "H3-NYC", 1, 5, 0).resultado, Retorno.Resultado.OK,"se agrego h3-NYC en NYC ");
    p.ver(s.RegistrarHospital("NYC", "H4-NYC", 1, 5, 0).resultado, Retorno.Resultado.OK,"se agrego h4-NYC en NYC");

    System.out.println("_____________________________________________________");
    System.out.println("INGRESOS EN HOSPITAL H1 DE LA CIUDAD MVD");
    System.out.println("_____________________________________________________");
               
    
    p.ver(s.realizarIngreso(1, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 1 AL HOSPITAL 1");
    p.ver(s.realizarIngreso(2, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 2 AL HOSPITAL 1");
    p.ver(s.realizarIngreso(3, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 3 AL HOSPITAL 1");

    System.out.println("_____________________________________________________");
    System.out.println("INGRESOS EN HOSPITAL H1-NYC DE LA CIUDAD NYC");
    System.out.println("_____________________________________________________");
     
    
    p.ver(s.realizarIngreso(1, "NYC", "H1-NYC").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 1 AL HOSPITAL 1 NYC");
    p.ver(s.realizarIngreso(2, "NYC", "H1-NYC").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 2 AL HOSPITAL 1 NYC");
    p.ver(s.realizarIngreso(3, "NYC", "H1-NYC").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 3 AL HOSPITAL 1 NYC");
 
    System.out.println("_____________________________________________________");
    System.out.println("LISTADO DE INGRESOS EN  HOSPITAL H1 DE MVD");
    System.out.println("_____________________________________________________");
     
    
    p.ver(s.listarPacientesXHospital("MVD", "H1").resultado, Retorno.Resultado.OK, "LISTADO DE PACIENTES HOSPITAL 1: " + s.listarPacientesXHospital("MVD", "H1").valorString);

    System.out.println("_____________________________________________________");
    System.out.println("LISTADO DE INGRESOS EN  HOSPITAL H1-NYC DE NYC");
    System.out.println("_____________________________________________________");
    p.ver(s.listarPacientesXHospital("NYC", "H1-NYC").resultado, Retorno.Resultado.OK, "LISTADO DE PACIENTES HOSPITAL 1: " + s.listarPacientesXHospital("NYC", "H1-NYC").valorString);

    System.out.println("_____________________________________________________");
    System.out.println("INGRESOS INCORRECTOS  EN  HOSPITAL HX DE MVD Y NYC QUE NO EXISTEN");
    System.out.println("_____________________________________________________");    
    p.ver(s.realizarIngreso(4, "MVD", "Hx").resultado, Retorno.Resultado.ERROR, "Se intenta agregar paciente a Hx en MVD que no existe");
    p.ver(s.realizarIngreso(4, "NYC", "Hx").resultado, Retorno.Resultado.ERROR, "Se intenta agregar paciente a Hx en NYC que no existe");
   
    p.ver(s.listarHospitalesCiudad("MVD").resultado, Retorno.Resultado.OK, "listado de hospitales de MVD: " + s.listarHospitalesCiudad("MVD").valorString);
    p.ver(s.listarHospitalesCiudad("NYC").resultado, Retorno.Resultado.OK, "listado de hospitales de NYC: " + s.listarHospitalesCiudad("NYC").valorString);

    System.out.println("_____________________________________________________");
    System.out.println("INGRESO DE SERVICIOS AL HOSPITAL H1");
    System.out.println("_____________________________________________________");    
    p.ver(s.ingresarServicio("MVD", "H1", "WIFI").resultado, Retorno.Resultado.OK, "Se agrego servicio wifi en h1 de MVD");
    p.ver(s.ingresarServicio("MVD", "H1", "Limpieza").resultado, Retorno.Resultado.OK, "Se agrego servicio limpieza en h1 de MVD");
    
    System.out.println("_____________________________________________________");
    System.out.println("INGRESOS EN  HOSPITAL HX DE MVD QUE NO EXISTE");
    System.out.println("_____________________________________________________");
    p.ver(s.ingresarServicio("MVD", "Hx", "WIFI").resultado, Retorno.Resultado.ERROR, "Se intenta agregar servicio wifi en hx de MVD que no existe");

    System.out.println("_____________________________________________________");
    System.out.println("LISTADO DE SERVICIOS  EN  HOSPITAL H1 DE MVD");
    System.out.println("_____________________________________________________");    
    p.ver(s.listarServicios("MVD", "H1").resultado, Retorno.Resultado.OK, "Servicios del hospital 1 de MVD: " + s.listarServicios("MVD", "H1").valorString);
    
    System.out.println("_____________________________________________________");
    System.out.println("BORRADO DE SERVICIOS EN  HOSPITAL H1 DE MVD");
    System.out.println("_____________________________________________________");
    p.ver(s.borrarServicio("MVD", "H1", "WIFI").resultado, Retorno.Resultado.OK, "Se borra servicio wifi en h1 de MVD");
    p.ver(s.borrarServicio("MVD", "H1", "WIFI").resultado, Retorno.Resultado.ERROR, "Se intenta borrar servicio wifi que no existe en h1 de MVD");
 
    System.out.println("_____________________________________________________");
    System.out.println("LISTADO DE SERVICIOS  EN  HOSPITAL H1 DE MVD PARA VER BORRADOS");
    System.out.println("_____________________________________________________");    
      
    p.ver(s.listarServicios("MVD", "H1").resultado, Retorno.Resultado.OK, "Servicios del hospital 1 de MVD: " + s.listarServicios("MVD", "H1").valorString);
   
    System.out.println("_____________________________________________________");
    System.out.println("INGRESO DE COMENTARIOS PARA CAMBIAR RANKING INICIAL");
    System.out.println("_____________________________________________________");    
       
    
    p.ver(s.ingresarComentario("MVD", "H1", "Comentario1", 3).resultado, Retorno.Resultado.OK, "comentario 1 h1 mvd");
    p.ver(s.ingresarComentario("MVD", "H1", "Comentario2", 4).resultado, Retorno.Resultado.OK, "comentario 2 h1 mvd");
    p.ver(s.ingresarComentario("MVD", "H1", "Comentario3", 5).resultado, Retorno.Resultado.OK, "comentario 3 h1 mvd");

    System.out.println("_____________________________________________________");
    System.out.println("LISTADO DE COMENTARIOS  EN  HOSPITAL H1 DE MVD");
    System.out.println("_____________________________________________________");    
       
    p.ver(s.listarComentarios("MVD", "H1").resultado, Retorno.Resultado.OK, "LISTADO DE COMENTARIOS H1 MVD: " + s.listarComentarios("MVD", "H1").valorString);
    
    System.out.println("_____________________________________________________");
    System.out.println("LISTADO RANKING DE HOSPITALES");
    System.out.println("_____________________________________________________");    
       
    p.ver(s.listarHospitalesRanking().resultado, Retorno.Resultado.OK, "Ranking de hospitales: " + s.listarHospitalesRanking().valorString);

    System.out.println("_____________________________________________________");
    System.out.println("LISTADO DE ESPERA  EN  HOSPITAL H1 DE MVD");
    System.out.println("_____________________________________________________");    
   
    p.ver(s.listarEspera("MVD", "H1").resultado, Retorno.Resultado.OK, "lista de espera en H1 de MVD: " + s.listarEspera("MVD", "H1").valorString);
    
    System.out.println("_____________________________________________________");
    System.out.println("INGRESOS EN  HOSPITAL H1 DE MVD HASTA SUPERAR CUPO");
    System.out.println("_____________________________________________________");    
       
    p.ver(s.realizarIngreso(4, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 4 AL HOSPITAL 1");
    p.ver(s.realizarIngreso(5, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 5 AL HOSPITAL 1");
    p.ver(s.realizarIngreso(6, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 6 AL HOSPITAL 1");
    p.ver(s.realizarIngreso(7, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 7 AL HOSPITAL 1");
    p.ver(s.realizarIngreso(8, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 8 AL HOSPITAL 1");
    p.ver(s.realizarIngreso(9, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 9 AL HOSPITAL 1");
    p.ver(s.realizarIngreso(10, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 10 AL HOSPITAL 1");
    p.ver(s.realizarIngreso(11, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 11 AL HOSPITAL 1 a la lista de espera");
    p.ver(s.realizarIngreso(12, "MVD", "H1").resultado, Retorno.Resultado.OK, "SE AGREGO PACIENTE 12 AL HOSPITAL 1 a la lista de espera" );
    
    System.out.println("_____________________________________________________");
    System.out.println("LISTADO DE ESPERA  EN  HOSPITAL H1 DE MVD");
    System.out.println("_____________________________________________________");    
       
    p.ver(s.listarEspera("MVD", "H1").resultado, Retorno.Resultado.OK, "lista de espera en H1 de MVD: " + s.listarEspera("MVD", "H1").valorString);
    
    System.out.println("_____________________________________________________");
    System.out.println("REGISTRO DE NUEVO HOSPITAL SP EN SP");
    System.out.println("_____________________________________________________");    
       
    p.ver(s.RegistrarHospital("SP", "Hospital SP", 3, 3, 0).resultado, Retorno.Resultado.OK, "Se registra hospital sp en san pablo");

    System.out.println("_____________________________________________________");
    System.out.println("TRASLADO DE PACIENTES AL NUEVO HOSPITAL SP");
    System.out.println("_____________________________________________________");    
       
    p.ver(s.trasladarPaciente(1, "MVD", "H1", "SP", "Hospital SP").resultado, Retorno.Resultado.OK, "Se traslada paciente 2 de montevideo a san pablo ");
    p.ver(s.trasladarPaciente(2, "MVD", "H1", "SP", "Hospital SP").resultado, Retorno.Resultado.OK, "Se traslada paciente 3 de montevideo a san pablo ");

    System.out.println("_____________________________________________________");
    System.out.println("INGRESOS EN NUEVO HOSPITAL PARA SUPERAR CUPO");
    System.out.println("_____________________________________________________");    
       
    
    p.ver(s.realizarIngreso(3, "SP", "Hospital SP").resultado, Retorno.Resultado.OK, "se agrega paciente 3 al hospital sp de san pablo");    
    p.ver(s.realizarIngreso(4, "SP", "Hospital SP").resultado, Retorno.Resultado.OK, "se agrega paciente 4 al hospital sp de san pablo en lista espera");
    
    System.out.println("_____________________________________________________");
    System.out.println("LISTADO DE ESPERA EN NUEVO  HOSPITAL SP");
    System.out.println("_____________________________________________________");    
       
    p.ver(s.listarEspera("SP", "Hospital SP").resultado, Retorno.Resultado.OK, "lista de espera en H1 de MVD: " + s.listarEspera("SP", "Hospital SP").valorString);    

    System.out.println("_____________________________________________________");
    System.out.println("LISTADO DE ESPERA EN  HOSPITAL xxx QUE NO EXISTE");
    System.out.println("_____________________________________________________"); 
    
    p.ver(s.listarEspera("SP", "Hospital XXX").resultado, Retorno.Resultado.ERROR, "lista de espera en HXXX que no existe: " + s.listarEspera("SP", "Hospital XXX").valorString);    
    
    System.out.println("_____________________________________________________");
    System.out.println("CARGANDO DISTANCIAS EN MAPA CON NUEVO METODO EN INTERFACE");
    System.out.println("_____________________________________________________"); 
    
    p.ver(s.cargoDistancia(s.getDistancias(),0,1,7).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 0 ciudad 1");
    p.ver(s.cargoDistancia(s.getDistancias(),1,0,7).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 1 ciudad 0");
    
    p.ver(s.cargoDistancia(s.getDistancias(),0,2,9).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 0 ciudad 2");
    p.ver(s.cargoDistancia(s.getDistancias(),2,0,9).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 2 ciudad 0");  
    
    p.ver(s.cargoDistancia(s.getDistancias(),0,5,14).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 0 ciudad 5");
    p.ver(s.cargoDistancia(s.getDistancias(),5,0,14).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 5 ciudad 0");
    
    p.ver(s.cargoDistancia(s.getDistancias(),5,4,9).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 5 ciudad 4");
    p.ver(s.cargoDistancia(s.getDistancias(),4,5,9).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 4 ciudad 5");
    
    p.ver(s.cargoDistancia(s.getDistancias(),5,2,2).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 5 ciudad 2");
    p.ver(s.cargoDistancia(s.getDistancias(),2,5,2).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 2 ciudad 5");
    
    p.ver(s.cargoDistancia(s.getDistancias(),1,2,10).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 1 ciudad 2");
    p.ver(s.cargoDistancia(s.getDistancias(),2,1,10).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 2 ciudad 1");
    
    p.ver(s.cargoDistancia(s.getDistancias(),1,3,15).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 1 ciudad 3");
    p.ver(s.cargoDistancia(s.getDistancias(),3,1,15).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 3 ciudad 1");
    
    
    p.ver(s.cargoDistancia(s.getDistancias(),1,4,14).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 1 ciudad 4");
    p.ver(s.cargoDistancia(s.getDistancias(),4,1,14).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 4 ciudad 1");
    
    p.ver(s.cargoDistancia(s.getDistancias(),3,2,11).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 3 ciudad 2");
    p.ver(s.cargoDistancia(s.getDistancias(),2,3,11).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 2 ciudad 3");
    
    p.ver(s.cargoDistancia(s.getDistancias(),3,4,6).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 3 ciudad 4");
    p.ver(s.cargoDistancia(s.getDistancias(),4,3,6).resultado, Retorno.Resultado.OK, "se cargo el tramo ciuad 4 ciudad 3");
             
    p.ver(s.BuscarCamino(s.getDistancias(), "MVD", "MAD").resultado, Retorno.Resultado.OK, s.BuscarCamino(s.getDistancias(), "MVD", "MAD").valorString);
    
    p.ver(s.destruirSistemaIngreso().resultado,Retorno.Resultado.OK, "fin del proceso");    
    p.imprimirResultadosPrueba();
}  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public static void pruebaObligatorio(Sistema s, Prueba p){
//        //JUEGO DE PRUEBA 1
//        p.ver(s.crearSistemaIngreso(6).resultado, Retorno.Resultado.OK, " Crear sistema.");//Creo el sistema con limite de 6 Ciudades
//        
//        //Registrar de Ciudades
//        p.ver(s.registrarCiudad("Maldonado").resultado, Retorno.Resultado.OK, "Se registro la ciudad de Maldonado");
//        p.ver(s.registrarCiudad("Rivera").resultado, Retorno.Resultado.OK, "Se registro la ciudad de Rivera");
//        p.ver(s.registrarCiudad("Paysandu").resultado, Retorno.Resultado.OK, "Se registro la ciudad de Paysandu");
//        p.ver(s.registrarCiudad("Canelones").resultado, Retorno.Resultado.OK, "Se registro la ciudad de Canelones");
//        p.ver(s.registrarCiudad("Rocha").resultado, Retorno.Resultado.OK, "Se registro la ciudad de Rocha");
//        
//        //Ciudades repetidas
//        p.ver(s.registrarCiudad("Rocha").resultado, Retorno.Resultado.ERROR, "La ciudad Rocha ya esta registrada");
//        p.ver(s.registrarCiudad("Canelones").resultado, Retorno.Resultado.ERROR, "La ciudad de Canelones ya esta registrada");
//        p.ver(s.registrarCiudad("Rivera").resultado, Retorno.Resultado.ERROR, "La ciudad de Rivera ya esta registrada");
//        
//        //Ultima ciudad para completa el limite
//        p.ver(s.registrarCiudad("Colonia").resultado, Retorno.Resultado.OK, "Se registro la ciudad de Colonia");
//        
//        //Limite de ciudades excedido
//        p.ver(s.registrarCiudad("Artigas").resultado, Retorno.Resultado.ERROR, "Intento de registrar Artigas, LIMITE EXCEDIDO!");
//        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR, "Intento de registrar Montevideo, LIMITE EXCEDIDO!");
//        p.ver(s.registrarCiudad("Rio Negro").resultado, Retorno.Resultado.ERROR, "Intento de registrar Rio Negro, LIMITE EXCEDIDO!");
//        
//        //Registrar Hospitales
//        //Maldonado
//        p.ver(s.RegistrarHospital("Maldonado", "Hospital Centro Maldonado", 150, 3, 0).resultado, Retorno.Resultado.OK, "Se registro el Hospital Centro Maldonado en Maldonado");
//        p.ver(s.RegistrarHospital("Maldonado", "Hospital Cantegril", 85, 4, 0).resultado, Retorno.Resultado.OK, "Se registro el Hospital Cantegril en Maldonado");
//        
//        //Rivera
//        p.ver(s.RegistrarHospital("Rivera", "Hospital Muinho", 320, 5, 0).resultado, Retorno.Resultado.OK, "Se registro el Hospital Muinho en Rivera");
//       
//        //Paysandu
//        //--
//        
//        //Canelones
//        p.ver(s.RegistrarHospital("Canelones", "Hospital Atlantida", 60, 3, 0).resultado, Retorno.Resultado.OK, "Se registro el Hospital Atlantida en Canelones");
//        p.ver(s.RegistrarHospital("Canelones", "Hospital Capital", 230, 3, 0).resultado, Retorno.Resultado.OK, "Se registro el Hospital Capital en Canelones");
//        p.ver(s.RegistrarHospital("Canelones", "Hospital Perimetral", 80, 4, 0).resultado, Retorno.Resultado.OK, "Se registro el Hospital Perimetral en Canelones");
//        p.ver(s.RegistrarHospital("Canelones", "Hospital Hospitalito", 150, 2, 0).resultado, Retorno.Resultado.OK, "Se registro el Hospital Hospitalito en Canelones");
//        
//        //Rocha
//        p.ver(s.RegistrarHospital("Rocha", "Hospital Rochense", 190, 5, 0).resultado, Retorno.Resultado.OK, "Se registro el Hospital Rochense en Rocha");
//        
//        //Colonia
//        p.ver(s.RegistrarHospital("Colonia", "Hospital Colonial", 5, 3, 0).resultado, Retorno.Resultado.OK, "Se registro el Hospital Colonial en Colonia");
//        p.ver(s.RegistrarHospital("Colonia", "Hospital Rural", 180, 1, 0).resultado, Retorno.Resultado.OK, "Se registro el Hospital Rural en Colonia");
//        
//        //Error de registro, Hospitales ya existentes
//        //Maldonado
//        p.ver(s.RegistrarHospital("Maldonado", "Hospital Cantegril", 30, 5, 0).resultado, Retorno.Resultado.ERROR, "El Hospital Cantegril en Maldonado ya existe");
//        //Canelones
//        p.ver(s.RegistrarHospital("Canelones", "Hospital Capital", 170, 4, 0).resultado, Retorno.Resultado.ERROR, "El Hospital Capital en Canelones ya existe");
//        p.ver(s.RegistrarHospital("Canelones", "Hospital Perimetral", 110, 2, 0).resultado, Retorno.Resultado.ERROR, "El Hospital Perimetral en Canelones ya existe");
//        //Colonia
//        p.ver(s.RegistrarHospital("Colonia", "Hospital Rural", 5, 4, 0).resultado, Retorno.Resultado.ERROR, "El Hospital Rural en Colonia ya existe.");
//
//        //Listar Hospitales por Ciudad
//        //Maldonado
//        p.ver(s.listarHospitalesCiudad("Maldonado").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Maldonado").valorString);
//        //Rivera
//        p.ver(s.listarHospitalesCiudad("Rivera").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Rivera").valorString);
//        //Paysandu
//        p.ver(s.listarHospitalesCiudad("Paysandu").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Paysandu").valorString);
//        //Canelones
//        p.ver(s.listarHospitalesCiudad("Canelones").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Canelones").valorString);
//        //Rocha
//        p.ver(s.listarHospitalesCiudad("Rocha").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Rocha").valorString);
//        //Colonia
//        p.ver(s.listarHospitalesCiudad("Colonia").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Colonia").valorString);
//        
//        //Listar Hospitales Ciudad no encontrada
//        p.ver(s.listarHospitalesCiudad("Montevideo").resultado, Retorno.Resultado.ERROR, "No se encontro la ciudad solicitada");
//        
//   
//        //Listar Servicios
//        //Maldonado
//        //Hospital Centro Maldonado
//        p.ver(s.ingresarServicio("Maldonado", "Hospital Centro Maldonado", "Pediatria").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Pediatria");
//        p.ver(s.ingresarServicio("Maldonado", "Hospital Centro Maldonado", "Traumatologia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Traumatologia");
//        //Hospital Cantegril
//        p.ver(s.ingresarServicio("Maldonado", "Hospital Cantegril", "Ortopedia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Ortopedia");
//        p.ver(s.ingresarServicio("Maldonado", "Hospital Cantegril", "Pediatria").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Pediatria");
//        p.ver(s.ingresarServicio("Maldonado", "Hospital Cantegril", "Fisiatría").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Fisiatría");
//        p.ver(s.ingresarServicio("Maldonado", "Hospital Cantegril", "Radiologia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Radiologia");
//        
//        //Rivera
//        //Hospital Muinho
//        p.ver(s.ingresarServicio("Rivera", "Hospital Muinho", "Traumatologia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Traumatologia");
//        p.ver(s.ingresarServicio("Rivera", "Hospital Muinho", "Pediatria").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Pediatria");
//        p.ver(s.ingresarServicio("Rivera", "Hospital Muinho", "Fisiatría").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Fisiatría");
//        p.ver(s.ingresarServicio("Rivera", "Hospital Muinho", "Radiologia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Radiologia");
//        p.ver(s.ingresarServicio("Rivera", "Hospital Muinho", "Ortopedia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Ortopedia");
//            
//          
//        //Canelones
//        //Hospital Atlantida
//        p.ver(s.ingresarServicio("Canelones", "Hospital Atlantida", "Traumatologia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Traumatologia");
//        p.ver(s.ingresarServicio("Canelones", "Hospital Atlantida", "Pediatria").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Pediatria");
//        p.ver(s.ingresarServicio("Canelones", "Hospital Atlantida", "Ortopedia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Ortopedia");
//        //Hospital Capital
//        p.ver(s.ingresarServicio("Canelones", "Hospital Capital", "Nutricion").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Nutricion");
//        p.ver(s.ingresarServicio("Canelones", "Hospital Capital", "Traumatologia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Traumatologia");
//        p.ver(s.ingresarServicio("Canelones", "Hospital Capital", "Radiologia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Radiologia");
//        p.ver(s.ingresarServicio("Canelones", "Hospital Capital", "Pediatria").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Pediatria");
//        //Hospital Perimentral
//        p.ver(s.ingresarServicio("Canelones", "Hospital Perimetral", "Traumatologia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Traumatologia");
//        //Hospital Hospitalito
//        p.ver(s.ingresarServicio("Canelones", "Hospital Hospitalito", "Pediatria").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Pediatria");
//        p.ver(s.ingresarServicio("Canelones", "Hospital Hospitalito", "Ortopedia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Ortopedia");
//        
//        //Rocha
//        //Hospital Rochense
//        p.ver(s.ingresarServicio("Rocha", "Hospital Rochense", "Nutricion").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Nutricion");
//        p.ver(s.ingresarServicio("Rocha", "Hospital Rochense", "Pediatria").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Pediatria");
//        p.ver(s.ingresarServicio("Rocha", "Hospital Rochense", "Ortopedia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Ortopedia");
//          
//        //Colonia
//        //Hospital Colonial
//        p.ver(s.ingresarServicio("Colonia", "Hospital Colonial", "Radiologia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Radiologia");
//        //Hospital Rural
//        p.ver(s.ingresarServicio("Colonia", "Hospital Rural", "Pediatria").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Pediatria");
//        p.ver(s.ingresarServicio("Colonia", "Hospital Rural", "Nutricion").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Nutricion"); 
//        p.ver(s.ingresarServicio("Colonia", "Hospital Rural", "Radiologia").resultado, Retorno.Resultado.OK, "Se registro el Servicio de Radiologia");
//        
//        //Hospital no existente en la Ciudad determinada
//        p.ver(s.ingresarServicio("Canelones", "Hospital Americano", "Nutricion").resultado, Retorno.Resultado.ERROR, "Error al registrar Servicio, no se encontro el Hospital Americano en Canelones"); 
//        p.ver(s.ingresarServicio("Rocha", "Hospital Costanera", "Radiologia").resultado, Retorno.Resultado.ERROR, "Error al registrar Servicio, no se encontro el Hospital Costanera en Rocha");
//        
//        //Ciudad no existente
//        p.ver(s.ingresarServicio("Montevideo", "Hospital Policial", "Ortopedia").resultado, Retorno.Resultado.ERROR, "Error al registrar Servicio, no se encontro la Ciudad Montevideo"); 
//        p.ver(s.ingresarServicio("Artigas", "Hospital Del Norte", "Traumatologia").resultado, Retorno.Resultado.ERROR, "Error al registrar Servicio, no se encontro la Ciudad Artigas");
//    
//        
//        //Borrado de servicios
//        //Maldonado
//        //Hospital Cantegril
//        p.ver(s.borrarServicio("Maldonado", "Hospital Cantegril", "Ortopedia").resultado, Retorno.Resultado.OK, "Se borro Ortopedia del Hospital Cantegril");
//        p.ver(s.borrarServicio("Maldonado", "Hospital Cantegril", "Radiologia").resultado, Retorno.Resultado.OK, "Se borro Radiologia del Hospital Cantegril");
//        
//        //Rivera
//        //Hospital Muinho
//        p.ver(s.borrarServicio("Rivera", "Hospital Muinho", "Fisiatría").resultado, Retorno.Resultado.OK, "Se borro Fisiatria del Hospital Muinho");
//        
//        //Canelones
//        //Hospital Atlantida
//        p.ver(s.borrarServicio("Canelones", "Hospital Atlantida", "Traumatologia").resultado, Retorno.Resultado.OK, "Se borro Traumatologia del Hospital Atlantida");
//        //Hospital Capital
//        p.ver(s.borrarServicio("Canelones", "Hospital Capital", "Nutricion").resultado, Retorno.Resultado.OK, "Se borro Nutricion del Hospital Capital");
//        p.ver(s.borrarServicio("Canelones", "Hospital Capital", "Radiologia").resultado, Retorno.Resultado.OK, "Se borro Radiologia del Hospital Capital");
//        
//        //Colonia
//        //Hospital Colonial
//        p.ver(s.borrarServicio("Colonia", "Hospital Colonial", "Radiologia").resultado, Retorno.Resultado.OK, "Se borro Radiologia del Hospital Colonial");
//        
//        //Hospital no existe 
//        p.ver(s.borrarServicio("Colonia", "Hospital Carmelo", "Nutricion").resultado, Retorno.Resultado.ERROR, "Error al borrar el Servicio Nutricion, no se encontro el Hospital Carmelo");
//        //Servicio no existe en el hospital determinado
//        p.ver(s.borrarServicio("Canelones", "Hospital Hospitalito", "Traumatologia").resultado, Retorno.Resultado.ERROR, "Error al borrar el Servicio Traumatologia, no se encontro en el Hospital Hospitalito");
//        p.ver(s.borrarServicio("Rocha", "Hospital Rochense", "Fisiatría").resultado, Retorno.Resultado.ERROR, "Error al borrar el Servicio Fisiatria, no se encontro en el Hospital Rochense");
//        //Ciudad no existe
//        p.ver(s.borrarServicio("Tacuarembo", "Hospital Tacua", "Radiologia").resultado, Retorno.Resultado.ERROR, "Error al borrar el Servicio Radiologia, no se encontro la Ciudad Tacuarembo");
//        
//       //Listar Servicios por Hospital
//       //Maldonado
//       p.ver(s.listarServicios("Maldonado", "Hospital Centro Maldonado").resultado, Retorno.Resultado.OK, s.listarServicios("Maldonado", "Hospital Centro Maldonado").valorString);
//       p.ver(s.listarServicios("Maldonado", "Hospital Cantegril").resultado, Retorno.Resultado.OK, s.listarServicios("Maldonado", "Hospital Cantegril").valorString);
//       //Rivera
//       p.ver(s.listarServicios("Rivera", "Hospital Muinho").resultado, Retorno.Resultado.OK, s.listarServicios("Rivera", "Hospital Muinho").valorString);
//       //Canelones
//       p.ver(s.listarServicios("Canelones", "Hospital Atlantida").resultado, Retorno.Resultado.OK, s.listarServicios("Canelones", "Hospital Atlantida").valorString);
//       p.ver(s.listarServicios("Canelones", "Hospital Capital").resultado, Retorno.Resultado.OK, s.listarServicios("Canelones", "Hospital Capital").valorString);
//       p.ver(s.listarServicios("Canelones", "Hospital Perimetral").resultado, Retorno.Resultado.OK, s.listarServicios("Canelones", "Hospital Perimetral").valorString);
//       p.ver(s.listarServicios("Canelones", "Hospital Hospitalito").resultado, Retorno.Resultado.OK, s.listarServicios("Canelones", "Hospital Hospitalito").valorString);
//       //Rocha
//       p.ver(s.listarServicios("Rocha", "Hospital Rochense").resultado, Retorno.Resultado.OK, s.listarServicios("Rocha", "Hospital Rochense").valorString);
//       //Colonia
//       p.ver(s.listarServicios("Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, s.listarServicios("Colonia", "Hospital Colonial").valorString);
//       p.ver(s.listarServicios("Colonia", "Hospital Rural").resultado, Retorno.Resultado.OK, s.listarServicios("Colonia", "Hospital Rural").valorString);
//          
//       
//       
//        //Ingresar Comentarios
//        //Maldonado
//        //Hospital Centro Maldonado
//        p.ver(s.ingresarComentario("Maldonado", "Hospital Centro Maldonado", "Muy buen servicio", 4).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Centro Maldonado");
//        p.ver(s.ingresarComentario("Maldonado", "Hospital Centro Maldonado", "Servicio aceptable", 2).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Centro Maldonado");
//        p.ver(s.ingresarComentario("Maldonado", "Hospital Centro Maldonado", "Buen servicio", 3).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Centro Maldonado");
//        //Hospital Cantegril
//        p.ver(s.ingresarComentario("Maldonado", "Hospital Cantegril", "Muy buen servicio PRIMERO", 4).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Cantegril");
//        p.ver(s.ingresarComentario("Maldonado", "Hospital Cantegril", "Servicio aceptable SEGUNDO", 2).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Cantegril");
//        p.ver(s.ingresarComentario("Maldonado", "Hospital Cantegril", "Buen servicio TERCERO", 3).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Cantegril");
//        p.ver(s.ingresarComentario("Maldonado", "Hospital Cantegril", "Muy buen servicio CUARTO", 4).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Cantegril");
//        
//        //Rivera
//        //Hospital Muinho
//        p.ver(s.ingresarComentario("Rivera", "Hospital Muinho", "Servicio aceptable", 2).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Muinho");
//        p.ver(s.ingresarComentario("Rivera", "Hospital Muinho", "Buen servicio", 3).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Muinho");
//       
//        //Canelones
//        //Hospital Atlantida
//        p.ver(s.ingresarComentario("Canelones", "Hospital Atlantida", "Muy buen servicio", 4).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Atlantida");
//        //Hospital Capital
//        p.ver(s.ingresarComentario("Canelones", "Hospital Capital", "Servicio aceptable", 2).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Capital");
//        p.ver(s.ingresarComentario("Canelones", "Hospital Capital", "Buen servicio", 3).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Capital");
//        p.ver(s.ingresarComentario("Canelones", "Hospital Capital", "Muy buen servicio", 4).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Capital");
//        p.ver(s.ingresarComentario("Canelones", "Hospital Capital", "Servicio aceptable", 2).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Capital");
//        //Hospital Perimetral
//        p.ver(s.ingresarComentario("Canelones", "Hospital Perimetral", "Buen servicio", 3).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Perimetral");
//        p.ver(s.ingresarComentario("Canelones", "Hospital Perimetral", "Muy buen servicio", 4).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Perimetral");
//        //Hospital Hospitalito
//        p.ver(s.ingresarComentario("Canelones", "Hospital Hospitalito", "Servicio aceptable", 2).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Hospitalito");
//        p.ver(s.ingresarComentario("Canelones", "Hospital Hospitalito", "Buen servicio", 3).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Hospitalito");
//        p.ver(s.ingresarComentario("Canelones", "Hospital Hospitalito", "Muy buen servicio", 4).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Hospitalito");
//        p.ver(s.ingresarComentario("Canelones", "Hospital Hospitalito", "Servicio aceptable", 2).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Hospitalito");
//        
//        //Rocha
//        //Hospital Rochense
//        p.ver(s.ingresarComentario("Rocha", "Hospital Rochense", "Buen servicio", 3).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Rochense");
//        p.ver(s.ingresarComentario("Rocha", "Hospital Rochense", "Muy buen servicio", 4).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Rochense");
//        p.ver(s.ingresarComentario("Rocha", "Hospital Rochense", "Servicio aceptable", 2).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Rochense");
//        
//        //Colonia
//        //Hospital Colonial
//        p.ver(s.ingresarComentario("Colonia", "Hospital Colonial", "Buen servicio", 3).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Colonial");
//        p.ver(s.ingresarComentario("Colonia", "Hospital Colonial", "Muy buen servicio", 4).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Colonial");
//        p.ver(s.ingresarComentario("Colonia", "Hospital Colonial", "Buen servicio", 3).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Colonial");
//        p.ver(s.ingresarComentario("Colonia", "Hospital Colonial", "Servicio aceptable", 2).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Colonial");
//        //Hospital Rural
//        p.ver(s.ingresarComentario("Colonia", "Hospital Rural", "Buen servicio", 3).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Rural");
//        p.ver(s.ingresarComentario("Colonia", "Hospital Rural", "Excelente servicio", 5).resultado, Retorno.Resultado.OK, "Comentario Registrado en Hospital Rural");
//                
//        //Error ingresar comentario, ranking fuera de rango
//        p.ver(s.ingresarComentario("Maldonado", "Hospital Cantegril", "Inmejobrable servicio", 10).resultado, Retorno.Resultado.ERROR, "Error al cargar Comentario en Hospital Cantegril, el ranking esta fuera de rango");
//        p.ver(s.ingresarComentario("Canelones", "Hospital Hospitalito", "Pesimo servicio", 0).resultado, Retorno.Resultado.ERROR, "Error al cargar Comentario en Hospital Hospitalito, el ranking esta fuera de rango");
//        
//        //Error ingresar comentario, el Hospital no existe
//        p.ver(s.ingresarComentario("Canelones", "Hospital Canario", "Muy buen servicio", 4).resultado, Retorno.Resultado.ERROR, "Error al cargar Comentario, el Hospital Canario no existe");
//        p.ver(s.ingresarComentario("Rocha", "Hospital La Paloma", "Servicio aceptable", 2).resultado, Retorno.Resultado.ERROR, "Error al cargar Comentario, el Hospital La Paloma no existe");
//        p.ver(s.ingresarComentario("Maldonado", "Mautone", "Excelente servicio", 5).resultado, Retorno.Resultado.ERROR, "Error al cargar Comentario, el Hospital Mautone no existe");
//        //Error ingresar comentario, la Ciudad no existe
//        p.ver(s.ingresarComentario("Soriano", "Hospital Soriano", "Buen servicio", 3).resultado, Retorno.Resultado.ERROR, "Error al cargar Comentario, la Ciudad Soriano no existe");
//        
//        
//        //Listar Comentarios por Hospital
//        //Maldonado
//        p.ver(s.listarComentarios("Maldonado", "Hospital Centro Maldonado").resultado, Retorno.Resultado.OK, s.listarComentarios("Maldonado", "Hospital Centro Maldonado").valorString);
//        p.ver(s.listarComentarios("Maldonado", "Hospital Cantegril").resultado, Retorno.Resultado.OK, s.listarComentarios("Maldonado", "Hospital Cantegril").valorString);
//        //Rivera
//        p.ver(s.listarComentarios("Rivera", "Hospital Muinho").resultado, Retorno.Resultado.OK, s.listarComentarios("Rivera", "Hospital Muinho").valorString);
//        //Canelones
//        p.ver(s.listarComentarios("Canelones", "Hospital Atlantida").resultado, Retorno.Resultado.OK, s.listarComentarios("Canelones", "Hospital Atlantida").valorString);
//        p.ver(s.listarComentarios("Canelones", "Hospital Capital").resultado, Retorno.Resultado.OK, s.listarComentarios("Canelones", "Hospital Capital").valorString);
//        p.ver(s.listarComentarios("Canelones", "Hospital Perimetral").resultado, Retorno.Resultado.OK, s.listarComentarios("Canelones", "Hospital Perimetral").valorString);
//        p.ver(s.listarComentarios("Canelones", "Hospital Hospitalito").resultado, Retorno.Resultado.OK, s.listarComentarios("Canelones", "Hospital Hospitalito").valorString);
//        //Rocha
//        p.ver(s.listarComentarios("Rocha", "Hospital Rochense").resultado, Retorno.Resultado.OK, s.listarComentarios("Rocha", "Hospital Rochense").valorString);
//        //Colonia
//        p.ver(s.listarComentarios("Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, s.listarComentarios("Colonia", "Hospital Colonial").valorString);
//        p.ver(s.listarComentarios("Colonia", "Hospital Rural").resultado, Retorno.Resultado.OK, s.listarComentarios("Colonia", "Hospital Rural").valorString);
//        
//        
//        //Realizar Ingresos
//        //Maldonado
//        //Hospital Centro Maldonado
//        p.ver(s.realizarIngreso(47856825, "Maldonado", "Hospital Centro Maldonado").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Centro Maldonado");
//        p.ver(s.realizarIngreso(46854297, "Maldonado", "Hospital Centro Maldonado").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Centro Maldonado");
//        p.ver(s.realizarIngreso(42578555, "Maldonado", "Hospital Centro Maldonado").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Centro Maldonado");
//        //Hospital Cantegril
//        p.ver(s.realizarIngreso(34865132, "Maldonado", "Hospital Cantegril").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Cantegril");
//        p.ver(s.realizarIngreso(48465113, "Maldonado", "Hospital Cantegril").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Cantegril");
//        p.ver(s.realizarIngreso(41896153, "Maldonado", "Hospital Cantegril").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Cantegril");
//        p.ver(s.realizarIngreso(38976452, "Maldonado", "Hospital Cantegril").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Cantegril");
//        
//        //Rivera
//        //Hospital Muinho
//        p.ver(s.realizarIngreso(42356864, "Rivera", "Hospital Muinho").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Muinho");
//        p.ver(s.realizarIngreso(37896542, "Rivera", "Hospital Muinho").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Muinho");
//        p.ver(s.realizarIngreso(41665149, "Rivera", "Hospital Muinho").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Muinho");
//        p.ver(s.realizarIngreso(43267835, "Rivera", "Hospital Muinho").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Muinho");
//        p.ver(s.realizarIngreso(31598726, "Rivera", "Hospital Muinho").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Muinho");
//        p.ver(s.realizarIngreso(44557138, "Rivera", "Hospital Muinho").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Muinho");
//        
//        //Canelones
//        //Hospital Atlantida
//        p.ver(s.realizarIngreso(41547544, "Canelones", "Hospital Atlantida").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Atlantida");
//        p.ver(s.realizarIngreso(24896518, "Canelones", "Hospital Atlantida").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Atlantida");
//        //Hospital Capital
//        p.ver(s.realizarIngreso(46833215, "Canelones", "Hospital Capital").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Capital");
//        //Hospital Perimetral
//        p.ver(s.realizarIngreso(34821516, "Canelones", "Hospital Perimetral").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Perimetral");
//        p.ver(s.realizarIngreso(58712622, "Canelones", "Hospital Perimetral").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Perimetral");
//        p.ver(s.realizarIngreso(48646516, "Canelones", "Hospital Perimetral").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Perimetral");
//        //Hospital Hospitalito
//        p.ver(s.realizarIngreso(38572158, "Canelones", "Hospital Hospitalito").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Hospitalito");
//        p.ver(s.realizarIngreso(48534257, "Canelones", "Hospital Hospitalito").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Hospitalito");
//        p.ver(s.realizarIngreso(41897233, "Canelones", "Hospital Hospitalito").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Hospitalito");
//        p.ver(s.realizarIngreso(28465168, "Canelones", "Hospital Hospitalito").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Hospitalito");
//        p.ver(s.realizarIngreso(42376516, "Canelones", "Hospital Hospitalito").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Hospitalito");
//        p.ver(s.realizarIngreso(38965436, "Canelones", "Hospital Hospitalito").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Hospitalito");
//        
//        //Rocha
//        //Hospital Rochense
//        p.ver(s.realizarIngreso(49562346, "Rocha", "Hospital Rochense").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Rochense");
//        p.ver(s.realizarIngreso(31297849, "Rocha", "Hospital Rochense").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Rochense");
//        p.ver(s.realizarIngreso(47891553, "Rocha", "Hospital Rochense").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Rochense");
//        p.ver(s.realizarIngreso(58951644, "Rocha", "Hospital Rochense").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Rochense");
//        
//        //Colonia
//        //Hospital Colonial
//        p.ver(s.realizarIngreso(47896548, "Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Colonial");
//        p.ver(s.realizarIngreso(43548916, "Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Colonial");
//        p.ver(s.realizarIngreso(45897651, "Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Colonial");
//        p.ver(s.realizarIngreso(33845344, "Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Colonial");
//        p.ver(s.realizarIngreso(58756187, "Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Colonial");
//        p.ver(s.realizarIngreso(47945168, "Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Colonial");
//        p.ver(s.realizarIngreso(49841561, "Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Colonial");
//        //Hospital Rural
//        p.ver(s.realizarIngreso(38796544, "Colonia", "Hospital Rural").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Rural");
//        p.ver(s.realizarIngreso(41894615, "Colonia", "Hospital Rural").resultado, Retorno.Resultado.OK, "Se ingreso el paciente en Hospital Rural");
//       
//        
//        //Listar fila de espera por Hospital
//        p.ver(s.listarEspera("Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, s.listarEspera("Colonia", "Hospital Colonial").valorString);
//        p.ver(s.listarEspera("Maldonado", "Hospital Cantegril").resultado, Retorno.Resultado.OK, s.listarEspera("Maldonado", "Hospital Cantegril").valorString);
//   
//        
//        //Error al realizar el Ingreso, el Hospital no existe
//        p.ver(s.realizarIngreso(38572158, "Canelones", "Hospital Salinas").resultado, Retorno.Resultado.ERROR, "Error al ingresar paciente, el Hospital Salinas no existe");
//        p.ver(s.realizarIngreso(58974563, "Colonia", "Hospital Nueva Helvecia").resultado, Retorno.Resultado.ERROR, "Error al ingresar paciente, el Hospital Nueva Helvecia no existe");
//        //Error al realizar el Ingreso, la Ciudad no existe
//        p.ver(s.realizarIngreso(36856251, "Treinta y Tres", "Hospital 33").resultado, Retorno.Resultado.ERROR, "Error al ingresar paciente, la Ciudad no existe");
//        
//        
//        //Cancelar Ingresos
//        //Maldonado
//        //Hospital Centro Maldonado
//        p.ver(s.cancelarIngreso(42578555, "Maldonado", "Hospital Centro Maldonado").resultado, Retorno.Resultado.OK, s.cancelarIngreso(42578555, "Maldonado", "Hospital Centro Maldonado").valorString);
//        //Hospital Cantegril
//        p.ver(s.cancelarIngreso(38976452, "Maldonado", "Hospital Cantegril").resultado, Retorno.Resultado.OK, "Se cancelo el ingreso del paciente en Hospital Cantegril");
//        
//        //Rivera
//        //Hospital Muinho
//        p.ver(s.cancelarIngreso(41665149, "Rivera", "Hospital Muinho").resultado, Retorno.Resultado.OK, "Se cancelo el ingreso del paciente en Hospital Muinho");
//        
//        //Canelones
//        //Hospital Hospitalito
//        p.ver(s.cancelarIngreso(38572158, "Canelones", "Hospital Hospitalito").resultado, Retorno.Resultado.OK, "Se cancelo el ingreso del paciente en Hospital Hospitalito");
//        p.ver(s.cancelarIngreso(48534257, "Canelones", "Hospital Hospitalito").resultado, Retorno.Resultado.OK, "Se cancelo el ingreso del paciente en Hospital Hospitalito");
//        
//        //Rocha
//        //Hospital Rochense
//        p.ver(s.cancelarIngreso(49562346, "Rocha", "Hospital Rochense").resultado, Retorno.Resultado.OK, "Se cancelo el ingreso del paciente en Hospital Rochense");
//        
//        //Colonia
//        //Hospital Colonial
//        p.ver(s.cancelarIngreso(47896548, "Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, "Se cancelo el ingreso del paciente en Hospital Colonial");
//        p.ver(s.cancelarIngreso(43548916, "Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, "Se cancelo el ingreso del paciente en Hospital Colonial");
//        p.ver(s.cancelarIngreso(47945168, "Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, "Se cancelo el ingreso del paciente en Hospital Colonial");
//
//        
//        //Error al cancelar el Ingreso, el Hospital no existe
//        p.ver(s.cancelarIngreso(37645186, "Rivera", "Hospital Frontera").resultado, Retorno.Resultado.ERROR, "No se pudo cancelar el Ingreso, el Hospital no existe");
//        p.ver(s.cancelarIngreso(48318435, "Canelones", "Hospital Hospitalito").resultado, Retorno.Resultado.ERROR, "No se pudo cancelar el Ingreso, el Hospital no existe");
//        //Error al cancelar el Ingreso, el paciente no esta registrado en dicho Hospital
//        p.ver(s.cancelarIngreso(48921562, "Maldonado", "Hospital Cantegril").resultado, Retorno.Resultado.ERROR, "No se pudo cancelar el ingreso, el paciente no esta registrado en Hospital Cantegril");
//        p.ver(s.cancelarIngreso(39874532, "Rocha", "Hospital Rochense").resultado, Retorno.Resultado.ERROR, "No se pudo cancelar el ingreso, el paciente no esta registrado en Hospital Rochense");
//        //Error al cancelar el Ingreso, la Ciudad no existe
//        p.ver(s.cancelarIngreso(46878957, "Artigas", "Hospital Del Norte").resultado, Retorno.Resultado.ERROR, "No se pudo cancelar el ingreso, la Ciudad no existe");
//   
//        
//        //Trasladar Pacientes
//        //Maldonado
//        //Hospital Centro Maldonado
//        p.ver(s.trasladarPaciente(34865132, "Maldonado", "Hospital Cantegril", "Maldonado", "Hospital Centro Maldonado").resultado, Retorno.Resultado.OK, "Se traslado el Paciente correctamente");
//        p.ver(s.trasladarPaciente(48465113, "Maldonado", "Hospital Cantegril", "Colonia", "Hospital Colonial").resultado, Retorno.Resultado.OK, "Se traslado el Paciente correctamente");
//
//        //Rivera
//        //Hospital Muinho
//        p.ver(s.trasladarPaciente(37896542, "Rivera", "Hospital Muinho", "Canelones", "Hospital Atlantida").resultado, Retorno.Resultado.OK, "Se traslado el Paciente correctamente");
//        
//        //Canelones
//        //Hospital Atlantida
//        p.ver(s.trasladarPaciente(41547544, "Canelones", "Hospital Atlantida", "Maldonado", "Hospital Centro Maldonado").resultado, Retorno.Resultado.OK, "Se traslado el Paciente correctamente");
//        //Hospital Hospitalito
//        p.ver(s.trasladarPaciente(42376516, "Canelones", "Hospital Hospitalito", "Colonia", "Hospital Rural").resultado, Retorno.Resultado.OK, "Se traslado el Paciente correctamente");
//        p.ver(s.trasladarPaciente(38965436, "Canelones", "Hospital Hospitalito", "Rivera", "Hospital Muinho").resultado, Retorno.Resultado.OK, "Se traslado el Paciente correctamente");        
//        
//        
//        //Error al Trasladar paciente, el Hospital Origen no existe
//        p.ver(s.trasladarPaciente(48973215, "Canelones", "Hospital Bello Horizonte", "Maldonado", "Hospital Centro Maldonado").resultado, Retorno.Resultado.ERROR, "No se pudo trasladar al paciente, el Hospital Origen no existe");
//        //Error al Trasladar paciente, el Hospital Destino no existe
//        p.ver(s.trasladarPaciente(58975166, "Canelones", "Hospital Atlantida", "Maldonado", "Hospital Piria").resultado, Retorno.Resultado.ERROR, "No se pudo trasladar al paciente, el Hospital Destino no existe");
//        //Error al Trasladar paciente, el paciente no tiene registros en el Hospital Origen
//        p.ver(s.trasladarPaciente(48915687, "Colonia", "Hospital Rural", "Maldonado", "Hospital Centro Maldonado").resultado, Retorno.Resultado.ERROR, "No se pudo trasladar al paciente, no se encontro registro en Hospital Origen");
//        //Error al Trasladar paciente, la Ciudad Origen no existe
//       // p.ver(s.trasladarPaciente(38951854, "Durazno", "Hospital Carozo", "Maldonado", "Hospital Cantegril").resultado, Retorno.Resultado.ERROR, "No se pudo trasladar al paciente, la Ciudad Origen no existe");
//        //Error al Trasladar paciente, la Ciudad Destino no existe
//        //p.ver(s.trasladarPaciente(48875249, "Rivera", "Hospital Muinho", "San Jose", "Hospital Jefferson").resultado, Retorno.Resultado.ERROR, "No se pudo trasladar al paciente, la Ciudad Destino no existe");
//        
//       
//        //Listar Hospitales por Ciudad
//        //Maldonado
//        p.ver(s.listarHospitalesCiudad("Maldonado").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Maldonado").valorString);
//        //Rivera
//        p.ver(s.listarHospitalesCiudad("Rivera").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Rivera").valorString);
//        //Paysandu
//        p.ver(s.listarHospitalesCiudad("Paysandu").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Paysandu").valorString);
//        //Canelones
//        p.ver(s.listarHospitalesCiudad("Canelones").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Canelones").valorString);
//        //Rocha
//        p.ver(s.listarHospitalesCiudad("Rocha").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Rocha").valorString);
//        //Colonia
//        p.ver(s.listarHospitalesCiudad("Colonia").resultado, Retorno.Resultado.OK, s.listarHospitalesCiudad("Colonia").valorString);
//        
//        
//        
//        
//        //Listar Hospitales por Ranking manera DESC
//        p.ver(s.listarHospitalesRanking().resultado ,Retorno.Resultado.OK, s.listarHospitalesRanking().valorString);
//        
//        
//        
//    }
}
