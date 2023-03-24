package Arbol;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.SupportedOptions;

import java.util.Collections;
import jflex.StdOutWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import PROYECTO1.NodoJS;
import PROYECTO1.Ventana_principal;
//import PROYECTO1.NodoJS;
import PROYECTO1.Ventana_principal.*;
import java.awt.Desktop;
import java.lang.System;
public class Token {
    List<Nodo_estados> estados_trans = new ArrayList<Nodo_estados>();
    List<Nodo_siguientes> listas = new ArrayList<Nodo_siguientes>();
    List<Nodo_transiciones> listas2 = new ArrayList<Nodo_transiciones>();
    List<String> listaH = new ArrayList<>();
    List<Nodo_aux> listaaux = new ArrayList<Nodo_aux>();
    List<Nodo_TablaTransiciones> TablaT = new ArrayList<Nodo_TablaTransiciones>();
    List<Nodo_AFD> AFD = new ArrayList<Nodo_AFD>();
    List<List<Nodo_AFD> > AFD2 = new ArrayList<List<Nodo_AFD> >();
    List<String> llll = new ArrayList<>();
    List<Integer> listaPrimer = new ArrayList<>();
    int primer=0;
    private Nodo Arbol;
    private int num=1;
    private int verificador =0;
    public String complet="";
    public String complet2="";
    public String complet3="";
    public String compew="";
    public int nodo=1;
    
    public Token(Nodo Arbol, String nio){
        
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
        String Transiciones="";
        String graf_AFD="";
        String Tabla="";
        
        String AFND="";
    
        String grapviz="digraph Arbol_Sintactico {\n\n" + Arobol_grafica(this.Arbol,num) + "\n\n}";
      //  System.out.println(grapviz);
      
       // System.out.println("valor de variable1: "+nio);

       //   ------------------------------------------- GRAFICA DEL ARBOL BINARIO --------------------------- System.out.println(grapviz);
       String direccion="C:/Users/USER/Desktop/P1_OLC1_1S2023/src/GRAFICAS/ARBOLES_202107190/Arbol_Binario"+nio;
        File dotFile = new File("C:\\Users\\USER\\Desktop\\P1_OLC1_1S2023\\src\\GRAFICAS\\ARBOLES_202107190\\Arbol_Binario"+nio+".dot");
        PrintWriter dotWriter = null;
        try{
            dotWriter = new PrintWriter(dotFile);
            dotWriter.write(grapviz);
            //dotWriter.close();
          } catch (IOException ex) {
            // Manejo de excepciones
        } finally {
            if (dotWriter != null) {
                dotWriter.close();
            }
        }

        try {

          ProcessBuilder pBuilder;
          pBuilder = new ProcessBuilder("C:\\Program Files\\Graphviz\\bin\\dot.exe", "-Tpng",  direccion+".dot ","-o", direccion+".png");
          pBuilder.redirectErrorStream(true);
         pBuilder.start();
     
     
     
     
      } catch (Exception ex) {
          ex.printStackTrace();
      } 
      

/*          String[] c = new String[5];
          c[0]="C:/Program Files/Graphviz/bin/dot.exe";
          c[1]=" -Tpng ";
          c[2]=direccion+".dot";
          c[3]=" -o ";
          c[4]=direccion+".png";
          Runtime p = Runtime.getRuntime();
          p.exec(c);
          System.out.println("Se genero el archivo");
        //  System.out.println(c[0]+c[1]+c[2]+c[3]+c[4]);
      */





              





      //  System.out.println("--------------------------------------------------------------------------------------");"C:\\Users\\USER\\Desktop\\Proyecto1_OLC1_1S2023-main\\src\\ARBOLES_202107190"

       // System.out.println(Tabla);
   /*     for (int i = 0; i < listas.size(); i++) {
            System.out.println("Primero: "+listas.get(i).getList1()+"  Ultimo: "+listas.get(i).getList2());
        }*/
      //  System.out.println("--------------------------------------------------------------------------------------");"C:\\Users\\Usuario\\Desktop\\Proyecto1\\src\\Arbol\\Arbol_Sintactico.txt"
        int con=1;
        String c="";
        for (int i = 0; i < listaH.size(); i++) {
            c="";
            List<List<Integer>> listadelistas = new ArrayList<>();
            List<Integer> listaN = new ArrayList<>();
           // listaN.clear();

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
                         listaN.add(listas.get(j).getList2().get(k));
                         // if (listaN.contains(listas.get(j).getList2().get(k))){

                          //}
                            //else{
                              //  listaN.add(listas.get(j).getList2().get(k));
                            //}
                   }
                }
            }


