public class Bicicleta extends Vehicul{
    public Bicicleta(String serie, Tip tip){
        this.serie = serie;
        this.tip = tip;
    }
    public String toString(){
        return "Bicicleta: " + this.serie + " " + this.tip;
    }
}
