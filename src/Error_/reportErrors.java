package Error_;
import java.io.FileWriter;

import java.util.LinkedList;


public class reportErrors {

    String inicio = "";
    String fin = "";
    String reporte = "";
    String Lexico = "";
    String sintactico = "";

    public void GenerarReporte(LinkedList<Errores> errores, LinkedList<Errores> erroresS) {
        Start();
        ReporteLexico(errores);
        ReporteSintactico(erroresS);
        mostrarReporte();
    }

    public void Start() {
        inicio = "<!doctype html>\n"
                + "<html lang=\"en\">\n"
                + "  <head>\n"
                + "  	<title>Reporte de Tokens</title>\n"
                + "    <meta charset=\"utf-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                + "\n"
                + "	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>\n"
                + "\n"
                + "	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
                + "	\n"
                + "	<link rel=\"stylesheet\" href=\"table-07\\css\\style.css\">\n"
                + "\n"
                + "	</head>\n"
                + "	<body>\n"
                + "	<section class=\"ftco-section\">\n"
                + "		<div class=\"container\">\n"
                + "			<div class=\"row justify-content-center\">\n"
                + "				<div class=\"col-md-6 text-center mb-5\">\n"
                + "					<h2 class=\"heading-section\">Reporte de Errores</h2>\n"
                + "				</div>\n"
                + "			</div>\n"
                + "			<div class=\"row\">\n"
                + "				<div class=\"col-md-12\">\n"
                + "					<div class=\"table-wrap\">\n"
                + "						";

        fin = "</div>\n"
                + "				</div>\n"
                + "			</div>\n"
                + "		</div>\n"
                + "	</section>\n"
                + "\n"
                + "	<script src=\"js/jquery.min.js\"></script>\n"
                + "  <script src=\"js/popper.js\"></script>\n"
                + "  <script src=\"js/bootstrap.min.js\"></script>\n"
                + "  <script src=\"js/main.js\"></script>\n"
                + "\n"
                + "	</body>\n"
                + "</html>\n"
                + "\n"
                + "	<script src=\"js/jquery.min.js\"></script>\n"
                + "  <script src=\"js/popper.js\"></script>\n"
                + "  <script src=\"js/bootstrap.min.js\"></script>\n"
                + "  <script src=\"js/main.js\"></script>\n"
                + "\n"
                + "	</body>\n"
                + "</html>";
    }

    public void ReporteLexico(LinkedList<Errores> errores) {

        Lexico = "<table class=\"table table-bordered table-dark table-hover\">\n"
                + "						  <thead>\n"
                + "						    <tr>\n"
                + "						      <th>Descripcion</th>\n"
                + "						      <th>Tipo</th>\n"
                + "						      <th>Linea</th>\n"
                + "						      <th>Columna</th>\n"
                + "						    </tr>\n"
                + "						  </thead>\n"
                + "						  <tbody>";

        for (Errores Errores : errores) {
            Lexico += "<tr>";
            Lexico += "<tr>\n"
                    + "<th scope=\"row\">" + Errores.getMessage() + "</th>\n"
                    + "<td>" + Errores.getType() + "</td>\n"
                    + "<td>" + Errores.getFila() + "</td>\n"
                    + "<td>" + Errores.getColumna() + "</td>\n"
                    + "</tr>";
        }
        Lexico += "</tbody>\n"
                + "</table>";

    }

    private void ReporteSintactico(LinkedList<Errores> erroresS) {
        sintactico = "<table class=\"table table-bordered table-dark table-hover\">\n"
                + "						  <thead>\n"
                + "						    <tr>\n"
                + "						      <th>Descripcion</th>\n"
                + "						      <th>Tipo</th>\n"
                + "						      <th>Columna</th>\n"
                + "						      <th>Fila</th>\n"
                + "						    </tr>\n"
                + "						  </thead>\n"
                + "						  <tbody>";

        for (Errores Errores : erroresS) {
            sintactico += "<tr>";
            sintactico += "<tr>\n"
                    + "<th scope=\"row\">" + Errores.getMessage() + "</th>\n"
                    + "<td>" + Errores.getType() + "</td>\n"
                    + "<td>" + Errores.getFila() + "</td>\n"
                    + "<td>" + Errores.getColumna() + "</td>\n"
                    + "</tr>";
        }
        sintactico += "</tbody>\n"
                + "</table>";
    }

    public void mostrarReporte() {
        try {
            FileWriter file = new FileWriter("C:\\Users\\USER\\Desktop\\P1_OLC1_1S2023\\src\\GRAFICAS\\ERRORES_202107190\\Reporte_errores.html");
            file.write(inicio + Lexico + sintactico + fin);
            file.close();
            //Desktop.getDesktop().open(new File(file_get_path));
            System.out.println("Reporte generado con exito.");
        } catch (Exception e) {
        }
    }

}