boolean repetido=false;

     //      listas2.add(new Nodo_transiciones(listaH.get(i),con,listaN));
//     System.out.println("-----s---");
  //   System.out.println(listaH.get(i));
    // System.out.println("-----r---");
            for(int p=0; p<listas2.size();p++){
                if (listaH.get(i).toString().equals(listas2.get(p).getToken().toString())){
      //              System.out.println(listas2.get(p).getToken()+"   "+listaH.get(i));
        //            System.out.println("listaN: "+listaN);
          //          System.out.println("repetido");
                    listas2.get(p).getId().add(con);
                    listas2.get(p).getList1().add(listaN);
                    //listas2.get(p).getList1().addAll(listaN);
                  //  listas2.get(p).setList1(listaN);




             //       listas2.add(new Nodo_transiciones(listaH.get(i),con,listaN));
                    repetido=true;
                }
            }

  //   System.out.println("-----r---");
            if (repetido==false){
                List<Integer> ids= new ArrayList<>();
                ids.add(con);
    //            System.out.println("listaN: "+listaN);
                listadelistas.add(listaN);
                listas2.add(new Nodo_transiciones(listaH.get(i),ids,listadelistas));
            }
      //      System.out.println("-----s---");



            
           
          //  listaN.clear();
            complet+="<tr><td bgcolor=\"yellow\"> "+listaH.get(i)+" </td><td bgcolor=\"#77ff33\">"+con+" </td><td bgcolor=\"orange\">"+c+" </td></tr>\n";
          //  System.out.println(complet);
            con++;
    //         }
    
        }
        System.out.println("funcioma");
        boolean bandera = false;
//System.out.println("------------------------------------prueba-----------------------------{---------------------");
    //    for (int i = 0; i < listas2.size(); i++) {
 //           System.out.println("Token: "+listas2.get(i).getToken());
   //         for(int j=0; j<listas2.get(i).getId().size();j++){
     //           System.out.println("Id: "+listas2.get(i).getId().get(j));
  //      }
    //        for(int j=0; j<listas2.get(i).getList1().size();j++){
      //          System.out.println("Siguiente: "+listas2.get(i).getList1());
    //    }
  //  }
 
  for (int i = 0; i < listaaux.size(); i++) {
    for (int j=0; j<listaaux.get(i).getList1().size();j++){
        for (int k = 0; k < listas2.size(); k++){
            boolean bandera2=false;
            for (int l = 0; l < listas2.get(k).getId().size(); l++) {
                if (listas2.get(k).getId().get(l)==listaaux.get(i).getList1().get(j)){
                    bandera2=true;
                 //   System.out.println("Token: "+listas2.get(k).getToken());
              //   System.out.println(listas2.get(k).getList1().get(l));
              for (int w=0; w<listaaux.size();w++){
                if (listaaux.get(w).getList1().equals(listas2.get(k).getList1().get(l))){
                        bandera=true;
                }
              }
              if (bandera==true){  
                bandera=false;
}else{
listaaux.add(new Nodo_aux(listas2.get(k).getList1().get(l)));

//for (int m =0; m< listas2.size(); m++){

//    if(listas2.get(k).getList1().get(l).contains(listas2.get(m).getId())){
    //}


//}


}      

                }
            }


        }
    }

  }








  ArrayList<Integer> numeros = new ArrayList<Integer>();
  ArrayList<Integer> aceptacion = new ArrayList<Integer>();
  int S_n=0;
  int S_id=0;
/*  
  for(int nuec=0;nuec<listas2.size();nuec++){
    for(int nuec2=0;nuec2<listas2.get(nuec).getId().size();nuec2++){
     System.out.println("Token: "+listas2.get(nuec).getToken());
      System.out.println("Id: "+listas2.get(nuec).getId().get(nuec2));
      System.out.println("Siguiente: "+listas2.get(nuec).getList1().get(nuec2));
    }
    System.out.println("");
  }
*/






listas2.remove(listas2.size()-1);

