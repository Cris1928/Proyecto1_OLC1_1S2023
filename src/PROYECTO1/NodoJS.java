package PROYECTO1;
import Arbol.Nodo_AFD;
import java.util.List;

public class NodoJS {
    private List<Nodo_AFD> nodo1;
   private String nombre;

    public NodoJS( String nombre, List<Nodo_AFD> nodo1) {
        this.nodo1 = nodo1;
        this.nombre = nombre;
    }

    public List<Nodo_AFD> getNodo1() {
        return nodo1;
    }

    public void setNodo1(List<Nodo_AFD> nodo1) {
        this.nodo1 = nodo1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
