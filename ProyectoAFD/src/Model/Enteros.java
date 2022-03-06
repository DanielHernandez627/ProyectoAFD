
package Model;


public class Enteros {
    
    private String lexema;
    private int estado;
    private boolean estadoAcepta;
    private int estadoError;
    private int inicioCadena;
    private int posLectura[];
    private String entero;

    public Enteros() {
    }

    public Enteros(String entero) {
        this.entero = entero;
    }

    public String getLexema() {
        return lexema;
    }

    public int getEstado() {
        return estado;
    }

    public boolean isEstadoAcepta() {
        return estadoAcepta;
    }

    public int getEstadoError() {
        return estadoError;
    }

    public int getInicioCadena() {
        return inicioCadena;
    }

    public int[] getPosLectura() {
        return posLectura;
    }

    public String getEntero() {
        return entero;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setEstadoAcepta(boolean estadoAcepta) {
        this.estadoAcepta = estadoAcepta;
    }

    public void setEstadoError(int estadoError) {
        this.estadoError = estadoError;
    }

    public void setInicioCadena(int inicioCadena) {
        this.inicioCadena = inicioCadena;
    }

    public void setPosLectura(int[] posLectura) {
        this.posLectura = posLectura;
    }

    public void setEntero(String entero) {
        this.entero = entero;
    }

    public boolean Algoritmo(String cadena){
        posLectura = new int[1];
        lexema=cadena;
        estadoAcepta=false;
        estado=0;
        estadoError=0;
        posLectura[0]=0;
        return proceso();
    }
    
    public boolean proceso(){
        boolean valido;
        valido = automataInt();
        return valido;
    }
    
    public boolean automataInt(){
        char caracter;
        for (int i = inicioCadena; i < lexema.length(); i++) {
            caracter = lexema.charAt(i);
            if (Character.isDigit(caracter) || caracter == '-' && estado == 0) {
                estado = 1;
                estadoAcepta=true;
            }else{
                if (Character.isDigit(caracter) && estado == 1) {
                    estado = 1;
                    estadoAcepta=true;
                }else{
                    estadoAcepta=false;
                    posLectura[0] = i;
                    break;
                }
            }
        }
        
        return estadoAcepta;
    }
    
    public String fallo(){
        return String.valueOf(lexema.charAt(posLectura[0]));
    }
    
}