for(int nuec=0;nuec<listas2.size();nuec++){
  for(int nuec2=0;nuec2<listas2.get(nuec).getId().size();nuec2++){
//   System.out.println("Token: "+listas2.get(nuec).getToken());
  //  System.out.println("Id: "+listas2.get(nuec).getId().get(nuec2));
  //  System.out.println("Siguiente: "+listas2.get(nuec).getList1().get(nuec2));
    numeros.add(listas2.get(nuec).getId().get(nuec2));
  }
}

int max = Collections.max(numeros);
//System.out.println("maximo: "+max);

for(int n1=0;n1<listas2.size();n1++){
  for(int n2=0;n2<listas2.get(n1).getId().size();n2++){
    if(listas2.get(n1).getId().get(n2)==max){
      aceptacion.addAll(listas2.get(n1).getList1().get(n2));
    }
    
  }
}

int maxx = Collections.max(aceptacion);
//System.out.println(aceptacion+"aceptacioooooooooooooooooooooooooooooooooooooon");
/* 
for(int ais=0; ais<listaaux.size();ais++){
  System.out.println("Siguiente: "+listaaux.get(ais).getList1());
  }
*/


  for(int i=0; i<estados_trans.size();i++){
    
    for(int j=0; j<listas2.size();j++){
     
    
     for(int n=0; n<listas2.get(j).getId().size();n++){
       boolean bandera_comprobante1=false;
   
       if(estados_trans.get(i).getList1().contains(listas2.get(j).getId().get(n))){
       //  System.out.println(listas2.get(j).getId().get(n));
   
   
   
    for(int k=0; k<AFD.size();k++){
         if(AFD.get(k).getS_ant().equals("S"+S_n)){
           //  bandera_comprobante1=true;
             if(AFD.get(k).getTokens().equals(listas2.get(j).getToken())){
   for(int indice:listas2.get(j).getList1().get(n)){
     if(!AFD.get(k).getIds().contains(indice)){
       AFD.get(k).getIds().add(indice);
     }
   }
                 
   
                 Boolean repe=false;
                 // System.out.println(S_n);
                 for(int esese=0;esese<estados_trans.size();esese++){
                  if(estados_trans.get(esese).getList1()==AFD.get(k).getIds()){
                repe=true;
                  }
                  }
                  if(repe==false){
                   estados_trans.add(new Nodo_estados(AFD.get(k).getIds()));
                  }
   
   
   
              //  System.out.println("repetido");
                 bandera_comprobante1=true;
             }
         }
       }
      
     if(bandera_comprobante1==false){
       for(int yyq=0; yyq<AFD.size();yyq++){
        // System.out.println(" ");
         if(listas2.get(j).getId().get(n)==AFD.get(yyq).getId()){
          // System.out.println("mismo id");


         //  if(listas2.get(j).getToken().equals(aceptacion)){
          int tas=max+1;
          if(listas2.get(j).getList1().get(n).contains(tas)){
          //  System.out.println(tas+"---"+estados_trans.get(i).getList1());
            AFD.add(new Nodo_AFD("S"+S_n,listas2.get(j).getToken(),listas2.get(j).getId().get(n),listas2.get(j).getList1().get(n),AFD.get(yyq).getS(),true));
           }
           else{
            AFD.add(new Nodo_AFD("S"+S_n,listas2.get(j).getToken(),listas2.get(j).getId().get(n),listas2.get(j).getList1().get(n),AFD.get(yyq).getS(),false));
           }
        //aceptacion   AFD.add(new Nodo_AFD("S"+S_n,listas2.get(j).getToken(),listas2.get(j).getId().get(n),listas2.get(j).getList1().get(n),AFD.get(yyq).getS(),false));
           
           
           bandera_comprobante1=true;
           break;
         }
       }
     }
     if(bandera_comprobante1==false ){
     //  System.out.println(S_n);
       for(int xx=0; xx<AFD.size();xx++){
         if(AFD.get(xx).getIds().equals(listas2.get(j).getList1().get(n))){
        //   System.out.println("misma lista");

            //if(listas2.get(j).getToken().equals(aceptacion)){
              int tas=max+1;
              if(listas2.get(j).getList1().get(n).contains(tas)){
          //      System.out.println(tas+"---"+estados_trans.get(i).getList1());
              AFD.add(new Nodo_AFD("S"+S_n,listas2.get(j).getToken(),listas2.get(j).getId().get(n),listas2.get(j).getList1().get(n),AFD.get(xx).getS(),true));
            }
            else{
              AFD.add(new Nodo_AFD("S"+S_n,listas2.get(j).getToken(),listas2.get(j).getId().get(n),listas2.get(j).getList1().get(n),AFD.get(xx).getS(),false));
            }


        //   AFD.add(new Nodo_AFD("S"+S_n,listas2.get(j).getToken(),listas2.get(j).getId().get(n),listas2.get(j).getList1().get(n),AFD.get(xx).getS(),false));
          
          
          
           bandera_comprobante1=true;
           break;
   
         }
   
       }
     }
   if(bandera_comprobante1==false ){
     S_id++;
     System.out.println("nuevo");
     Boolean repe=false;
    // System.out.println(S_n);
    for(int esese=0;esese<estados_trans.size();esese++){
     if(estados_trans.get(esese).getList1()==listas2.get(j).getList1().get(n)){
   repe=true;
     }
     }
     if(repe==false){
       estados_trans.add(new Nodo_estados(listas2.get(j).getList1().get(n)));
     }
    // if(listas2.get(j).getToken().equals(aceptacion)){
      int tas=max+1;
      if(listas2.get(j).getList1().get(n).contains(tas)){
     //   System.out.println(tas+"---"+estados_trans.get(i).getList1());
      AFD.add(new Nodo_AFD("S"+S_n,listas2.get(j).getToken(),listas2.get(j).getId().get(n),listas2.get(j).getList1().get(n),"S"+S_id,true));
     }else{
      AFD.add(new Nodo_AFD("S"+S_n,listas2.get(j).getToken(),listas2.get(j).getId().get(n),listas2.get(j).getList1().get(n),"S"+S_id,false));
     }

     
   }
     
   
     bandera_comprobante1=false;
     }
   
   }
   }
   S_n++;
   //System.out.println("------------------------xxxxx------------------------------------");
     
    // System.out.println(estados_trans.get(i).getList1());
     }



