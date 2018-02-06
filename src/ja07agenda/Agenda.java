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
public class Agenda {
    private int anyo;
    private Pagina[] paginas;
    public Pagina abierta;
    
    Agenda(){}

    public Agenda(int anyo) {
        this.anyo = anyo;
        if(anyo % 4 == 0)
            bisiesto(true);
        else
            bisiesto(false);
    }
    private void bisiesto(boolean b){
        this.paginas=new Pagina[b ? 366 : 365];
        int dia=0;
        for (int i = 1; i <= 31; i++) {
            paginas[dia++] = new Pagina(i, 1);
        }
        for (int i = 1; i <= (b ? 29 : 28); i++) {
            paginas[dia++] = new Pagina(i, 2);
        }
        for (int i = 1; i <= 31; i++) {
            paginas[dia++] = new Pagina(i, 3);
        }
        for (int i = 1; i <= 30; i++) {
            paginas[dia++] = new Pagina(i, 4);
        }
        for (int i = 1; i <= 31; i++) {
            paginas[dia++] = new Pagina(i, 5);
        }
        for (int i = 1; i <= 30; i++) {
            paginas[dia++] = new Pagina(i, 6);
        }
        for (int i = 1; i <= 31; i++) {
            paginas[dia++] = new Pagina(i, 7);
        }
        for (int i = 1; i <= 31; i++) {
            paginas[dia++] = new Pagina(i, 8);
        }
        for (int i = 1; i <= 30; i++) {
            paginas[dia++] = new Pagina(i, 9);
        }
        for (int i = 1; i <= 31; i++) {
            paginas[dia++] = new Pagina(i, 10);
        }
        for (int i = 1; i <= 30; i++) {
            paginas[dia++] = new Pagina(i, 11);
        }
        for (int i = 1; i <= 31; i++) {
            paginas[dia++] = new Pagina(i, 12);
        }
        
    }
    private int posicionArrayPaginas(Pagina p){
        int posicionArray=-1;
        for (int i = 0; i < this.paginas.length; i++) {
            if(this.paginas[i].getDia()==p.getDia()&&this.paginas[i].getMes()==p.getMes())
                posicionArray=i;
        }
        return posicionArray;
    }
    
    
    public void añadirPagina(Pagina ab){
        int posArray=this.posicionArrayPaginas(ab);
        this.paginas[posArray]= ab;
    }
    public Pagina buscarPagina(int dia,int mes){
        Pagina p=new Pagina(dia,mes);
        int posArray=this.posicionArrayPaginas(p);
        return this.paginas[posArray];
    }
    public Pagina buscarCitasTitulo(String tit){
        Pagina pag=new Pagina(1,1);
        Cita cita=new Cita();
        boolean encontrado=false;
        int i=0;

        
        while(i <this.paginas.length&&!encontrado) {
            cita=this.paginas[i].buscarCitaTitulo(tit);
            if(cita!=null){
                pag.añadirCita(cita);
                pag.setDia(this.paginas[i].getDia());
                pag.setMes(this.paginas[i].getMes());
                encontrado=true;
            }
            i++;
        }
        if(encontrado)
            return pag;
        else
            return null;
    }
    public String listarCitasAgenda(){
        
        ArrayList<Cita> citas1=new ArrayList();//arraylist auxiliar
        
        String listado="";//un string de toda la info de la pagina
        for (int i = 0; i <this.paginas.length; i++) {
            citas1=this.paginas[i].getCitas();
            if(citas1!=null){
                listado+=this.paginas[i].listarPagina();
            }
            
        }
        return listado;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int año) {
        this.anyo = anyo;
    }
    
}
