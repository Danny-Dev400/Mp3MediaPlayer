package Controladores;

import Pantallas.Pantalla1;
import Pantallas.Pantalla2;
import Controladores.ControlarP2;
import reproductormp3.List;
import reproductormp3.ListaReproduccion;
import reproductormp3.ReproductorMp3;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static com.sun.awt.AWTUtilities.setWindowOpaque;
import java.io.File; 
import java.io.PrintStream; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;


public class ControlarP1 implements MouseListener{
    private Pantalla1 p1;
    private Pantalla2 p2;
    
    public ControlarP1(Pantalla1 p1,Pantalla2 p2){
        this.p1=p1;
        this.p2=p2;
        inicializar();
    }
    
    private void inicializar(){
        this.p1.setSize(920, 550);
        this.p1.setVisible(true);
        setWindowOpaque(p1,false);
        this.p1.setLocationRelativeTo(null);
        this.p1.lblCerrar.addMouseListener(this);
        this.p1.lblMinimizar.addMouseListener(this);
        this.p1.lblRepetir.addMouseListener(this);
        this.p1.lblPause.addMouseListener(this);
        this.p1.lblAgregarLista.addMouseListener(this);
        this.p1.lblPlay.addMouseListener(this);
        this.p1.lblStop.addMouseListener(this);
        this.p1.lblSiguiente.addMouseListener(this);
        this.p1.lblAnterior.addMouseListener(this);
        this.p1.lblSeleccionar.addMouseListener(this);
        this.p1.lblBorrarCancion.addMouseListener(this);
        this.p1.lblOrdenarAZ.addMouseListener(this);
        this.p1.lblOrdenarZA.addMouseListener(this);
        //List listAux=new List("hola");
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource()==this.p1.lblCerrar){
            System.exit(0);
        }else if (me.getSource()==this.p1.lblMinimizar){
            for(int i=0;i<100;i++){
                System.out.println("ordene");
            }
            this.p1.setExtendedState(1);
        }
        else if (me.getSource()==this.p1.lblAgregarLista){
            ControlarP2.NewList.VaciarLista();
            this.p2.setVisible(true);
        }
        else if (me.getSource()==this.p1.lblSeleccionar){
            int pos=p1.jListRep.getSelectedIndex();
            try {
                try {
                    ReproductorMp3.ListaRepro.detenerSonando();
                    ReproductorMp3.ListaRepro.llenarListaC(pos);
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (CannotReadException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TagException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ReadOnlyFileException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidAudioFrameException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (me.getSource()==this.p1.lblPlay){
            int posL=p1.jListRep.getSelectedIndex();
            int posC=p1.jListCanciones.getSelectedIndex();
            p1.lblCancionSonando.setText(p1.jListCanciones.getSelectedValue());
            try {
                ReproductorMp3.ListaRepro.reproducirrr(posL,posC);
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (me.getSource()==this.p1.lblPause){
            int posL=p1.jListRep.getSelectedIndex();
            int posC=p1.jListCanciones.getSelectedIndex();
            //if(){
                try {
                    ReproductorMp3.ListaRepro.pausare(posL);
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                }
            //}
            
        }
        else if (me.getSource()==this.p1.lblStop){
            int posL=p1.jListRep.getSelectedIndex();
            try {
                ReproductorMp3.ListaRepro.detenerrr(posL);
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (me.getSource()==this.p1.lblBorrarCancion){
            int posL=p1.jListRep.getSelectedIndex();
            int posC=p1.jListCanciones.getSelectedIndex();
            try {
                ReproductorMp3.ListaRepro.BorrarCancion(posL, posC);
                ReproductorMp3.ListaRepro.llenarListaC(posL);
                p1.jListCanciones.setSelectedIndex(posC);
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CannotReadException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TagException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ReadOnlyFileException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidAudioFrameException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (me.getSource()==this.p1.lblSiguiente){
            int posL=p1.jListRep.getSelectedIndex(),posC;
            if(p1.jListCanciones.getSelectedIndex()==ReproductorMp3.ListaRepro.SaberTamanoLista(posL)-1){
                p1.jListCanciones.setSelectedIndex(0);
                posC=p1.jListCanciones.getSelectedIndex();
            }else{
                p1.jListCanciones.setSelectedIndex(p1.jListCanciones.getSelectedIndex()+1);
                posC=p1.jListCanciones.getSelectedIndex();
            }
            try {
                ReproductorMp3.ListaRepro.reproducirrr(posL,posC);
                p1.lblCancionSonando.setText(p1.jListCanciones.getSelectedValue());
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (me.getSource()==this.p1.lblAnterior){
            int posL=p1.jListRep.getSelectedIndex(),posC;
            if(p1.jListCanciones.getSelectedIndex()==0){
                p1.jListCanciones.setSelectedIndex(p1.jListCanciones.getSelectedIndex()+ReproductorMp3.ListaRepro.SaberTamanoLista(posL)-1);
                posC=p1.jListCanciones.getSelectedIndex();
            }else{
                p1.jListCanciones.setSelectedIndex(p1.jListCanciones.getSelectedIndex()-1);
                posC=p1.jListCanciones.getSelectedIndex();
            }
            try {
                ReproductorMp3.ListaRepro.reproducirrr(posL,posC);
                p1.lblCancionSonando.setText(p1.jListCanciones.getSelectedValue());
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        else if (me.getSource()==this.p1.lblOrdenarAZ){
            int pos=p1.jListRep.getSelectedIndex();
            try {
                ReproductorMp3.ListaRepro.detenerrr(pos);
                ReproductorMp3.ListaRepro.OrdenAZ(pos);
                try {
                    ReproductorMp3.ListaRepro.llenarListaC(pos);
                } catch (CannotReadException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TagException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ReadOnlyFileException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidAudioFrameException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(ReproductorMp3.ListaRepro.SaberTamanoLista(pos));
        }
        else if (me.getSource()==this.p1.lblOrdenarZA){
            int pos=p1.jListRep.getSelectedIndex();
            try {
                ReproductorMp3.ListaRepro.detenerrr(pos);
                ReproductorMp3.ListaRepro.OrdenZA(pos);
                try {
                    ReproductorMp3.ListaRepro.llenarListaC(pos);
                } catch (CannotReadException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TagException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ReadOnlyFileException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidAudioFrameException ex) {
                    Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ControlarP1.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(ReproductorMp3.ListaRepro.SaberTamanoLista(pos));
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