/* 
System.out.println("----------------------------------------------- AFN -----------------------------------------------");
  for(int iW=0; iW<AFD.size(); iW++){
   // System.out.println("S: "+AFD.get(iW).getS());
    System.out.println("S Ant: "+AFD.get(iW).getS_ant());
    System.out.println("Token: "+AFD.get(iW).getTokens());
    System.out.println("Id: "+AFD.get(iW).getId());
    System.out.println("Siguiente: "+AFD.get(iW).getIds());
    System.out.println("Siguiente: "+AFD.get(iW).getS());
    System.out.println("Aceptacion: "+AFD.get(iW).isEstado());
    System.out.println(" ");
  }


  System.out.println("----------------------------------------------- AFN -----------------------------------------------");

System.out.println("---------------------------------------------------listas de estados----------------------------------------------");
for(int esese=0;esese<estados_trans.size();esese++){
System.out.println(estados_trans.get(esese).getList1());
}
System.out.println("---------------------------------------------------listas de estados----------------------------------------------");

 */

AFD2.add((AFD));
Ventana_principal.listaJSON.add(new NodoJS(nio,AFD));


 
int SS=0;
//List<String> est= new ArrayList<>();
complet2+="<TR>\n";
for(int mn=0; mn<listas2.size();mn++){
  complet2+="<TD border=\"1\">"+listas2.get(mn).getToken()+"</TD>\n";
}
complet2+="</TR>\n";

for(int i=0; i<estados_trans.size();i++){
  complet2+="<TR>\n";
  String ppop="";
  ppop=ppop+"<TD border=\"1\">"+ppop+"S"+SS+estados_trans.get(i).getList1()+"</TD>\n";
  complet2+=ppop;
 
  for(int j=0; j<listas2.size(); j++){
    boolean bander=false;
    for(int ij=0; ij<AFD.size(); ij++){
      if(AFD.get(ij).getS_ant().equals( "S"+SS) && AFD.get(ij).getTokens().equals(listas2.get(j).getToken())){
        complet2+="<TD border=\"1\">"+AFD.get(ij).getS()+"</TD>\n";
        bander=true; 
      }
    }
    if(bander==false){
      complet2+="<TD border=\"1\">---</TD>\n";
    }

    
   }
    complet2+="</TR>\n";
SS++;
}

for(int it=0; it<AFD.size();it++){
  if(AFD.get(it).isEstado()==true){
    complet3+=AFD.get(it).getS()+"[shape=\"doublecircle\"];\n";
  }
  else{
    complet3+=AFD.get(it).getS()+";\n";
  }
}

