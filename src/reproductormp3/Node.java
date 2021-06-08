package reproductormp3;

public class Node {
    public List dato;
    public Node sig,ant;
    
    public Node(List d){
        this(d,null,null);
    }
    
    public Node(List d,Node s,Node a){
        dato=d;
        sig=s;
        ant=a;
    }
}
