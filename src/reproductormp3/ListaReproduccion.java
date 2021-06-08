package reproductormp3;

import Pantallas.Pantalla1;
import java.io.IOException;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

public class ListaReproduccion {
    
    private Node cabeza,cola;
    public int tama=0,posActual=1;
    public boolean pausa=false,primeravez=true;
    
    public ListaReproduccion(){
        cabeza=cola=null;
    }
    
    public void llenarLista(){
        Node aux=cabeza;
        tama=0;
        Pantalla1.listaR.removeAllElements();
        while(aux!=null){
            Pantalla1.listaR.addElement(aux.dato.getNombre());
            aux=aux.sig;
        } 
    }
    
    public void llenarListaC(int posAc) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, BasicPlayerException{
        Node aux=cabeza;
        tama=0;
        for(int i=0;i<posAc;i++){
            aux=aux.sig;
        }
        aux.dato.ObtenerDatos();
    }
    public void reproducirrr(int idL, int idC) throws BasicPlayerException{
        Node aux=cabeza;
        for(int i=0;i<idL;i++){
            aux=aux.sig;
        }
        aux.dato.reproducirr(idC);
    } 
    
    public void reanud(int idL, int idC) throws BasicPlayerException{
        Node aux=cabeza;
        for(int i=0;i<idL;i++){
            aux=aux.sig;
        }
        aux.dato.reanu(idC);
    } 

    public void MandarVolumen(int pos,double volu) throws BasicPlayerException{
        Node aux=cabeza;
        for(int i=0;i<pos;i++){
            aux=aux.sig;
        } 
        aux.dato.MandarVol(volu);
    }
    
    public void pausare(int idL) throws BasicPlayerException{
        Node aux=cabeza;
        for(int i=0;i<idL;i++){
            aux=aux.sig;
        }
        aux.dato.pausar();
    } 
    
    public void detenerrr(int idL) throws BasicPlayerException{
        Node aux=cabeza;
        for(int i=0;i<idL;i++){
            aux=aux.sig;
        }
        aux.dato.detenerr();
    }
    
    public void OrdenAZ(int idL) throws BasicPlayerException{
        Node aux=cabeza;
        for(int i=0;i<idL;i++){
            aux=aux.sig;
        }
        aux.dato.OrdenarAZ();
    }
    
    public void OrdenZA(int idL) throws BasicPlayerException{
        Node aux=cabeza;
        for(int i=0;i<idL;i++){
            aux=aux.sig;
        }
        aux.dato.OrdenarZA();
    }
    public void BorrarCancion(int idL,int idC) throws BasicPlayerException{
        Node aux=cabeza;
        for(int i=0;i<idL;i++){
            aux=aux.sig;
        }
        aux.dato.detenerr();
        aux.dato.EliminarPos(idC);
    }
    
    public void detenerSonando() throws BasicPlayerException{
        Node aux=cabeza;
        while(aux!=null){
            aux.dato.detenerr();
            aux=aux.sig;
        }
    }
    
    public boolean pausada(){
        return pausa;
    }
    
    public boolean empty(){
        if(cabeza==null && cola==null){
            System.out.println("La lista esta vacia");
            return true;
        }else{
            System.out.println("La no lista esta vacia");
            return false;
        }
    }
    
    public int tamano(){
        Node aux=cabeza;
        tama=0;
        while(aux!=null){
            aux=aux.sig;
            tama++;
        }
        return tama;
    }
    
    public int SaberTamanoLista(int idL){
        Node aux=cabeza;
        for(int i=0;i<idL;i++){
            aux=aux.sig;
        }
        return aux.dato.tamano();
    }
    
    public void agregarFinal(List d){
        if(!empty()){
            cola=new Node(d,null,cola);
            cola.ant.sig=cola;
        }else{
            cabeza=cola=new Node(d);
        }
    }
    
    public void agregarInicio(List d){
        if(!empty()){
            cabeza=new Node(d,cabeza,null);
            cabeza.sig.ant=cabeza;
        }else{
            cabeza=cola=new Node(d);
        }
    }
    
    
    public void EliminarInicio(){
        if(empty()){
            System.out.println("Esta vacia");
        }
        else{
            if(cola==cabeza){
                System.out.println("El dato eliminado es: ["+cabeza.dato+"]");
                cabeza=cola=null;
            }else{
                System.out.println("El dato eliminado es: ["+cabeza.dato+"]");
                cabeza=cabeza.sig;
                cabeza.ant=null;
            }
        }
    }
    
    public void EliminarFin(){
        if(empty()){
            System.out.println("Esta vacia");
        }
        else{
            if(cola==cabeza){
                System.out.println("El dato eliminado es: ["+cola.dato+"]");
                cabeza=cola=null;
            }else{
                System.out.println("El dato eliminado es: ["+cola.dato+"]");
                cola=cola.ant;
                cola.sig=null;
            }
        }
    }
    
    public void EliminarPos(int pos){
        if(empty()){
            System.out.println("Esta vacia");
        }else{
            if(pos>tamano() || pos<1){
                System.out.println("Numero invalido");
            }else{
                if(pos==1){
                    EliminarInicio();
                }else if(pos==tamano()){
                    EliminarFin();
                }else{
                    Node aux1=cabeza,aux2=cabeza.sig;  
                    int cont=1;
                    while(cont!=pos-1){
                        aux1=aux1.sig;
                        aux2=aux2.sig;
                        cont++;
                    }
                    System.out.println("El dato eliminado es: ["+aux2.dato+"]");
                    aux1.sig=aux2.sig;
                    aux2.sig.ant=aux1;
                }
            }
        }
    }
    
    
}
