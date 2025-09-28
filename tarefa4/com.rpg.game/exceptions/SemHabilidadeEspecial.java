package exceptions;

public class SemHabilidadeEspecial extends Exception{
    public SemHabilidadeEspecial(){
        super("O heroi nao pode utilizar sua habilidade especial");
    }
    public String getMensagem(){
        return getMessage();
    }
}
