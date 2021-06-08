package reproductormp3;

import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import Pantallas.Pantalla1;

public class Cancion {
    private int duracion;
    private double volumen=Pantalla1.getVolu();
    private File ruta;
    private String rutaS;
    private String Nombre;
    private String año;
    private String autor;
    private String albun;
    private String genero;
    BasicPlayer repro = new BasicPlayer();

    public Cancion(File ruta, String rutaS, String Nombre, String año, String autor, String albun, String genero) throws BasicPlayerException {
        this.ruta = ruta;
        this.rutaS = rutaS;
        this.Nombre = Nombre;
        this.año = año;
        this.autor = autor;
        this.albun = albun;
        this.genero = genero;
        repro.open(ruta);
    }
    
    public void Reproducir() throws BasicPlayerException{
        repro.play();
        repro.setGain(Pantalla1.getVolu());
    }
    public void pausa() throws BasicPlayerException{
        repro.pause();
    }
    public void reanudar() throws BasicPlayerException{
        repro.resume();
        repro.setGain(Pantalla1.getVolu());
    }
    public void detener() throws BasicPlayerException{
        repro.stop();
    }
    public void setVolumen(double vol) throws BasicPlayerException{
        repro.setGain(vol);
        volumen=vol;
    }
    public void prueba(){
        System.out.println(repro.getLineBufferSize());
        System.out.println(repro.getLineCurrentBufferSize());
    }
    public int getDuracion() {
        return duracion;
    }

    public File getRuta() {
        return ruta;
    }

    public String getRutaS() {
        return rutaS;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getAño() {
        return año;
    }

    public String getAutor() {
        return autor;
    }

    public String getAlbun() {
        return albun;
    }

    public String getGenero() {
        return genero;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setRuta(File ruta) {
        this.ruta = ruta;
    }

    public void setRutaS(String rutaS) {
        this.rutaS = rutaS;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAlbun(String albun) {
        this.albun = albun;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
   
    
}
