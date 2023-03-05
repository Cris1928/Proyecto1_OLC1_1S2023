package Analizadores;
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import Error_.Errores;
import java_cup.runtime.*;

%%

%{
 
     public static LinkedList<Errores> errores  = new LinkedList<Errores>();
    public static String cadena;
    public static char ch;

%}

%class A_lex
%cup
%public
%line
%char
%unicode
%column
%full

%init{
  yyline = 0;
  yychar = 0;
%init}


MAYOR=">"
PR_CONJ="CONJ"
LR_DOS_PUNTOS=":"
LR_GUIUION="-"
LR_COMA=","
LR_PUNTO="."
LR_PUNTO_COMA=";"
LR_LLAVE_IZQ="{"
LR_LLAVE_DER="}"
LR_DISYUNCION="|"
LR_CERRADURA_KLEENE="*"
LR_CERRADURA_POSITIVA="+"
LR_CERRADURA_INTERROGACION="?"
PORCENTAJE="%"
SEPARADOR="~"



FINLINEA=\r|\n|\r\n
ESPACIOS = [ \r\n]+ 
CARACTER_ENTRADA = [^\r\n]
COMENTARIO_M="<!"({CARACTER_ENTRADA}|{FINLINEA})*"!>"
COMENTARIO_L="//" {CARACTER_ENTRADA}* {FINLINEA}?
LETRA_MINUSCULA=[a-z]
LETRA_MAYUSCULA=[A-Z]
NUMERO=[0-9]

ENTR=[^\r\n\"]
SL=[\\']
SLL=[\\n]
SLLL=[\\]
SLLLL=[\"]*
CARACTER_ESPECIAL=[ -/:-@\[-`{-}]
ID=[a-zA-Z_][a-zA-Z0-9_]+

SR=\"({ENTR}|{ESPACIOS}|{SL}|{SLLL}{SLLLL})+\"


%%

<YYINITIAL> {COMENTARIO_L} { }
<YYINITIAL> {COMENTARIO_M} { }
<YYINITIAL> {ESPACIOS} { }
<YYINITIAL> {FINLINEA} {System.out.println("fin de linea");}

<YYINITIAL> {PR_CONJ} { System.out.println("PR_CONJ: "+yytext()); return new Symbol(sym.PR_CONJ, yyline, yycolumn, yytext());}
<YYINITIAL> {LR_DOS_PUNTOS} { System.out.println("LR_DOS_PUNTOS: "+yytext()); return new Symbol(sym.LR_DOS_PUNTOS, yyline, yycolumn, yytext());}
<YYINITIAL> {LR_GUIUION} { System.out.println("LR_GUIUION: "+yytext()); return new Symbol(sym.LR_GUIUION, yyline, yycolumn, yytext());}
<YYINITIAL> {LR_COMA} { System.out.println("LR_COMA: "+yytext()); return new Symbol(sym.LR_COMA, yyline, yycolumn, yytext());}
<YYINITIAL> {LR_PUNTO} { System.out.println("LR_PUNTO: "+yytext()); return new Symbol(sym.LR_PUNTO, yyline, yycolumn, yytext());}
<YYINITIAL> {LR_PUNTO_COMA} {System.out.println("LR_PUNTO_COMA: "+yytext()); return new Symbol(sym.LR_PUNTO_COMA, yyline, yycolumn, yytext());}
<YYINITIAL> {LR_LLAVE_IZQ} {System.out.println("LR_LLAVE_IZQ: "+yytext()); return new Symbol(sym.LR_LLAVE_IZQ, yyline, yycolumn, yytext());}
<YYINITIAL> {LR_LLAVE_DER} {System.out.println("LR_LLAVE_DER: "+yytext()); return new Symbol(sym.LR_LLAVE_DER, yyline, yycolumn, yytext());}
<YYINITIAL> {LR_DISYUNCION} {System.out.println("LR_DISYUNCION: "+yytext()); return new Symbol(sym.LR_DISYUNCION, yyline, yycolumn, yytext());}
<YYINITIAL> {LR_CERRADURA_KLEENE} {System.out.println("LR_CERRADURA_KLEENE: "+yytext()); return new Symbol(sym.LR_CERRADURA_KLEENE, yyline, yycolumn, yytext());}
<YYINITIAL> {LR_CERRADURA_POSITIVA} {System.out.println("LR_CERRADURA_POSITIVA: "+yytext()); return new Symbol(sym.LR_CERRADURA_POSITIVA, yyline, yycolumn, yytext());}
<YYINITIAL> {LR_CERRADURA_INTERROGACION} {System.out.println("LR_CERRADURA_INTERROGACION: "+yytext()); return new Symbol(sym.LR_CERRADURA_INTERROGACION, yyline, yycolumn, yytext());}
<YYINITIAL> {PORCENTAJE} {System.out.println("PORCENTAJE "+yytext()); return new Symbol(sym.PORCENTAJE, yyline, yycolumn, yytext());}
<YYINITIAL> {SEPARADOR} {System.out.println("SEPARADOR: "+yytext()); return new Symbol(sym.SEPARADOR, yyline, yycolumn, yytext());}
<YYINITIAL> {ID} {System.out.println("ID: "+yytext()); return new Symbol(sym.ID, yyline, yycolumn, yytext());}
<YYINITIAL> {LETRA_MINUSCULA} {System.out.println("LETRA_MINUSCULA: "+yytext()); return new Symbol(sym.LETRA_MINUSCULA, yyline, yycolumn, yytext());}
<YYINITIAL> {LETRA_MAYUSCULA} {System.out.println("LETRA_MAYUSCULA: "+yytext()); return new Symbol(sym.LETRA_MAYUSCULA, yyline, yycolumn, yytext());}
<YYINITIAL> {NUMERO} {System.out.println("NUMERO: "+yytext()); return new Symbol(sym.NUMERO, yyline, yycolumn, yytext());}
<YYINITIAL> {CARACTER_ESPECIAL} {System.out.println("CARACTER_ESPECIAL: "+yytext()); return new Symbol(sym.CARACTER_ESPECIAL, yyline, yycolumn, yytext());}
<YYINITIAL> {MAYOR} {System.out.println("MAYOR: "+yytext()); return new Symbol(sym.MAYOR, yyline, yycolumn, yytext());}
<YYINITIAL> {SR} {System.out.println("SR: "+yytext()); return new Symbol(sym.SR, yyline, yycolumn, yytext());}


<YYINITIAL>  . {
    System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yycolumn);
    Errores tmp = new Errores("Error lexico encontrado: \"" + yytext() + "\"", "Lexico", (yyline) + 1, (yycolumn) + 1);
    errores.add(tmp);
}

