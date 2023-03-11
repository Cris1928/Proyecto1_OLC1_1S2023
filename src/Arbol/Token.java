package Arbol;
import java.util.ArrayList;
import java.util.List;


public class Token {
    List<Nodo_siguientes> listas = new ArrayList<Nodo_siguientes>();
    List<String> listaH = new ArrayList<>();
    private Nodo Arbol;
    private int num=1;
    public String complet="";
    public Token(Nodo Arbol){
        Nodo raiz = new Nodo(".");
        Nodo alm= new Nodo("#");
        alm.setHoja(true);
        alm.setAnulable(false);
        raiz.setHijoDer(alm);
        raiz.setHijoIzq(Arbol);

        this.Arbol = raiz;
        asignar_id(this.Arbol);
        num=0;
        metodoArbol(this.Arbol);
        
        String Tabla="";
        String grapviz="Digraph Arbol_Sintactico{\n\n" + Arobol_grafica(this.Arbol,num) + "\n\n}";

        System.out.println(grapviz);
        System.out.println("--------------------------------------------------------------------------------------");

       // System.out.println(Tabla);
   /*     for (int i = 0; i < listas.size(); i++) {
            System.out.println("Primero: "+listas.get(i).getList1()+"  Ultimo: "+listas.get(i).getList2());
        }*/
        System.out.println("--------------------------------------------------------------------------------------");
        int con=1;
        String c="";
        for (int i = 0; i < listaH.size(); i++) {
            c="";

  //!          System.out.println(listaH.get(i));

      /*     for (int j = 0; j < listas.size(); j++) {
                if (listas.get(j).getList1().contains(con)){
                    System.out.println("Primero: "+listas.get(j).getList1());
                }
                if (listas.get(j).getList2().contains(con)){
                    System.out.println("Ultimo: "+listas.get(j).getList2());
                }
            }*/

      //      if(listaH.get(i)=="#"){
        //        con++;
          //      complet+="<tr><td bgcolor=\"yellow\"> "+listaH.get(i)+" </td><td bgcolor=\"#77ff33\">"+con+" </td><td bgcolor=\"orange\">"+c+" </td></tr>\n";
    //        }else{


            for (int j = 0; j < listas.size(); j++) {
                if (listas.get(j).getList1().contains(con)){
                   for (int k = 0; k < listas.get(j).getList2().size(); k++) {

                       //   System.out.println("Siguiente: "+listas.get(j).getList2().get(k)); 
                          c+=listas.get(j).getList2().get(k)+",";

                       
                   }
                }
        
            }
            complet+="<tr><td bgcolor=\"yellow\"> "+listaH.get(i)+" </td><td bgcolor=\"#77ff33\">"+con+" </td><td bgcolor=\"orange\">"+c+" </td></tr>\n";
          //  System.out.println(complet);
            con++;
    //         }

        }
        Tabla +="digraph {" 
         +"    node [ shape=none fontname=Helvetica ]" 
        +"     n4 [ label = <" 
             +"  <table border=\"4 \">" 
              +"    <tr><td colspan=\"2\" bgcolor=\"red\">Hoja</td><td colspan=\"2\" bgcolor=\"red\">Siguiente</td></tr>" 
              +complet
           +"   </table>" 
           +"   > ]" 
            +" {rank=same n4}" 
         +"  }";
        System.out.println(Tabla);

        Tabla="";
    }

public void asignar_id(Nodo nodo){
        if (nodo == null){
            return;
        }
        if (nodo.isHoja()){
            nodo.setId(num);
            num+=1;
            return;
        }
          
        asignar_id(nodo.getHijoIzq());
        asignar_id(nodo.getHijoDer());
    }

