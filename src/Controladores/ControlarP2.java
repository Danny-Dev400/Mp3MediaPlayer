package Controladores;

import Pantallas.Pantalla2;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static com.sun.awt.AWTUtilities.setWindowOpaque;
import reproductormp3.List;
import reproductormp3.ReproductorMp3;

public class ControlarP2 implements MouseListener{
    private Pantalla2 p2;
    public static List NewList= new List("hola");
    
    public ControlarP2(Pantalla2 p2){
        this.p2=p2;
        inicializar();
        this.p2.lblMinimizar.addMouseListener(this);
        this.p2.lblCerrar.addMouseListener(this);
        this.p2.lblGuardar.addMouseListener(this);
        this.p2.lblAgregar.addMouseListener(this);
    }
    
    private void inicializar(){
        this.p2.setSize(385, 550);
        setWindowOpaque(p2,false);
        this.p2.setLocationRelativeTo(p2);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getSource()==this.p2.lblCerrar){
            this.p2.setVisible(false);
        }
        else if(me.getSource()==this.p2.lblMinimizar){
            this.p2.setExtendedState(1);
        }
        else if(me.getSource()==this.p2.lblAgregar){
            int pos=p2.jListTodo.getSelectedIndex();
            NewList.agregarFinal(ReproductorMp3.ListaCanciones.obtenerCancion(pos));
        }        
        else if(me.getSource()==this.p2.lblGuardar){
            hacer();
            this.p2.setVisible(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    public void hacer(){
        List NewListC =new List(p2.txtNombreList.getText());
        NewListC=NewList;
        NewListC.setNombre(p2.txtNombreList.getText());
        ReproductorMp3.ListaRepro.agregarFinal(NewListC);
        ReproductorMp3.ListaRepro.llenarLista();
        Pantalla2.listaNueva.removeAllElements();
    }
}
