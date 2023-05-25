/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete5;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete1.Calificacion;

public class EscrituraArchivoSecuencial {

    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private Hospital registro;
    private ArrayList<Hospital> lista;

    public EscrituraArchivoSecuencial(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerLista(); // obtener los valores (objetos)
                                    // que tiene el archivo.
        // System.out.println(obtenerListaProfesores().size());
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerLista().size() > 0 && obtenerLista() != null) {
                for (int i = 0; i < obtenerLista().size(); i++) {
                    establecerRegistro(obtenerLista().get(i));
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch
    }
    
    public void establecerNombreArchivo(String n){
        nombreArchivo = n;
    }
    // agrega registros al archivo
    public void establecerRegistro(Hospital p) {
        registro = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }


    public void establecerLista() {
        LecturaArchivoSecuencial l = new LecturaArchivoSecuencial(obtenerNombreArchivo());
        l.establecerListaHospitales();
        lista = l.obtenerListaHospitales();
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<Hospital> obtenerLista() {
        return lista;
    }

    public ObjectOutputStream obtenerSalida(){
        return salida;
    }
    public void cerrarArchivo() {
        try 
        {
            if (salida != null) {
                salida.close();
            }
        }
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            
        }
    } 

}