    public void metodoArbol(Nodo actual){
        if (actual == null){
            return;
        }
        if (actual.isHoja()){

            actual.getPrimero().add(actual.getId());
            actual.getUltimo().add(actual.getId()); 

            return;
        }
        metodoArbol(actual.getHijoIzq());
        metodoArbol(actual.getHijoDer());

        //aqui la tabla |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        if (actual.getToken().equals("*")){
            actual.setAnulable(true);
            
            actual.getPrimero().addAll(actual.getHijoIzq().getPrimero());
            actual.getUltimo().addAll(actual.getHijoIzq().getUltimo());
//--------            complet+="<tr><td bgcolor=\"yellow\"> "+actual.getHijoIzq().getToken()+" </td><td bgcolor=\"#77ff33\">"+actual.getHijoIzq().getUltimo()+" </td><td bgcolor=\"orange\">"+actual.getHijoDer().getPrimero()+" </td></tr>\n";
            listas.add(new Nodo_siguientes(actual.getHijoIzq().getUltimo(),actual.getHijoDer().getPrimero()));

            // System.out.println("******************************"+actual.getHijoIzq().getToken()+" . "+actual.getHijoIzq().getUltimo()+" . "+actual.getHijoDer());

        }else if (actual.getToken().equals("|")){
            actual.setAnulable(actual.getHijoIzq().isAnulable() || actual.getHijoDer().isAnulable());
            actual.getPrimero().addAll(actual.getHijoIzq().getPrimero());
            actual.getPrimero().addAll(actual.getHijoDer().getPrimero());
            actual.getUltimo().addAll(actual.getHijoIzq().getUltimo());
            actual.getUltimo().addAll(actual.getHijoDer().getUltimo());
    
        }else if (actual.getToken().equals(".")){
            actual.setAnulable(actual.getHijoIzq().isAnulable() && actual.getHijoDer().isAnulable());
            if (actual.getHijoIzq().isAnulable()){
                actual.getPrimero().addAll(actual.getHijoIzq().getPrimero());
                actual.getPrimero().addAll(actual.getHijoDer().getPrimero());
//------                complet+="<tr><td bgcolor=\"yellow\"> "+actual.getHijoIzq().getToken()+" </td><td bgcolor=\"#77ff33\">"+actual.getHijoIzq().getUltimo()+" </td><td bgcolor=\"orange\">"+actual.getHijoDer().getPrimero()+" </td></tr>\n";
                listas.add(new Nodo_siguientes(actual.getHijoIzq().getUltimo(),actual.getHijoDer().getPrimero()));
            }else{
                actual.getPrimero().addAll(actual.getHijoIzq().getPrimero());
//------                complet+="<tr><td bgcolor=\"yellow\"> "+actual.getHijoIzq().getToken()+" </td><td bgcolor=\"#77ff33\">"+actual.getHijoIzq().getUltimo()+" </td><td bgcolor=\"orange\">"+actual.getHijoDer().getPrimero()+" </td></tr>\n";
                listas.add(new Nodo_siguientes(actual.getHijoIzq().getUltimo(),actual.getHijoDer().getPrimero()));
            }
            if (actual.getHijoDer().isAnulable()){
                actual.getUltimo().addAll(actual.getHijoIzq().getUltimo());
                actual.getUltimo().addAll(actual.getHijoDer().getUltimo());
           //     complet+="<tr><td bgcolor=\"yellow\"> "+actual.getHijoIzq().getToken()+" </td><td bgcolor=\"#77ff33\">"+actual.getHijoIzq().getUltimo()+" </td><td bgcolor=\"orange\">"+actual.getHijoDer().getPrimero()+" </td></tr>\n";
            }else{
                actual.getUltimo().addAll(actual.getHijoDer().getUltimo());
          //      complet+="<tr><td bgcolor=\"yellow\"> "+actual.getHijoIzq().getToken()+" </td><td bgcolor=\"#77ff33\">"+actual.getHijoIzq().getUltimo()+" </td><td bgcolor=\"orange\">"+actual.getHijoDer().getPrimero()+" </td></tr>\n";
            }
            
        }else if (actual.getToken().equals("+")){
            actual.setAnulable(actual.getHijoIzq().isAnulable());
            actual.getPrimero().addAll(actual.getHijoIzq().getPrimero());
            actual.getUltimo().addAll(actual.getHijoIzq().getUltimo());
//------            complet+="<tr><td bgcolor=\"yellow\"> "+actual.getHijoIzq().getToken()+" </td><td bgcolor=\"#77ff33\">"+actual.getHijoIzq().getUltimo()+" </td><td bgcolor=\"orange\">"+actual.getHijoIzq().getPrimero()+" </td></tr>\n";
            listas.add(new Nodo_siguientes(actual.getHijoIzq().getUltimo(),actual.getHijoIzq().getPrimero()));
           // System.out.println("****************************** . "+actual.getHijoIzq().getUltimo()+" . "+actual.getHijoDer());

        //    complet+="<tr><td bgcolor=\"yellow\"> "+actual.getHijoIzq().getToken()+" </td><td bgcolor=\"#77ff33\">"+actual.getHijoIzq().getUltimo()+" </td><td bgcolor=\"orange\">"+actual.getHijoDer().getPrimero()+" </td></tr>\n";
        }else if (actual.getToken().equals("?")){
            actual.setAnulable(true);
            actual.getPrimero().addAll(actual.getHijoIzq().getPrimero());
            actual.getUltimo().addAll(actual.getHijoIzq().getUltimo());


        }
    //    else if (actual.getToken().equals("#")){
      //      actual.setAnulable(false);
        //}



    }

    public String Arobol_grafica(Nodo nodo, int n){
        String cadena = "";
        num+=1;
        int actual = num;

        if (nodo == null){
            num-=1;
            
            return cadena;
        }
        if (nodo.isHoja()){
            String nodoTerm = nodo.getToken().replace("\"", "");
            cadena+="n"+actual+"[\n "
               +"  label=<\n"
              + "<TABLE BGCOLOR=\"bisque\">\n" 
            + "<TR>\n" 
                + " <TD COLSPAN=\"3\"  BGCOLOR=\"Red\">"+nodo.isAnulable()+"</TD>\n " 
                + "<TD ROWSPAN=\"2\" BGCOLOR=\"Orange\" \n" 
                   +"  VALIGN=\"bottom\" ALIGN=\"right\">"+nodo.getUltimo()+"</TD> \n"
            +" </TR>\n "
            + " <TR>\n "
             + "  <TD COLSPAN=\"2\" ROWSPAN=\"2\"  BGCOLOR=\"#3690c0\">\n "
               + " "+nodo.getPrimero()+"\n"
              + " </TD> \n"
             + "  <TD BGCOLOR=\"white\"  BORDER=\"4\">"+nodoTerm+"</TD> \n "
            +"</TR>\n"
            + " <TR>\n "
              + " <TD COLSPAN=\"2\" ALIGN=\"right\" PORT=\"there\"  BGCOLOR=\"Green\">"+nodo.getId()+"</TD>\n "
            + " </TR>\n "
          + " </TABLE>> \n"
          + "   ]\n";
          listaH.add(nodoTerm);
        }
        else{
            String nodoTerm = nodo.getToken().replace("\"", "");
            cadena+="n"+actual+"[\n "
               +"  label=<\n"
              + "<TABLE BGCOLOR=\"bisque\">\n" 
            + "<TR>\n" 
                + " <TD COLSPAN=\"3\"  BGCOLOR=\"Red\">"+nodo.isAnulable()+"</TD>\n " 
                + "<TD ROWSPAN=\"2\" BGCOLOR=\"Orange\" \n" 
                   +"  VALIGN=\"bottom\" ALIGN=\"right\">"+nodo.getUltimo()+"</TD> \n"
            +" </TR>\n "
            + " <TR>\n "
             + "  <TD COLSPAN=\"2\" ROWSPAN=\"2\"  BGCOLOR=\"#3690c0\">\n "
               + " "+nodo.getPrimero()+"\n"
              + " </TD> \n"
             + "  <TD BGCOLOR=\"white\"  BORDER=\"4\">"+nodoTerm+"</TD> \n "
            +"</TR>\n"
          + " </TABLE>> \n"
          + "   ]\n";
          
        }
        if (n!=0){
            cadena += "n" + n + "->n" + actual + "\n";
        }
        cadena += Arobol_grafica(nodo.getHijoIzq(), actual);
        cadena += Arobol_grafica(nodo.getHijoDer(), actual);
        return cadena;
        
    }

}
