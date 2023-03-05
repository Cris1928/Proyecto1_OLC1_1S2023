package Analizadores;
import java.util.LinkedList;
import Error_.Errores;
import java_cup.runtime.*;


%%
%{
    public static LinkedList<Errores> errores  = new LinkedList<Errores>();
    //LinkedList lista_E = new LinkedList();
    public static String cadena;
    public static char ch;
%}

%public
%class Analizador_Lexico
%cup
%char
%full
%ignorecase
%line
%column
%unicode

%init{
%init}

ESPACIOS = [ \t\r\n]+
COMENTARIO_L = ("//".*\r\n)|("//".*\n)|("//".*\r)
COMENTARIO_M = "/*""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"*/"
CARACTER = ([\']([^\t\'\"\n]|(\\\")|(\\n)|(\\\')|(\\t))?[\']|\'\$\{\d+\}\')
BOOLEAN = ("verdadero" | "falso")
IDENTIFICADOR = [_][a-zA-Z0-9]+[_]
CARACTER_E = [\"][\\][\"\'n][\"];
CADENA = [\"][^\"]*[\"]
DIGITOS = [0-9]+("." [0-9]+)?

%%

"inicio"    {   System.out.println("Reconocio PR_INICIO, lexema:"+yytext());
                return new Symbol(sym.PR_INICIO, yycolumn, yyline, yytext());}
"fin"       {   System.out.println("Reconocio PR_FIN, lexema:"+yytext());
                return new Symbol(sym.PR_FIN, yycolumn, yyline, yytext());}
"ingresar"  {   System.out.println("Reconocio PR_INGRESAR, lexema:"+yytext());
                return new Symbol(sym.PR_INGRESAR, yycolumn, yyline, yytext());}
"como"      {   System.out.println("Reconocio PR_COMO, lexema:"+yytext());
                return new Symbol(sym.PR_COMO, yycolumn, yyline, yytext());}
"con_valor" {   System.out.println("Reconocio PR_CON_VALOR, lexema:"+yytext());
                return new Symbol(sym.PR_CON_VALOR, yycolumn, yyline, yytext());}
"->"        {   System.out.println("Reconocio PR_ASIGNACION, lexema:"+yytext());
                return new Symbol(sym.PR_ASIGNACION, yycolumn, yyline, yytext());}
"si"        {   System.out.println("Reconocio PR_SI, lexema:"+yytext());
                return new Symbol(sym.PR_SI, yycolumn, yyline, yytext());}
"entonces"  {   System.out.println("Reconocio PR_ENTONCES, lexema:"+yytext());
                return new Symbol(sym.PR_ENTONCES, yycolumn, yyline, yytext());}
"de_lo_contrario" { System.out.println("Reconocio PR_DE_LO_CONTRARIO, lexema:"+yytext());
                    return new Symbol(sym.PR_DE_LO_CONTRARIO, yycolumn, yyline, yytext());}
"o_si"      {   System.out.println("Reconocio PR_O_SI, lexema:"+yytext());
                return new Symbol(sym.PR_O_SI, yycolumn, yyline, yytext());}
"fin_si"    {   System.out.println("Reconocio PR_FIN_SI, lexema:"+yytext());
                return new Symbol(sym.PR_FIN_SI, yycolumn, yyline, yytext());}
"segun"     {   System.out.println("Reconocio PR_SEGUN, lexema:"+yytext());
                return new Symbol(sym.PR_SEGUN, yycolumn, yyline, yytext());}
"hacer"     {   System.out.println("Reconocio PR_HACER, lexema:"+yytext());
                return new Symbol(sym.PR_HACER, yycolumn, yyline, yytext());}
"fin_segun" {   System.out.println("Reconocio PR_FIN_SEGUN, lexema:"+yytext());
                return new Symbol(sym.PR_FIN_SEGUN, yycolumn, yyline, yytext());}
"para"      {   System.out.println("Reconocio PR_PARA, lexema:"+yytext());
                return new Symbol(sym.PR_PARA, yycolumn, yyline, yytext());}
"hasta"     {   System.out.println("Reconocio PR_HASTA, lexema:"+yytext());
                return new Symbol(sym.PR_HASTA, yycolumn, yyline, yytext());}
"con" {         System.out.println("Reconocio PR_CON, lexema:"+yytext());
                return new Symbol(sym.PR_CON, yycolumn, yyline, yytext());}
"incremental" { System.out.println("Reconocio PR_INCREMENTAL, lexema:"+yytext());
                return new Symbol(sym.PR_INCREMENTAL, yycolumn, yyline, yytext());}
"fin_para"  {   System.out.println("Reconocio PR_FIN_PARA, lexema:"+yytext());
                return new Symbol(sym.PR_FIN_PARA, yycolumn, yyline, yytext());}
"mientras"  {   System.out.println("Reconocio PR_MIENTRAS, lexema:"+yytext());
                return new Symbol(sym.PR_MIENTRAS, yycolumn, yyline, yytext());}
"fin_mientras" {System.out.println("Reconocio PR_FIN_MIENTRAS, lexema:"+yytext());
                return new Symbol(sym.PR_FIN_MIENTRAS, yycolumn, yyline, yytext());}
"repetir"   {   System.out.println("Reconocio PR_REPETIR, lexema:"+yytext());
                return new Symbol(sym.PR_REPETIR, yycolumn, yyline, yytext());}
"hasta_que" {   System.out.println("Reconocio PR_HASTA_QUE, lexema:"+yytext());
                return new Symbol(sym.PR_HASTA_QUE, yycolumn, yyline, yytext());}
"retornar"  {   System.out.println("Reconocio PR_RETORNAR, lexema:"+yytext());
                return new Symbol(sym.PR_RETORNAR, yycolumn, yyline, yytext());}
"ejecutar"  {   System.out.println("Reconocio PR_EJECUTAR, lexema:"+yytext());
                return new Symbol(sym.PR_EJECUTAR, yycolumn, yyline, yytext());}
"imprimir"  {   System.out.println("Reconocio PR_IMPRIMIR, lexema:"+yytext());
                return new Symbol(sym.PR_IMPRIMIR, yycolumn, yyline, yytext());}
"imprimir_nl" { System.out.println("Reconocio PR_IMPRIMIR_NL, lexema:"+yytext());
                return new Symbol(sym.PR_IMPRIMIR_NL, yycolumn, yyline, yytext());}
"metodo"    {   System.out.println("Reconocio PR_METODO, lexema:"+yytext());
                return new Symbol(sym.PR_METODO, yycolumn, yyline, yytext());}
"con_parametros" {  System.out.println("Reconocio PR_CON_PARAMETROS, lexema:"+yytext());
                    return new Symbol(sym.PR_CON_PARAMETROS, yycolumn, yyline, yytext());}
"fin_metodo" {  System.out.println("Reconocio PR_FIN_METODO, lexema:"+yytext());
                return new Symbol(sym.PR_FIN_METODO, yycolumn, yyline, yytext());}
"funcion"   {   System.out.println("Reconocio PR_FUNCION, lexema:"+yytext());
                return new Symbol(sym.PR_FUNCION, yycolumn, yyline, yytext());}
"fin_funcion" { System.out.println("Reconocio PR_FIN_FUNCION, lexema:"+yytext());
                return new Symbol(sym.PR_FIN_FUNCION, yycolumn, yyline, yytext());}
"numero"    {   System.out.println("Reconocio PR_NUMERO, lexema:"+yytext());
                return new Symbol(sym.PR_NUMERO, yycolumn, yyline, yytext());}
"cadena"    {   System.out.println("Reconocio PR_CADENA, lexema:"+yytext());
                return new Symbol(sym.PR_CADENA, yycolumn, yyline, yytext());}
"boolean"   {   System.out.println("Reconocio PR_BOOLEAN, lexema:"+yytext());
                return new Symbol(sym.PR_BOOLEAN, yycolumn, yyline, yytext());}
"caracter"  {   System.out.println("Reconocio PR_CARACTER, lexema:"+yytext());
                return new Symbol(sym.PR_CARACTER, yycolumn, yyline, yytext());}


"and"       {   System.out.println("Reconocio OP_AND, lexema:"+yytext());
                return new Symbol(sym.OP_AND, yycolumn, yyline, yytext());}
"or"        {   System.out.println("Reconocio OP_OR, lexema:"+yytext());
                return new Symbol(sym.OP_OR, yycolumn, yyline, yytext());}
"not"        {   System.out.println("Reconocio OP_NOT, lexema:"+yytext());
                return new Symbol(sym.OP_NOT, yycolumn, yyline, yytext());}

"+"         {   System.out.println("Reconocio OP_SUMA, lexema:"+yytext());
                return new Symbol(sym.OP_SUMA, yycolumn, yyline, yytext());}
"-"         {   System.out.println("Reconocio OP_RESTA, lexema:"+yytext());
                return new Symbol(sym.OP_RESTA, yycolumn, yyline, yytext());}
"*"         {   System.out.println("Reconocio OP_MULTIPLICACION, lexema:"+yytext());
                return new Symbol(sym.OP_MULTIPLICACION, yycolumn, yyline, yytext());}
"/"         {   System.out.println("Reconocio OP_DIVISION, lexema:"+yytext());
                return new Symbol(sym.OP_DIVISION, yycolumn, yyline, yytext());}
"potencia"  {   System.out.println("Reconocio OP_POTENCIA, lexema:"+yytext());
                return new Symbol(sym.OP_POTENCIA, yycolumn, yyline, yytext());}
"mod"       {   System.out.println("Reconocio OP_MODULO, lexema:"+yytext());
                return new Symbol(sym.OP_MODULO, yycolumn, yyline, yytext());}
"mayor"         {   System.out.println("Reconocio OP_MAYOR_QUE, lexema:"+yytext());
                return new Symbol(sym.OP_MAYOR_QUE, yycolumn, yyline, yytext());}
"menor"         {   System.out.println("Reconocio OP_MENOR_QUE, lexema:"+yytext());
                return new Symbol(sym.OP_MENOR_QUE, yycolumn, yyline, yytext());}
"es_igual"  {   System.out.println("Reconocio OP_IGUAL, lexema:"+yytext());
                return new Symbol(sym.OP_IGUAL, yycolumn, yyline, yytext());}
"es_diferente" {System.out.println("Reconocio OP_ES_DIFERENTE, lexema:"+yytext());
                return new Symbol(sym.OP_ES_DIFERENTE, yycolumn, yyline, yytext());}
"mayor_o_igual" { System.out.println("Reconocio OP_MAYOR_IGUAL, lexema:"+yytext());
                return new Symbol(sym.OP_MAYOR_IGUAL, yycolumn, yyline, yytext());}
"menor_o_igual" { System.out.println("Reconocio OP_MENOR_IGUAL, lexema:"+yytext());
                return new Symbol(sym.OP_MENOR_IGUAL, yycolumn, yyline, yytext());}


"["         {   System.out.println("Reconocio SB_CORCHETE_LEFT, lexema:"+yytext());
                return new Symbol(sym.SB_CORCHETE_LEFT, yycolumn, yyline, yytext());}
"]"         {   System.out.println("Reconocio SB_CORCHETE_RIGHT, lexema:"+yytext());
                return new Symbol(sym.SB_CORCHETE_RIGHT, yycolumn, yyline, yytext());}
"("         {   System.out.println("Reconocio SB_PARENTESIS_LEFT, lexema:"+yytext());
                return new Symbol(sym.SB_PARENTESIS_LEFT, yycolumn, yyline, yytext());}
")"         {   System.out.println("Reconocio SB_PARENTESIS_RIGHT, lexema:"+yytext());
                return new Symbol(sym.SB_PARENTESIS_RIGHT, yycolumn, yyline, yytext());}
";"         {   System.out.println("Reconocio SB_PUNTO_Y_COMA, lexema:"+yytext());
                return new Symbol(sym.SB_PUNTO_Y_COMA, yycolumn, yyline, yytext());}
","         {   System.out.println("Reconocio SB_COMA, lexema:"+yytext());
                return new Symbol(sym.SB_COMA, yycolumn, yyline, yytext());}
[\¿]         {   System.out.println("Reconocio SB_INTERROGACION_LEFT, lexema:"+yytext());
                return new Symbol(sym.SB_INTERROGACION_LEFT, yycolumn, yyline, yytext());}
[\?]        {   System.out.println("Reconocio SB_INTERROGACION_RIGHT, lexema:"+yytext());
                return new Symbol(sym.SB_INTERROGACION_RIGHT, yycolumn, yyline, yytext());}

{ESPACIOS} {}
{COMENTARIO_L} {System.out.println("Reconocio COMENTARIO_L, lexema:"+yytext());
                return new Symbol(sym.COMENTARIO1, yycolumn, yyline, yytext());}
{COMENTARIO_M} {System.out.println("Reconocio COMENTARIO_M, lexema:"+yytext());
                return new Symbol(sym.COMENTARIO2, yycolumn, yyline, yytext());}
{CARACTER}  {   cadena = yytext();
                int cad_len = cadena.length();
                char [] cadena_div = cadena.toCharArray();
                String n = "";
                if (cad_len <= 3){
                    System.out.println("Reconocio CARACTER, lexema:"+cadena);
                    return new Symbol(sym.CARACTER, yycolumn, yyline, cadena);
                }else{
                    for (int i = 0; i < cadena_div.length; i++){
                        if (Character.isDigit(cadena_div[i])){
                            n += cadena_div[i];
                        }
                    }
                    int num = Integer.parseInt(n);
                    char ch = (char)num;
                    String s = "\'"+ch+"\'";
                    System.out.println("Reconocio CARACTER, lexema:"+s);
                    return new Symbol(sym.CARACTER, yycolumn, yyline, s);
                }}
{BOOLEAN}   {   System.out.println("Reconocio BOOLEAN, lexema:"+yytext());
                return new Symbol(sym.BOOLEAN, yycolumn, yyline, yytext());}
{IDENTIFICADOR} {System.out.println("Reconocio IDENTIFICADOR, lexema:"+yytext());
                 return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());}
{CARACTER_E} {  System.out.println("Reconocio CARACTER_E, lexema:"+yytext());
                return new Symbol(sym.CARACTER_E, yycolumn, yyline, yytext());}
{CADENA}    {   System.out.println("Reconocio CADENA, lexema:"+yytext());
                return new Symbol(sym.CADENA, yycolumn, yyline, yytext());}
{DIGITOS}   {   System.out.println("Reconocio DIGITOS, lexema:"+yytext());
                return new Symbol(sym.DIGITOS, yycolumn, yyline, yytext());}
 . {
    System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yycolumn);
    //lista_E.insertar("Este es un error lexico: "+yytext()+"\"", yytext(), yyline, yycolumn);
    Errores tmp = new Errores("Error lexico encontrado: \"" + yytext() + "\"", "Lexico", (yyline) + 1, (yycolumn) + 1);
    errores.add(tmp);
}
