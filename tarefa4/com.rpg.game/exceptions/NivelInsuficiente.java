package exceptions;

public class NivelInsuficiente extends Exception{
    public NivelInsuficiente(){
        super("Heroi nao possui nivel suficiente par equipar nova arma\n");
    }
    public String getMensagem() {
        return super.getMessage();
    }
}   
