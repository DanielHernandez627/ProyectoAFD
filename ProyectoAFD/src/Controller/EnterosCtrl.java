
package Controller;

import Model.Enteros;


public class EnterosCtrl {
    
    /*Inicio Objetos*/
    Enteros objEnteros = new Enteros();
    /*Fin Objetos*/
    
    public boolean Automata(String cadena){
        return objEnteros.Algoritmo(cadena);
    }
    
    public String obtenerFallo(){
        return objEnteros.fallo();
    }
}