for(int ti=0; ti<AFD.size();ti++){

  complet3+=AFD.get(ti).getS_ant()+"->"+AFD.get(ti).getS()+"[label=\""+AFD.get(ti).getTokens()+"\"];\n";


}







//System.out.println("------------------------------------prueba--------------------------------------------------");
        Transiciones+="digraph G {\n" 
           +"N_1[shape=none label = <\n" 
           +"<TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"10\" style=\"collapse\">\n" 
             +"<TR >\n"
              +"<TD rowspan=\"2\" colspan=\"1\" border=\"1\" bgcolor=\"black\"><b><font color=\"White\">Estado</font></b></TD>\n"
             +"<TD colspan=\"50\" border=\"1\" bgcolor=\"black\"><b><font color=\"White\">Terminales</font></b></TD>\n" 
              +"</TR>\n"

              +complet2

            +"</TABLE>>];}\n";




        Tabla +="digraph { label = \"Exp: "+nio+"\"  \n" 
         +"    node [ shape=none fontname=Helvetica ]\n" 
        +"     n4 [ label = <\n" 
             +"  <table border=\"4 \">\n" 
              +"    <tr><td colspan=\"2\" bgcolor=\"red\">Hoja</td><td colspan=\"2\" bgcolor=\"red\">Siguiente</td></tr>\n" 
              +complet
           +"   </table>\n" 
           +"   > ]\n" 
            +" {rank=same n4}\n" 
         +"  }\n";


        graf_AFD="digraph G {label = \"AFD:"+nio+"\"\n"
        +"rankdir=\"LR\";\n"
        +"node [shape=\"circle\"];\n"
        +"SI[shape = none, fontcolor=\"white\"];\n"
        +complet3
        +"}\n";

        AFND+="digraph G {label = \"AFND:"+nio+"\";\n"
        +"rankdir=\"LR\";"
        +"node [shape=\"circle\"]; "
        +compew
        +"S0;"
        +"}";
        System.out.println("---------------------------------------CAMBIO AFND-----------------------------");
        System.out.println(AFND);
        compew="";


         System.out.println("---------------------------------------CAMBIO Tabla-----------------------------");
      //  System.out.println(Tabla);
          File dotFile1 = new File("C:\\Users\\USER\\Desktop\\P1_OLC1_1S2023\\src\\GRAFICAS\\SIGUIENTES_202107190\\Tabla_siguientes_"+nio+".dot");
        PrintWriter dotWriter1 = null;
        try{
            dotWriter1 = new PrintWriter(dotFile1);
            dotWriter1.write(Tabla);
            //dotWriter.close();
          } catch (IOException ex) {
            // Manejo de excepciones
        } finally {
            if (dotWriter1 != null) {
                dotWriter1.close();
            }
        }

        try {
          String[] c1 = new String[5];
          c1[0]="C:/Program Files/Graphviz/bin/dot.exe";
          c1[1]="-Tpng";
          c1[2]="C:/Users/USER/Desktop/P1_OLC1_1S2023/src/GRAFICAS/SIGUIENTES_202107190/Tabla_siguientes_"+nio+".dot";
          c1[3]="-o";
          c1[4]="C:/Users/USER/Desktop/P1_OLC1_1S2023/src/GRAFICAS/SIGUIENTES_202107190/Tabla_siguientes_"+nio+".png";
      
          Runtime p1 = Runtime.getRuntime();
          p1.exec(c1);
          System.out.println("Se genero el archivo");
      } catch (Exception ex) {
          ex.printStackTrace();
      } 

        System.out.println("---------------------------------------CAMBIO Transiciones-----------------------------");
      //  System.out.println(Transiciones);
      File dotFile11 = new File("C:\\Users\\USER\\Desktop\\P1_OLC1_1S2023\\src\\GRAFICAS\\TRANSICIONES_202107190\\Tabla_transiciones_"+nio+".dot");
      PrintWriter dotWriter11 = null;
      try{
          dotWriter11 = new PrintWriter(dotFile11);
          dotWriter11.write(Transiciones);
          //dotWriter.close();
        } catch (IOException ex) {
          // Manejo de excepciones
      } finally {
          if (dotWriter11 != null) {
              dotWriter11.close();
          }
      }

      try {
        String[] c11 = new String[5];
        c11[0]="C:/Program Files/Graphviz/bin/dot.exe";
        c11[1]="-Tpng";
        c11[2]="C:/Users/USER/Desktop/P1_OLC1_1S2023/src/GRAFICAS/TRANSICIONES_202107190/Tabla_transiciones_"+nio+".dot";
        c11[3]="-o";
        c11[4]="C:/Users/USER/Desktop/P1_OLC1_1S2023/src/GRAFICAS/TRANSICIONES_202107190/Tabla_transiciones_"+nio+".png";
    
        Runtime p11 = Runtime.getRuntime();
        p11.exec(c11);
        System.out.println("Se genero el archivo");
    } catch (Exception ex) {
        ex.printStackTrace();
    } 
        System.out.println("---------------------------------------CAMBIO graf_AFD-----------------------------");
        //System.out.println(graf_AFD);
        File dotFile111 = new File("C:\\Users\\USER\\Desktop\\P1_OLC1_1S2023\\src\\GRAFICAS\\AFD_202107190\\AFD_"+nio+".dot");
        PrintWriter dotWriter111 = null;
        try{
            dotWriter111 = new PrintWriter(dotFile111);
            dotWriter111.write(graf_AFD);
            //dotWriter.close();
          } catch (IOException ex) {
            // Manejo de excepciones
        } finally {
            if (dotWriter111 != null) {
                dotWriter111.close();
            }
        }
  
        try {
          String[] c111 = new String[5];
          c111[0]="C:/Program Files/Graphviz/bin/dot.exe";
          c111[1]="-Tpng";
          c111[2]="C:/Users/USER/Desktop/P1_OLC1_1S2023/src/GRAFICAS/AFD_202107190/AFD_"+nio+".dot";
          c111[3]="-o";
          c111[4]="C:/Users/USER/Desktop/P1_OLC1_1S2023/src/GRAFICAS/AFD_202107190/AFD_"+nio+".png";
      
          Runtime p111 = Runtime.getRuntime();
          p111.exec(c111);
          System.out.println("Se genero el archivo");
      } catch (Exception ex) {
          ex.printStackTrace();
      } 




    
    estados_trans.clear();
    AFD.clear();




