package Arbol;

import java.util.ArrayList;

public class Nodo {
    private String token;
    private Nodo hijoIzq;
    private Nodo hijoDer;
    private boolean  hoja=false;
    private boolean anulable;
    private int id=0;
    private ArrayList<Integer> primero = new ArrayList<Integer>();
    private ArrayList<Integer> ultimo = new ArrayList<Integer>();


 
    
    public Nodo(String token){
        this.token = token;
    }

    public void setPrimero(ArrayList<Integer> primero){
        this.primero = primero;
    }

    public ArrayList<Integer> getPrimero(){
        return this.primero;
    }


public void setHijoIzq(Nodo hijoIzq){
        this.hijoIzq = hijoIzq;
    }
public void setHijoDer(Nodo hijoDer){
        this.hijoDer = hijoDer;
    }
public Nodo getHijoIzq(){
        return this.hijoIzq;
    }
public Nodo getHijoDer(){
        return this.hijoDer;
    }

 public void setId(int id){
        this.id = id;
    }
public int getId(){
        return this.id;
    }
    
    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public boolean isHoja(){
        return hoja;
    }

    public void setHoja(boolean hoja){
        this.hoja = hoja;
    }

    public boolean isAnulable(){
        return anulable;
    }

    public void setAnulable(boolean anulable){
        this.anulable = anulable;
    }

    public ArrayList<Integer> getUltimo(){
        return ultimo;
    }

    public void setUltimo(ArrayList<Integer> ultimo){
        this.ultimo = ultimo;
    }



   
   




}