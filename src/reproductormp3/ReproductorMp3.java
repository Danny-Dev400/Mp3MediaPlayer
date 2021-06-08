
package reproductormp3;

import Pantallas.Pantalla1;
import Pantallas.Pantalla2;
import Controladores.ControlarP1;
import Controladores.ControlarP2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.text.html.HTML.Tag;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.ID3v11Tag;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class ReproductorMp3 {
    public static List ListaCanciones;
    public static List ListaCanciones2;
    
    public static ListaReproduccion ListaRepro;

    public static void main(String[] args) throws FileNotFoundException, JavaLayerException, CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, BasicPlayerException {
        //inicializar pantallas
        
        ListaCanciones = new List("Todo");
        ListaCanciones2 = new List("Mitad");
        ListaRepro = new ListaReproduccion();
        
        Pantalla1 p1=new Pantalla1();
        Pantalla2 p2=new Pantalla2();
        
        //inicializar controladores de pantallas
        
        ControlarP1 controlP1=new ControlarP1(p1,p2);
        ControlarP2 controlP2=new ControlarP2(p2);  
        


        File f = new File("C:\\Users\\danny\\Documents\\NetBeansProjects\\Proyecto Reproductor Mp3\\ReproductorMp3\\Canciones");
        File[] lista=f.listFiles();
        FileInputStream fis;
        String a;
        
        /*BasicPlayer pl = new BasicPlayer();
        pl.open(lista[1]);
        pl.play();
        pl.pause();*/
        
        
       
        for(int i =0; i<lista.length;i++){
            a=lista[i].getPath();
            AudioFile audio = AudioFileIO.read(lista[i]);
            org.jaudiotagger.tag.Tag tag = audio.getTag();
            FieldKey[] parametro = {FieldKey.ALBUM,  FieldKey.ARTIST, FieldKey.YEAR, 
                FieldKey.GENRE, FieldKey.TITLE, FieldKey.TRACK,FieldKey.AMAZON_ID 
            };            
            Cancion c= new Cancion(lista[i],a,tag.getFirst(FieldKey.TITLE),tag.getFirst(FieldKey.YEAR),
                    tag.getFirst(FieldKey.ARTIST),tag.getFirst(FieldKey.ALBUM),tag.getFirst(FieldKey.GENRE));
            ListaCanciones.agregarFinal(c);
            if(i%2==0){
                ListaCanciones2.agregarFinal(c);
            }
        }
        
        ListaRepro.agregarFinal(ListaCanciones);
        ListaRepro.agregarFinal(ListaCanciones2);
        ListaRepro.llenarLista();
        ListaRepro.llenarListaC(0);
        ListaCanciones.ObtenerDatos2();
        //p1.lblListRSonando.setText(p1.jListRep.getSelectedValue());
        //ListaCanciones.reproducirr(3);
        System.out.println(ListaCanciones.tamano());
        System.out.println(ListaCanciones2.tamano());
        
    }
    
}
