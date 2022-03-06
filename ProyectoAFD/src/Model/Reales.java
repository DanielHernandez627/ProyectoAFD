
package Model;


public class Reales {
    
    private String lexema;
    private int estado;
    private boolean estadoAcepta;
    private int estadoError;
    private int inicioCadena;
    private int posLectura[];
    private String real;

    public Reales() {
    }
    
    public Reales(String real) {
        this.real = real;
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

    public String getReal() {
        return real;
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

    public void setReal(String real) {
        this.real = real;
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
        valido = automataDouble();
        return valido;
    }
    
    public boolean automataDouble(){
        char caracter,verificador;
        for (int i = inicioCadena; i < lexema.length(); i++) {
            caracter = lexema.charAt(i);
            if (Character.isDigit(caracter) || caracter == '-' && estado == 0) {
                estado = 1;
                estadoAcepta=true;
            }else{
                if (Character.isDigit(caracter) && estado == 1) {
                    estado = 1;
                    estadoAcepta=true;
                }else if(caracter == '.'){
                    int index = lexema.length(); 
                    if (i+1 >= index) {
                        estadoAcepta=false;
                        posLectura[0] = i+1;
                        break;
                    }else{
                        verificador = lexema.charAt(i+1);
                        if (Character.isDigit(verificador)) {
                            estado = 1;
                            estadoAcepta=true;
                        }else{
                            estadoAcepta=false;
                            posLectura[0] = i+1;
                            break;
                        }
                    }
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
        int index = lexema.length();
        if (posLectura[0] >= index) {
            return "Sin digito despues del punto";
        }else{
           return String.valueOf(lexema.charAt(posLectura[0]));
        }
    }

}
