
package Model;


public class Correos {
    
    private String lexema;
    private int estado;
    private boolean estadoAcepta;
    private int estadoError;
    private int inicioCadena;
    private int posLectura[];
    private String correo;

    public Correos() {
    }
    
    public Correos(String correo) {
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
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

    public void setCorreo(String correo) {
        this.correo = correo;
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
        valido = automataEmail();
        return valido;
    }
    
    public boolean automataEmail(){
        char caracter,verificador;
        for (int i = inicioCadena; i < lexema.length(); i++) {
            caracter = lexema.charAt(i);
            if (Character.isLetterOrDigit(caracter) && estado == 0) {
                estado = 1;
                estadoAcepta=true;
            }else{
                if (Character.isLetterOrDigit(caracter)&& estado == 1) {
                    estado = 1;
                    estadoAcepta=true;
                }else if(caracter == '.'){
                    
                    int index = lexema.length();
                    if (i+1 >= index) {
                        estadoAcepta=false;
                        posLectura[0] = i;
                        break;
                    }else{
                        verificador = lexema.charAt(i+1);
                        if (Character.isLetter(verificador)) {
                            estado = 1;
                            estadoAcepta=true;
                        }else{
                            estadoAcepta=false;
                            posLectura[0] = i+1;
                            break;
                        }
                    }
                }else if(caracter == '@'){
                    
                    int index = lexema.length();
                    if (i+1 >= index) {
                        estadoAcepta=false;
                        posLectura[0] = i;
                        break;
                    }else{
                        verificador = lexema.charAt(i+1);
                        if (Character.isLetter(verificador)) {
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
        return String.valueOf(lexema.charAt(posLectura[0]));
    }
    
}
