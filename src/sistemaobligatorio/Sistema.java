package sistemaobligatorio;

import Listas.*;


public class Sistema implements ISistema {
    Listaciudad listaCiudades;
    int [][] distancias;
    int cantCiudades;

    public Listaciudad getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(Listaciudad listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public int[][] getDistancias() {
        return distancias;
    }

    public void setDistancias(int[][] distancias) {
        this.distancias = distancias;
    }

    public int getCantCiudades() {
        return cantCiudades;
    }

    public void setCantCiudades(int cantCiudades) {
        this.cantCiudades = cantCiudades;
    }

    public Sistema(){
        
    }
    
    @Override
    public Retorno crearSistemaIngreso(int cantCiudades) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if (cantCiudades > 0) {
            ret.resultado = Retorno.Resultado.OK;
            this.listaCiudades = new Listaciudad();
            this.listaCiudades.setCantidad(cantCiudades);
            distancias= new int [cantCiudades][cantCiudades];
        } else if (cantCiudades == 0) {
            ret.resultado = Retorno.Resultado.OK;
            this.listaCiudades = new Listaciudad();
            this.listaCiudades.setCantidad(Integer.MAX_VALUE);
            distancias= new int [Integer.MAX_VALUE][Integer.MAX_VALUE];
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno destruirSistemaIngreso() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        listaCiudades.vaciar();
        return ret;
    }

    @Override
    public Retorno registrarCiudad(String Ciudad) {    
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        if(listaCiudades.cantElementos() < listaCiudades.getCantidad()){
            
        if (listaCiudades.obtenerElemento(Ciudad)==null){
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString="Se agrego la ciudad";
            listaCiudades.agregarInicio(Ciudad);
        }
        else {
           ret.valorString = "La ciudad ya existe";
           ret.resultado = Retorno.Resultado.ERROR;
        }
        }else{
            ret.resultado = Retorno.Resultado.ERROR;
            ret.valorString = "Se llego al limite de ciudades permitidas. ";
        }
        return ret;
    }

    @Override
    public Retorno RegistrarHospital(String Ciudad, String NombreHospital, int Capacidad, int Estrellas, int ranking){
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodociudad ciudadBuscada = listaCiudades.obtenerElemento(Ciudad);
        Listahospital listaHospDeCiudad = ciudadBuscada.getListaHospitales();
        if(ciudadBuscada == null){
            ret.valorString = "La Ciudad" + Ciudad + "no existe";
        }else if(listaHospDeCiudad.obtenerElemento(NombreHospital) != null){
            ret.valorString = "El hospital" + NombreHospital + "ya existe en " + Ciudad;
        }else if(Estrellas <= 0 || Estrellas > 5){
            ret.valorString = "El valor ingresado " + Estrellas + " no es válido: debe ser un numero entero entre 0 y 5";
        }else if(Capacidad < 0 ){
            ret.valorString = "El valor ingresado " + Capacidad + " no es válido: debe ser un numero entero mayor a 0";
        }else if(ranking != 0){
            ret.valorString = "Todos los hospitales deben registrarse con ranking 0";
        }else{
            listaHospDeCiudad.agregarInicio(NombreHospital, Capacidad, Estrellas, ranking);
            Nodohospital hospital = listaHospDeCiudad.obtenerElemento(NombreHospital);
            hospital.getListaPacientes().setCantidad(Capacidad);
           //listaHospDeCiudad.obtenerElemento(NombreHospital).getListaPacientes().setCantidad(Capacidad);
            
            ret.valorString = "El hospital se ha registrado con éxito";
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }


    @Override
    public Retorno ingresarServicio(String Ciudad, String Hospital, String Servicio) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        Nodociudad ciudadBuscada = listaCiudades.obtenerElemento(Ciudad);

        
        if(ciudadBuscada != null){
            Nodohospital hospitalBuscado = ciudadBuscada.getListaHospitales().obtenerElemento(Hospital);
            if (hospitalBuscado != null) {
            hospitalBuscado.getListaServicios().agregarInicio(Servicio);
            ret.valorString = "El servicio se ha registrado con éxito";
            
            }else{     
                ret.valorString = "El hospital" + Hospital + "no existe en " + Ciudad;
                ret.resultado = Retorno.Resultado.ERROR;    
            }
        }else{
            ret.valorString = "La Ciudad" + Ciudad + "no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        }  
        return ret;
    }

    @Override
    public Retorno borrarServicio(String Ciudad, String Hospital, String Servicio) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodociudad ciudadBuscada = listaCiudades.obtenerElemento(Ciudad);

        if (ciudadBuscada != null) {
            Nodohospital hospitalBuscado = ciudadBuscada.getListaHospitales().obtenerElemento(Hospital);
            if (hospitalBuscado != null) {
                Nodoservicio servicio = hospitalBuscado.getListaServicios().buscarelemento(Servicio);
                if (servicio != null) {
                    hospitalBuscado.getListaServicios().borrarelemento(Servicio);
                    ret.valorString = "El servicio se ha borrado con éxito";
                    ret.resultado = Retorno.Resultado.OK;
                } else {
                    ret.valorString = "El servicio" + Servicio + "no existe";
                    ret.resultado = Retorno.Resultado.ERROR;
                }

            } else {
                ret.valorString = "El hospital" + Hospital + "no existe en " + Ciudad;
                ret.resultado = Retorno.Resultado.ERROR;
            }
        } else {
            ret.valorString = "La Ciudad" + Ciudad + "no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }
    

    @Override
    public Retorno ingresarComentario(String Ciudad, String Hospital, String Comentario, int Ranking) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Nodociudad ciudadBuscada = listaCiudades.obtenerElemento(Ciudad);

        if (ciudadBuscada != null) {
            Nodohospital hospitalBuscado = ciudadBuscada.getListaHospitales().obtenerElemento(Hospital);
            if (hospitalBuscado != null) {

                if (Ranking <= 5 && Ranking > 0) {
                    PilaComentarios comentarios = hospitalBuscado.getPilaComentarios();
            
                    comentarios.push(Comentario, Ranking);
                    int total = 0;
                    int promedio;
                    int largo = 0;
                 
                    NodoPilaComentarios aux = comentarios.getTope();
                    while (aux != null && largo != comentarios.getCantElementos()) {
                        total += aux.getPuntaje();
                        aux = aux.getSiguiente();
                        largo = largo + 1;
                    }
                    promedio = total / largo;
                    
                    hospitalBuscado.setRanking(promedio);
                    
                    ret.valorString = "El comentario se ha ingresado con éxito";
                } else {
                    ret.valorString = "El ranking: " + Ranking + "ingresado se encuentra fuera del rango de 0-5";
                    ret.resultado = Retorno.Resultado.ERROR;
                }
            } else {
                ret.valorString = "El hospital" + Hospital + "no existe en " + Ciudad;
                ret.resultado = Retorno.Resultado.ERROR;
            }
        } else {
            ret.valorString = "La Ciudad" + Ciudad + "no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno realizarIngreso(int Paciente, String Ciudad, String Hospital) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
       //Nodopaciente paciente = new Nodopaciente(Paciente);
        Nodociudad ciudadBuscada = listaCiudades.obtenerElemento(Ciudad);
       
        if(ciudadBuscada != null){
            Nodohospital hospitalBuscado = ciudadBuscada.getListaHospitales().obtenerElemento(Hospital);
            if(hospitalBuscado != null){             
                Nodopaciente pacienteBuscadoRegistroHospital = hospitalBuscado.getListaPacientes().obtenerElemento(Paciente);
                Nodopaciente pacienteBuscadoFilaEspera = hospitalBuscado.getColaEspera().obtenerElemento(Paciente);
                int cantPacientes = hospitalBuscado.getListaPacientes().cantElementos();
                int capacidadHospital = hospitalBuscado.getCapacidad();
                
                if(pacienteBuscadoRegistroHospital == null || pacienteBuscadoFilaEspera == null){
                    if(pacienteBuscadoRegistroHospital == null && cantPacientes < capacidadHospital){
                    hospitalBuscado.getListaPacientes().agregarInicio(Paciente);
                    ret.valorString = "El Paciente ha sido ingresado con éxito en el " + Hospital;
                    ret.resultado = Retorno.Resultado.OK;
               
                }else{
                        hospitalBuscado.getColaEspera().agregarCola(Paciente);
                        ret.valorString = "El Paciente ha sido ingresado a la cola de espera del " + Hospital;
                        ret.resultado = Retorno.Resultado.OK;
                       
                }
                    
                }
            }else{
                ret.valorString = "El hospital" + Hospital + "no existe en " + Ciudad;
                ret.resultado = Retorno.Resultado.ERROR; 
            }
        }else{
            ret.valorString = "La Ciudad" + Ciudad + "no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }   

    
    @Override
    public Retorno cancelarIngreso(int Paciente, String Ciudad, String Hospital) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodociudad ciudadBuscada = listaCiudades.obtenerElemento(Ciudad);
     
        if(ciudadBuscada != null){
            Nodohospital hospitalBuscado = ciudadBuscada.getListaHospitales().obtenerElemento(Hospital);
            if(hospitalBuscado != null){
                
                Nodopaciente pacienteBuscadoRegistroHospital = hospitalBuscado.getListaPacientes().obtenerElemento(Paciente);
                Nodopaciente pacienteBuscadoFilaEspera = hospitalBuscado.getColaEspera().obtenerElemento(Paciente);
                if(pacienteBuscadoRegistroHospital != null || pacienteBuscadoFilaEspera != null){
                   if(pacienteBuscadoRegistroHospital != null){
                       
                    hospitalBuscado.getListaPacientes().borrarElemento(Paciente);        //quito el elemento
                    Object primero =  hospitalBuscado.getColaEspera().alFrente();        //agarro al primero en lista de espera
                    hospitalBuscado.getColaEspera().sacarPrimero();                      //y tmb lo borro de la lista
                    hospitalBuscado.getListaPacientes().agregarInicio(primero);          //lo agrego como nuevo paciente
                    ret.valorString = "El Paciente ha cancelado con éxito";
                    ret.resultado = Retorno.Resultado.OK;
                    
                   }else if(pacienteBuscadoFilaEspera != null){
                       
                        hospitalBuscado.getColaEspera().borrarElemento(Paciente);
                        ret.valorString = "El Paciente ha cancelado con éxito";
                        ret.resultado = Retorno.Resultado.OK; 
                    }
                }else{
                    ret.valorString = "El paciente " + Paciente + " no esta Registrado en el  " + Hospital;
                    ret.resultado = Retorno.Resultado.ERROR; 
                }
            }else{
                ret.valorString = "El hospital" + Hospital + "no existe en " + Ciudad;
                ret.resultado = Retorno.Resultado.ERROR; 
            }
        }else{
            ret.valorString = "La Ciudad" + Ciudad + "no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }
        

    @Override
    public Retorno trasladarPaciente(int Paciente, String CiudadO, String HospitalO, String CiudadD, String HospitalD) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Nodociudad ciudadBuscadaO = listaCiudades.obtenerElemento(CiudadO);
        Nodociudad ciudadBuscadaD = listaCiudades.obtenerElemento(CiudadD);
        Nodohospital hospitalBuscadoO = ciudadBuscadaO.getListaHospitales().obtenerElemento(HospitalO);
        Nodohospital hospitalBuscadoD = ciudadBuscadaD.getListaHospitales().obtenerElemento(HospitalD);
        if (ciudadBuscadaO == null) {
            ret.valorString = "La Ciudad" + CiudadO + "no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        } else if (ciudadBuscadaD == null) {
            ret.valorString = "La Ciudad" + CiudadD + "no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        } else if (hospitalBuscadoO == null) {
            ret.valorString = "El hospital" + HospitalO + "no existe en " + CiudadO;
            ret.resultado = Retorno.Resultado.ERROR;
        } else if (hospitalBuscadoD == null) {
            ret.valorString = "El hospital" + HospitalD + "no existe en " + CiudadD;
            ret.resultado = Retorno.Resultado.ERROR;
        } else if (hospitalBuscadoO.getListaPacientes().obtenerElemento(Paciente) != null) {
            hospitalBuscadoO.getListaPacientes().borrarElemento(Paciente);
            Object primero = hospitalBuscadoO.getColaEspera().alFrente();
            hospitalBuscadoO.getColaEspera().sacarPrimero();
            hospitalBuscadoO.getListaPacientes().agregarInicio(primero);
            if (hospitalBuscadoD.getListaPacientes().getCantidad() < hospitalBuscadoD.getCapacidad()) {
                hospitalBuscadoD.getListaPacientes().agregarInicio(Paciente);
                ret.valorString = "El Paciente ha sido trasladado a" + HospitalD +"con éxito";
            } else {
               // Nodopaciente nuevo = new Nodopaciente(Paciente);
                hospitalBuscadoD.getColaEspera().agregarCola(Paciente);
                ret.valorString = "El Paciente ha sido trasladado a la cola de espera del hospital " + HospitalD;
            }
        } else {
            ret.valorString = "El Paciente no se encuentra en el sistema de " + HospitalO;
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    
    @Override
    public Retorno listarServicios(String Ciudad, String Hospital) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodociudad ciudadBuscada = listaCiudades.obtenerElemento(Ciudad);
        Nodohospital hospitalBuscado = ciudadBuscada.getListaHospitales().obtenerElemento(Hospital);
        if(ciudadBuscada != null){
            if(hospitalBuscado != null){
                Listaservicio servicios = hospitalBuscado.getListaServicios();
                if(!servicios.esVacia()){
                    ret.valorString = " \n " + "Los servicios del  " + hospitalBuscado.getNombreHospital() +  " - " + ciudadBuscada.getNombreCiudad();
                    ret.valorString += servicios.mostrar();
                  
                }else{
                    ret.valorString = "El " + Hospital + " no tiene servicios";
                }
                    ret.resultado = Retorno.Resultado.OK;
            }else{
                ret.valorString = "El " + Hospital + " no existe en " + Ciudad;
                ret.resultado = Retorno.Resultado.ERROR;
            }
        }else{
            ret.valorString = "La Ciudad " + Ciudad + " no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }
    

    @Override
    public Retorno listarHospitalesCiudad(String Ciudad) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodociudad ciudadBuscada = listaCiudades.obtenerElemento(Ciudad);
        if (ciudadBuscada != null) {
            Listahospital hospitales = ciudadBuscada.getListaHospitales();
            if(!hospitales.esVacia()){
                
                ret.valorString = " \n " + "Hospitales de la ciudad " + Ciudad + ": ";
                ret.valorString += " \n" + hospitales.mostrar();
                ret.resultado = Retorno.Resultado.OK;
            }else{
                ret.valorString = "La ciudad " + Ciudad + " no tiene ningun Hospital";
                ret.resultado = Retorno.Resultado.OK;
            }
        
        }else{
            ret.valorString = "La Ciudad " + Ciudad + " no existe ";
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }  

    @Override
    public Retorno listarHospitalesRanking() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Nodociudad ciudad = listaCiudades.getPrimero();
        if(!listaCiudades.esVacia()){
            ret.valorString = "\n" + "Hospitales ordenados por ranking ";
            while(ciudad != null){
                ret.valorString += "\n" + ciudad.getNombreCiudad() + ": ";
                ret.valorString += "\n" + ciudad.getListaHospitales().mostrar2();
                ciudad = ciudad.getSiguiente();
            }
        }else{
            ret.valorString = "No hay ciudades registradas";
        }
        
        return ret;
    }

    @Override
    public Retorno listarComentarios(String Ciudad, String Hospital) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Nodociudad ciudadBuscada = listaCiudades.obtenerElemento(Ciudad);
        if(ciudadBuscada != null){
            Nodohospital hospitalBuscado = ciudadBuscada.getListaHospitales().obtenerElemento(Hospital);
            if(hospitalBuscado != null){
                PilaComentarios comentarios = hospitalBuscado.getPilaComentarios();
                if(!comentarios.isEmpty()){
                    ret.valorString = " \n " + "Comentarios del " + Hospital + ": ";
                    ret.valorString += " \n" + comentarios.mostrar();
                   
                }else{
                    ret.valorString = "El " + Hospital + " no tiene comentarios ";
                }
           
                ret.resultado = Retorno.Resultado.OK;
            }else{
                ret.valorString = "El hospital " + Hospital + " no esta registrado en " + Ciudad;
                ret.resultado = Retorno.Resultado.ERROR; 
            }
        }else{
            ret.valorString = "La ciudad " + Ciudad + " no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        }
        
        
        
        return ret;
    }

    @Override
    public Retorno listarEspera(String Ciudad, String Hospital) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Nodociudad ciudadBuscada = listaCiudades.obtenerElemento(Ciudad);
        if(ciudadBuscada != null){
            Nodohospital hospitalBuscado = ciudadBuscada.getListaHospitales().obtenerElemento(Hospital);
            if(hospitalBuscado != null){
                
                ColaEspera pacientes = hospitalBuscado.getColaEspera();
                if(!pacientes.esVacia()){
                   ret.valorString = " \n " + "Lista de espera del " + Hospital + ": ";
                   ret.valorString += " \n" + pacientes.mostrar();
                }else{
                    ret.valorString = "El " + Hospital + " no tiene pacientes en fila de espera";
                }
                ret.resultado = Retorno.Resultado.OK;
            }else{
                ret.valorString = "El " + Hospital + " no existe en " + Ciudad;
                ret.resultado = Retorno.Resultado.ERROR;
            }
        }else{
            ret.valorString = "La ciudad " + Ciudad + " no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        }
        
        
        
        
        
        return ret;
    }

    @Override
    public Retorno cargoDistancia(int[][] Ciudades, int origen, int destino, int distancia) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        
        Ciudades[origen][destino]=distancia;
//        Ciudades[1][0]=3;
//        Ciudades[0][2]=7;
//        Ciudades[2][0]=7;
//        Ciudades[0][3]=4;
//        Ciudades[3][0]=4;
//        
//        Ciudades[0][4]=3;
//        Ciudades[4][0]=3;
//        Ciudades[1][2]=2;
//        Ciudades[2][1]=2;
//        Ciudades[1][3]=3;
//        Ciudades[3][1]=3;
//        
//        Ciudades[1][4]=2;
//        Ciudades[4][1]=2;
//        Ciudades[2][3]=1;
//        Ciudades[3][2]=1;
//        Ciudades[3][5]=2;
//        Ciudades[5][2]=2;
//        
//        Ciudades[4][5]=1;
//        Ciudades[5][4]=1;
        
        return ret;
    }

    @Override
    public Retorno BuscarCamino(int[][] M, String origen, String destino) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
      
        // arreglar esto para que sean los parametros convertidos a numero de ciudad
        int desde = listaCiudades.obtenerposicion(origen); // obtener posicion daria 0
        int hasta = listaCiudades.obtenerposicion(destino); // obtener posicion daria 5
        int cantidad=M.length;
        int escala=0;
        int menor=Integer.MAX_VALUE;
        for (int i=0;i<cantidad;i++){
            if (M[desde][i]!=0 && M[hasta][i]!=0){
                if (menor>M[desde][i]+ M[hasta][i]){
                    menor=M[desde][i]+ M[hasta][i];
                    escala=i;
                }
            }
        
             
        }
        ret.valorString="El camino mas corto es " + listaCiudades.obtenerciudadenpos(desde) + " - " + listaCiudades.obtenerciudadenpos(escala) +" - " +listaCiudades.obtenerciudadenpos(hasta);
                
        return ret;
    }
    
   
    //METODO PARA LISTAR PACIENTES POR HOSPITAL     
    @Override
    public Retorno listarPacientesXHospital(String Ciudad, String Hospital) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.valorString = "";
        Nodociudad ciudadBuscada = listaCiudades.obtenerElemento(Ciudad);
        Nodohospital hospitalBuscado = ciudadBuscada.getListaHospitales().obtenerElemento(Hospital);
        if(ciudadBuscada != null && hospitalBuscado != null){
            
            
             Listapaciente pacientes = hospitalBuscado.getListaPacientes();
            if(!pacientes.esVacia()){
               
                ret.valorString = pacientes.mostrar();
             
            }  else{
                ret.valorString = "El " + Hospital + " no tiene ningun paciente";
            } 
            
            ret.resultado = Retorno.Resultado.OK;
        }
            return ret;
    }
}
