package paquete5;

import java.util.ArrayList;
import java.util.Arrays;
import paquete1.Calificacion;
import paquete1.Profesor2;

public class ManejoArrayList5 {

    public static void main(String[] args) {
        String[] lineas = {"Tara Hernandez|contratado|30",
            "Luis Andrade|factura|35", "Ana Juarez|nombramiento|40",};

        ArrayList<Profesor2> profesores = new ArrayList<>();
        
        for (int i = 0; i < lineas.length; i++) {

            ArrayList<String> linea_partes = new ArrayList<>(
                    Arrays.asList(lineas[i].split("\\|")) //
            );
            
            String nombre = linea_partes.get(0);
            String tipo = linea_partes.get(1);
            int edad =  Integer.parseInt(linea_partes.get(2));
            
            Profesor2 p = new Profesor2(nombre, tipo,edad );
            
            profesores.add(p);
            
        }

        for (int i = 0; i < profesores.size(); i++) {
            System.out.println(profesores.get(i));
        }
//      ALEX RAMIREZ
        
    }
}
