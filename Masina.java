public class Masina extends Vehicul{
    public Masina(String serie, Tip tip){
        this.serie = serie;
        this.tip = tip;
    }
    public String toString(){
        return "Masina: " + this.serie + " " + this.tip;
    }
}
