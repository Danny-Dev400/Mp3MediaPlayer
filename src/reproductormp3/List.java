package reproductormp3;

import Pantallas.Pantalla1;
import Pantallas.Pantalla2;
import static Pantallas.Pantalla1.listaM;
import java.io.IOException;
import java.util.ArrayList;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagException;

public class List {
    
    private Nodo cabeza,cola;
    private String nombre;
    public int tama=0,posSonando=0,posAntSonando=0;
    public boolean pausa=false,primeravez=true;
    
    public List(String n){
        cabeza=cola=null;
        this.nombre=n;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void ObtenerDatos() throws CannotReadException, IOException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, BasicPlayerException{
        Nodo aux=cabeza;
        String a;
        Pantalla1.listaM.removeAllElements();
        detenerr();
        while(aux!=null){
            Pantalla1.listaM.addElement(aux.dato.getNombre()+"//"+aux.dato.getAutor()+"//"+aux.dato.getAlbun()+"//"+aux.dato.getGenero());
            aux=aux.sig;
            //System.out.pri
        }
    }
    
    public void ObtenerDatos2() throws CannotReadException, IOException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, BasicPlayerException{
        Nodo aux=cabeza;
        while(aux!=null){
            Pantalla2.listaTodo.addElement(aux.dato.getNombre());
            aux=aux.sig;
            //System.out.pri
        }
    }
   
    public Cancion obtenerCancion(int pos){
        Nodo aux=cabeza;
        for(int i=0;i<pos;i++){
            aux=aux.sig;
        }
        Pantalla2.listaNueva.addElement(aux.dato.getNombre());
        return aux.dato;
    }
          
    public void reproducirr(int id) throws BasicPlayerException{
        Nodo aux=cabeza;
        Nodo aux2=cabeza;
        posSonando=id;
        for(int i=0;i<id;i++){
            aux=aux.sig;
        }
        aux.dato.Reproducir();
        if(primeravez){
            aux.dato.Reproducir();
            posAntSonando=posSonando;
            primeravez=false;
        }else{
            if(posAntSonando==posSonando){
                aux.dato.reanudar();
                posAntSonando=posSonando;
                System.out.println("si");
            }else{
                for(int i=0;i<posAntSonando;i++){
                    aux2=aux2.sig;
                }
                aux2.dato.detener();
                aux.dato.Reproducir();
                posAntSonando=posSonando;
                System.out.println("No");
            }
        }
        

    } 
    
    public void reanu(int id) throws BasicPlayerException{
        Nodo aux=cabeza;
        for(int i=0;i<id;i++){
            aux=aux.sig;
        }
        aux.dato.reanudar();
    } 
    
    public void MandarVol(double vol2) throws BasicPlayerException{
        Nodo aux=cabeza;
        for(int i=0;i<posSonando;i++){
            aux=aux.sig;
        } 
        aux.dato.setVolumen(vol2);
    }
    
    public void pruebas(int id){
        Nodo aux=cabeza;
        for(int i=0;i<posSonando;i++){
            aux=aux.sig;
        } 
        aux.dato.prueba();
    }
    
    public void pausar() throws BasicPlayerException{
        Nodo aux=cabeza;
        for(int i=0;i<posSonando;i++){
            aux=aux.sig;
        }
        aux.dato.pausa();
    } 
    
    public void detenerr() throws BasicPlayerException{
        Nodo aux=cabeza;
        for(int i=0;i<posSonando;i++){
            aux=aux.sig;
        }
        aux.dato.detener();
    }
    
    public boolean pausada(){
        return pausa;
    }
    
    public void OrdenarAZ(){
        Nodo temp=null,recorrer=cabeza;
        Cancion cAux;
        while(recorrer != cola){
            temp=recorrer.sig;
            while(temp!=null){
                if(recorrer.dato.getNombre().compareToIgnoreCase(temp.dato.getNombre()) > 0){
                    cAux=recorrer.dato;
                    recorrer.dato=temp.dato;
                    temp.dato=cAux;
                }
                temp=temp.sig;
            }
            recorrer=recorrer.sig;
        }
    }
    public void OrdenarZA(){
        Nodo temp=null,recorrer=cabeza;
        Cancion cAux;
        while(recorrer != cola){
            temp=recorrer.sig;
            while(temp!=null){
                if(recorrer.dato.getNombre().compareToIgnoreCase(temp.dato.getNombre()) < 0){
                    cAux=recorrer.dato;
                    recorrer.dato=temp.dato;
                    temp.dato=cAux;
                }
                temp=temp.sig;
            }
            recorrer=recorrer.sig;
        }
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
    
    /*public void pasarCanciones(List a){
        for(int i=0;i<a.tamano()-1;i++){
            agregarFinal(a.obtenerCancion(a.));
        }
    }*/

    
    public void VaciarLista(){
        cabeza=cola=null;
    }
    public int tamano(){
        Nodo aux=cabeza;
        tama=0;
        while(aux!=null){
            aux=aux.sig;
            tama++;
        }
        return tama;
    }
    
    public void agregarFinal(Cancion d){
        if(!empty()){
            cola=new Nodo(d,null,cola);
            cola.ant.sig=cola;
        }else{
            cabeza=cola=new Nodo(d);
        }
    }
    
    public void agregarInicio(Cancion d){
        if(!empty()){
            cabeza=new Nodo(d,cabeza,null);
            cabeza.sig.ant=cabeza;
        }else{
            cabeza=cola=new Nodo(d);
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
            if(pos>tamano() || pos<0){
                System.out.println("Numero invalido");
            }else{
                if(pos==0){
                    EliminarInicio();
                }else if(pos==tamano()-1){
                    EliminarFin();
                }else{
                    Nodo aux1=cabeza,aux2=cabeza.sig;  
                    int cont=1;
                    while(cont!=pos){
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

