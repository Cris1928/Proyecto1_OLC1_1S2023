package Arbol;
import java.util.List;
public class Nodo_TablaTransiciones {
    List<Integer> S;
    List<String> Terminales;

    public Nodo_TablaTransiciones(List<Integer> S, List<String> Terminales) {
        this.S = S;
        this.Terminales = Terminales;
    }

    public List<Integer> getS() {
        return S;
    }

    public void setS(List<Integer> S) {
        this.S = S;
    }

    public List<String> getTerminales() {
        return Terminales;
    }

    public void setTerminales(List<String> Terminales) {
        this.Terminales = Terminales;
    }

    

}
