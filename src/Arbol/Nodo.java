package Arbol;

import java.util.ArrayList;

/**
 *
 * @author kriti
 */
public class Nodo {
    public String token;
    public String lexema;
    public int linea;
    public int column;
    
    public ArrayList<Nodo> hijos = new ArrayList<Nodo>();

    public Nodo(String token, String lexema, int linea, int column) {
        this.token = token;
        this.lexema = lexema;
        this.linea = linea;
        this.column = column;
        
        this.hijos = new ArrayList<Nodo>();
    }
    
    public void AddHijo(Nodo nuevo){
        this.hijos.add(nuevo);
    }
}
