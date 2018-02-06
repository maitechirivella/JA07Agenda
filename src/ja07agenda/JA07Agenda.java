/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ja07agenda;

import java.util.*;

/**
 *
 * @author usuario
 */
public class JA07Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //modificaciones para github
        Calendar fecha;
        Scanner teclado=new Scanner(System.in);
        int opcion;
        Agenda agenda;
        int hora,minutos,dia,mes,anyo,posicion;
        String texto,titulo;
        Cita cita1,cita2;
        Pagina pagina1;
        String listadoAgenda;
        
        System.out.println("Introduce el año de la nueva agenda");
        anyo=teclado.nextInt();
        agenda=new Agenda(anyo);
        System.out.println("\n\n"+"    Citas "+agenda.getAnyo());
        
        do {
            imprimirMenu();
            opcion=teclado.nextInt();
            teclado.nextLine();
            switch(opcion){
                case 1:
                    do{
                    System.out.println("Introduce dia");
                    dia=teclado.nextInt();
                    }while(!validarDia(dia));
                    do{
                    System.out.println("Introduce mes");
                    mes=teclado.nextInt();
                    }while(!validarMes(mes));
                    agenda.abierta=agenda.buscarPagina(dia,mes);
                    System.out.println("Pagina seleccionada dia "+agenda.abierta.getDia()+" del mes "+agenda.abierta.getMes());
                    break;
                case 2:
                    do{
                    System.out.println("Introduce hora");
                    hora=teclado.nextInt();
                    }while(!validarHora(hora));
                    do{
                    System.out.println("Introduce minutos");
                    minutos=teclado.nextInt();
                    }while(!validarMinutos(minutos));
                    System.out.println("Introduce titulo");
                    teclado.nextLine();
                    titulo=teclado.nextLine();
                    System.out.println("Introduce texto");
                    texto=teclado.nextLine();
                    cita1=agenda.abierta.buscarCita(hora, minutos);
                    if(cita1==null){
                        cita2=new Cita(hora,minutos,titulo,texto);
                        agenda.abierta.añadirCita(cita2);
                        agenda.añadirPagina(agenda.abierta);
                        System.out.println("Cita guardada");
                    }else{
                        System.out.println("Cita no guardada, ya existe una cita a las "+hora+" horas "+minutos+" minutos");
                        cita1=agenda.abierta.buscarCita(hora,minutos);
                        System.out.println(cita1.leerCita());
                    }
                    break;
                case 3:
                    do{
                    System.out.println("Introduce hora de la cita a borrar");
                    hora=teclado.nextInt();
                    }while(!validarHora(hora));
                    do{
                    System.out.println("Introduce minutos");
                    minutos=teclado.nextInt();
                    }while(!validarMinutos(minutos));
                    cita1=agenda.abierta.buscarCita(hora, minutos);
                    if(cita1==null){
                        System.out.println("No existe ninguna cita a las "+hora+" horas y "+minutos+" minutos");
                    }else{
                        agenda.abierta.borrarCita(cita1);
                        agenda.añadirPagina(agenda.abierta);
                    }
                    break;
                case 4:
                    System.out.println("Introduce titulo");
                    titulo=teclado.nextLine();
                    pagina1=agenda.buscarCitasTitulo(titulo);
                    if(pagina1==null)
                        System.out.println("No existe ninguna cita con ese titulo");
                    else
                        System.out.println(pagina1.listarPagina()); 
                    break;
                case 5:
                    do{
                    System.out.println("Introduce hora de la cita a modificar");
                    hora=teclado.nextInt();
                    }while(!validarHora(hora));
                    do{
                    System.out.println("Introduce minutos");
                    minutos=teclado.nextInt();
                    }while(!validarMinutos(minutos));
                    System.out.println("Introduce nuevo titulo");
                    teclado.nextLine();
                    titulo=teclado.nextLine();
                    System.out.println("Introduce nuevo texto");
                    texto=teclado.nextLine();
                    posicion=agenda.abierta.buscarPosicionCita(hora, minutos);
                    if(posicion==-1){
                        System.out.println("No existe ninguna cita a las "+hora+" horas y "+minutos+" minutos");
                    }else{
                        cita1=new Cita(hora,minutos,titulo,texto);
                        agenda.abierta.modificarCita(posicion, cita1);
                        agenda.añadirPagina(agenda.abierta);
                        System.out.println("Cita modificada");
                    }
                    break;
                case 6:
                    System.out.println("Introduce titulo");
                    titulo=teclado.nextLine();
                    pagina1=agenda.buscarCitasTitulo(titulo);
                    
                    pagina1.listarCitas();
                    break;
                case 7:
                    listadoAgenda=agenda.listarCitasAgenda();
                    if(listadoAgenda=="")
                        System.out.println("No hay ninguna cita en la agenda");
                    else
                        System.out.println(listadoAgenda);
                    
                    break;
                case 8:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Introduce una opcion valida");
                    break;
            }
            
        } while (opcion!=8);
        
    }
    public static void imprimirMenu(){
        System.out.println("1. Seleccionar Pagina");
        System.out.println("2. Nueva cita");
        System.out.println("3. Borrar cita");
        System.out.println("4. Buscar cita");
        System.out.println("5. Modificar cita");
        System.out.println("6. Listar citas por titulo");
        System.out.println("7. Listar todas las citas de la agenda");
        System.out.println("8. Salir");
    }
    public static boolean validarDia(int d){
        if(d<31&&d>0)
            return true;
        else
            return false;
    }
    public static boolean validarMes(int m){
        if(m<13&&m>0)
            return true;
        else
            return false;
    }
    public static boolean validarHora(int h){
        if(h<25&&h>=0)
            return true;
        else
            return false;
    }
    public static boolean validarMinutos(int m){
        if(m<61&&m>=0)
            return true;
        else
            return false;
    }
}
