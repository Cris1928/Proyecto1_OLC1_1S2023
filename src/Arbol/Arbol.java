package Arbol;
import java.io.File;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Arbol {

 
    public Nodo raiz;

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public void GraficarSintactico() {
        String grafica = "Digraph Arbol_Sintactico{\n\n" + GraficaNodos(this.raiz, "0") + "\n\n}";
        //System.out.println(grafica);
        //GenerarDot(grafica);
        graficar(grafica);

    }

    private String GraficaNodos(Nodo nodo, String i) {
        int k = 0;
        String r = "";
        String nodoTerm = nodo.token;
        nodoTerm = nodoTerm.replace("\"", "");
        r = "node" + i + "[label = \"" + nodoTerm + "\"];\n";

        for (int j = 0; j <= nodo.hijos.size() - 1; j++) {
            r = r + "node" + i + " -> node" + i + k + "\n";
            r = r + GraficaNodos(nodo.hijos.get(j), "" + i + k);
            k++;
        }

        if (!(nodo.lexema.equals(""))) {
            String nodoToken = nodo.lexema;
            nodoToken = nodoToken.replace("\"", "");
            r += "node" + i + "c[label = \"" + nodoToken + "\"];\n";
            r += "node" + i + " -> node" + i + "c\n";
        }

        return r;
    }



    public void GenerarJpg() {
        GenerarBat();
        Runtime aplicacion = Runtime.getRuntime();
        try {
            Thread.sleep(2000);
            aplicacion.exec("Arbol_Sintactico.bat");
            System.out.println("Ejecuto bat");
            try {
                try {
                    Desktop.getDesktop().open(new File("Arbol_Sintactico.jpg"));
                    System.out.println("Genero jpg");
                } catch (IOException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void GenerarBat() {
        String fic = "Arbol_Sintactico.bat";
        String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
        String fileInputPath = "Arbol_Sintactico.dot";
        String fileOutputPath = "Arbol_Sintactico.jpg";
        String tParam = "-Tjpg";
        String tOParam = "-o";

        FileWriter fichero = null;
        PrintWriter escritor = null;
        try {
            fichero = new FileWriter(fic);
            escritor = new PrintWriter(fichero);
            escritor.println("@echo off");
            escritor.println(dotPath + " " + tParam + " " + fileInputPath + " " + tOParam + " " + fileOutputPath);
            escritor.println("exit");
            escritor.close();
            fichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reportar() throws IOException {

        String file_input_path = "Arbol_Sintactico.dot";
        String do_path = "C:\\Program Files\\Graphviz\\bin\\dot.exe";

        String file_get_path = "Arbol_Sintactico.jpg";
        try {
            ProcessBuilder pBuilder;
            pBuilder = new ProcessBuilder(do_path, "-Tjpg", "-o", file_get_path, file_input_path);
            pBuilder.redirectErrorStream(true);
            pBuilder.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Desktop.getDesktop().open(new File(file_get_path));
    }

    public void graficar(String cadena) {

        StringBuilder dot = new StringBuilder();
        dot.append(cadena);

        try {

            File file = new File("GrafoAST.dot");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dot.toString());
            bw.close();
            ProcessBuilder pbuilder = new ProcessBuilder("dot", "-Tsvg", "-o", "Arbol_Sintactico.svg", "GrafoAST.dot");
            pbuilder.redirectErrorStream(true);
            System.out.println("Terminando...");
            pbuilder.start();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Arbol sintactico graficado.");
    }
    
}
