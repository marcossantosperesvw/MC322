package exceptions;

public abstract class Exception {
    private String mensagem;
    public Exception(String mensagem){
        this.mensagem = mensagem;
    }
    public String getMensagem() {
        return mensagem;
    }
}
