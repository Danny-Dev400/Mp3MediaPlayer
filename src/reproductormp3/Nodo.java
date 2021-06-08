package reproductormp3;

public class Nodo {
    public Cancion dato;
    public Nodo sig,ant;
    
    public Nodo(Cancion d){
        this(d,null,null);
    }
    
    public Nodo(Cancion d,Nodo s,Nodo a){
        dato=d;
        sig=s;
        ant=a;
    }

}
