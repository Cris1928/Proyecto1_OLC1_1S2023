package PROYECTO1;

public class Nodo_conj {
    private String token;
    private String expre;

    public Nodo_conj(String token, String expre) {
        this.token = token;
        this.expre = expre;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpre() {
        return expre;
    }

    public void setExpre(String expre) {
        this.expre = expre;
    }

}