listaaux.clear();
        Tabla="";
        Transiciones="";
        graf_AFD="";
     //   instancia.variable1++;
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

        if (actual.getToken().equals("*")){
            actual.setAnulable(true);
            
            actual.getPrimero().addAll(actual.getHijoIzq().getPrimero());
            actual.getUltimo().addAll(actual.getHijoIzq().getUltimo());
            listas.add(new Nodo_siguientes(actual.getHijoIzq().getUltimo(),actual.getHijoIzq().getPrimero()));

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
      //      actual.setAnulable(false);complew
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
          if (listaaux.isEmpty()){
            listaaux.add(new Nodo_aux(nodo.getPrimero()));
        }
        if (estados_trans.isEmpty()){
          estados_trans.add(new Nodo_estados(nodo.getPrimero()));
      }
        }
        if (n!=0){
            cadena += "n" + n + "->n" + actual + "\n";
        }
        cadena += Arobol_grafica(nodo.getHijoIzq(), actual);
        cadena += Arobol_grafica(nodo.getHijoDer(), actual);

        return cadena;
        
    }





private void escribirArchivo(String ruta, String contenido){
  FileWriter fichero = null;
  PrintWriter pw = null;
  try{
    fichero=new FileWriter(ruta);
    pw=new PrintWriter(fichero);
    pw.write(contenido);
    pw.close();
    fichero.close();
  }catch(Exception e){
    System.out.println(e.getLocalizedMessage());
  }finally{
    if(pw!=null){
      pw.close();
      }
  }


}
    
    public void dibujarGraphviz(String graphviz){
      try{
escribirArchivo("C:\\Users\\Usuario\\Desktop\\Proyecto1\\src\\Arbol\\Arbol_Sintactico.dot",graphviz);
ProcessBuilder proceso;
proceso = new ProcessBuilder("dot","-Tpng","-o","C:\\Users\\Usuario\\Desktop\\Proyecto1\\src\\Arbol\\Arbol_Sintactico.png","C:\\Users\\Usuario\\Desktop\\Proyecto1\\src\\Arbol\\Arbol_Sintactico.dot");
proceso.redirectErrorStream(true);
proceso.start();     
}catch(Exception e){
        e.printStackTrace();
      }
    }


}
