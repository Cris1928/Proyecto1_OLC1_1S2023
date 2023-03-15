package Arbol;

import java.util.List;

public class Nodo_transiciones {
   private String token;
    private List<Integer> id;
    private List<List<Integer>> List1;

    public Nodo_transiciones(String token, List<Integer> id, List<List<Integer>> List1) {
        this.token = token;
        this.id = id;
        this.List1 = List1;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Integer> getId() {
        return id;
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }

    public List<List<Integer>> getList1() {
        return List1;
    }

    public void setList1(List<List<Integer>> List1) {
        this.List1 = List1;
    }

    

   

    
}
