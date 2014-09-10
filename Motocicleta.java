public class Motocicleta extends Vehicul{
    public Motocicleta(String serie, Tip tip){
        this.serie = serie;
        this.tip = tip;
    }
    public String toString(){
        return "Motocicleta: " + this.serie + " " + this.tip;
    }
}
