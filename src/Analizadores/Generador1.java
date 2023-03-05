package Analizadores;
public class Generador1 {
    public static void main(String[] args) {
        try{
            String ruta = "src/Analizadores/";
            String opcFlex[] = {ruta+"A_lex.jflex","-d",ruta};
            jflex.Main.generate(opcFlex);
            
            String opcCup[] = {"-destdir", ruta, "-parser", "a_sintactico", ruta + "A_sintactico.cup"};
            java_cup.Main.main(opcCup);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

