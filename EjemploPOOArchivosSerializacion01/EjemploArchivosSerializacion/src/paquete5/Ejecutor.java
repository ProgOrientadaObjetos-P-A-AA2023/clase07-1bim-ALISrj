package paquete5;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejecutor {

    public static void main(String[] args) {

        String nombreArchivo = "hospitales.data";

        Ciudad ciu1 = new Ciudad("Loja", "Loja");
        Ciudad ciu2 = new Ciudad("Quito", "Quito");
        Ciudad ciu3 = new Ciudad("Cuenca", "Azuay");
        Ciudad ciu4 = new Ciudad("Santa Rosa", "El Oro");
        Ciudad ciu5 = new Ciudad("Zamora", "Zamora");

        ArrayList<Hospital> hospitales = new ArrayList<>();

        Hospital h1 = new Hospital("Isidro", 20, 10000, ciu1);
        Hospital h2 = new Hospital("Ayora", 30, 1500, ciu2);
        Hospital h3 = new Hospital("UTPL", 35, 2400, ciu3);
        Hospital h4 = new Hospital("Juan de Dios", 15, 9000, ciu4);
        Hospital h5 = new Hospital("Abendanio", 18, 8500, ciu5);

        hospitales.add(h1);
        hospitales.add(h2);
        hospitales.add(h3);
        hospitales.add(h4);
        hospitales.add(h5);

        EscrituraArchivoSecuencial archivo = new EscrituraArchivoSecuencial(nombreArchivo);

        for (int i = 0; i < hospitales.size(); i++) {
            archivo.establecerRegistro(hospitales.get(i));
            archivo.establecerSalida();
        }

        
        archivo.cerrarArchivo();

        LecturaArchivoSecuencial lectura = new LecturaArchivoSecuencial(nombreArchivo);
        lectura.establecerListaHospitales();
        System.out.println(lectura);

    }

}
