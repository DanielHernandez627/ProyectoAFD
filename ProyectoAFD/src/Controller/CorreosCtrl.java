
package Controller;

import Model.Correos;


public class CorreosCtrl {
    /*Inicio Objetos*/
    Correos objCorreos = new Correos();
    /*Fin Objetos*/
    
    public boolean Automata(String cadena){
        return objCorreos.Algoritmo(cadena);
    }
    
    public String obtenerFallo(){
        return objCorreos.fallo();
    }
    
}
