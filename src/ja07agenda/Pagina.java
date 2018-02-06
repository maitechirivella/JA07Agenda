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
public class Pagina {
    private int dia;
    private int mes;
    private ArrayList <Cita> citas=new ArrayList<>();
    Pagina(){}

    Pagina(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }
    
    public void añadirCita(Cita c){
        this.citas.add(c);
    }
    public void modificarCita(int pos,Cita c){
        this.citas.set(pos,c);
    }
    
    public void borrarCita(Cita c){
        for (int i = 0; i < this.citas.size(); i++) {
            if(this.citas.get(i).getHora()==c.getHora()&&this.citas.get(i).getMinutos()==c.getMinutos())
                this.citas.remove(i);
        }
    }
    
    public Cita buscarCita(int hora, int minutos){
        Cita c=null, temp;
        int i=0;
        boolean encontrado=false;
        while(i < this.citas.size()&&!encontrado) {
            temp=this.citas.get(i);
            if(temp.getHora()==hora&&temp.getMinutos()==minutos){
                encontrado=true;
                c=temp;
            }
            i++;    
        }
        return c;
    }
    public Cita buscarCitaTitulo(String tit){
        Cita c=new Cita();
        int i=0;
        boolean encontrado=false;
        while(i < this.citas.size()&&!encontrado) {
            c=this.citas.get(i);
            if(c.getTitulo().equals(tit)){
                encontrado=true;
            }
            i++;    
        }
        if(encontrado)
            return c;
        else
            return null;
    }
    

    public int buscarPosicionCita(int hora, int minutos){
        int pos=-1;
        int i=0;
        boolean encontrado=false;
        while(i < this.citas.size()&&!encontrado) {
            if(this.citas.get(i).getHora()==hora&&this.citas.get(i).getMinutos()==minutos){
                encontrado=true;
                pos=i;
            }
            i++;    
        }
        return pos;
    }
    public void listarCitas(){
        StringBuilder st=new StringBuilder(this.getDia()+ "/"+this.getMes()+"\n");
        if(this.citas.isEmpty())
            st.append("La pagina esta en blanco");
        else{
            for (int i = 0; i < this.citas.size(); i++) {
                st.append(this.citas.get(i).leerCita());
            }
        }
        System.out.println(st.toString());
    }
    public String listarPagina(){
        StringBuilder st=new StringBuilder(this.getDia()+ "/"+this.getMes()+"\n");
        
        for (int i = 0; i < this.citas.size(); i++) {
                st.append(this.citas.get(i).leerCita());
            }
        return st.toString();
    }
    public ArrayList<Cita> getCitas(){
        if(this.citas.isEmpty())
            return null;
        else
            return this.citas;
    }
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    
}
