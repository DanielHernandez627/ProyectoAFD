
package Controller;

import Model.Reales;


public class RealesCtrl {
    
    /*Inicio de Objetos*/
    Reales objReales = new Reales();
    /*Fin de Objetos*/
    
    public boolean Automata(String cadena){
        return objReales.Algoritmo(cadena);
    }
    
    public String obtenerFallo(){
        return objReales.fallo();
    }
    
}
