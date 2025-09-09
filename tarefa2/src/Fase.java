public class Fase {
    private int nivel;
    private String ambiente;
    private String[] monstros;

    public Fase(int nivel, String ambiente, String[] monstros){
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.monstros = new String[50];
    }


    public String getAmbiente() {
        return ambiente;
    }
    public String[] getMonstros() {
        return monstros;
    }
    public int getNivel() {
        return nivel;
    }
}
