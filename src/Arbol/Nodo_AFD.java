package Arbol;

import java.util.List;

public class Nodo_AFD {
    private String S;
    private String tokens;
    private boolean estado;
    private String S_ant;
    private int id;
    private List<Integer> ids;

    public Nodo_AFD(String S_ant, String tokens,int id, List<Integer> ids,String S ,boolean estado) {
        this.S = S;
        this.tokens = tokens;
        this.estado = estado;
        this.S_ant= S_ant;
        this.ids= ids;
        this.id= id;
    }

    public String getS() {
        return S;
    }

    public void setS(String S) {
        this.S = S;
    }


    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getS_ant() {
        return S_ant;
    }

    public void setS_ant(String S_ant) {
        this.S_ant = S_ant;
    }

    public String getTokens() {
        return tokens;
    }

    public void setTokens(String tokens) {
        this.tokens = tokens;
    }

    public List<Integer> getIds() {
        return ids;
    }


    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
