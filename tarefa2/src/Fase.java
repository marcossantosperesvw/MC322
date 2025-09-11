import jogo.*;
public class Fase {
    private int nivel;
    private String ambiente;
    private Monstro[] ListaMonstros;

    public Fase(int nivel, String ambiente, Monstro[] monstros){
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.ListaMonstros = new Monstro[50];
    }


    public String getAmbiente() {
        return ambiente;
    }
    public Monstro[] getListaMonstros() {
        return ListaMonstros;
    }
    public void setListaMonstros(Monstro[] listaMonstros) {
        ListaMonstros = listaMonstros;
    }
    public int getNivel() {
        return nivel;
    }
}
