import java.io.*;

public class Program{
    static Vehicul[] vehicule = new Vehicul[10];//am setat default maximum 10 vehicule
    static int i=0;//cate vehicule exista efectiv
    public static void main(String[] args){
        try{
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            String comanda = null;
            while(true){
                System.out.print("Comanda: ");
                comanda = consola.readLine();
                String[] c = comanda.split("\\s+");
                switch(c[0]){
                    case "exit":
                        System.out.println("  Aplicatie intrerupta!");
                        System.exit(0);
                    case "adaugavehicul":
                        System.out.print("  Tip vehicul: masina: 1, motocicleta: 2, bicicleta: 3? ");
                        int t = Integer.parseInt(consola.readLine());
                        if(t!=1 && t!=2 && t!=3){
                            System.out.println("  Tip vehicul invalid!");
                            break;
                        }
                        System.out.print("  Serie: ");
                        String serie = consola.readLine();;
                        Tip tip = Tip.NONE;
                        if(t == 1 || t == 2){
                            try{
                                System.out.print("  Tip combustibil: ");
                                tip = citireTipCon(consola.readLine());
                                if(t == 1){
                                    adaugaVehicul(new Masina(serie,tip));
                                    System.out.println("  Masina adaugata!");
                                }else{
                                    adaugaVehicul(new Motocicleta(serie,tip));
                                    System.out.println("  Motocicleta adaugata!");
                                }
                            }catch(Exception e){
                                e.printStackTrace();
                                System.out.println("  Tip conbustibil invalid!\n  Vehicul neadaugat!");
                            }
                        }else if(t == 3){
                            System.out.println("  Tip combustibil: none");
                            adaugaVehicul(new Bicicleta(serie,tip));
                            System.out.println("  Bicicleta adaugata!");
                        }else{
                            
                        }
                    break;
                    case "stergevehicul":
                        System.out.print("  Serie: ");
                        stergeVehicul(consola.readLine());
                    break;
                    case "afisaza":
                        afisare();
                    break;
                    case "salveaza":
                        salvare();
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void adaugaVehicul(Vehicul v){
        if(i < vehicule.length){
            vehicule[i++] = v;
        }else{
            System.out.println("  Vectorul de vehicule este plin!");
        }
    }
    
    public static Tip citireTipCon(String tipCon) throws NotValidTypeException{
        if(tipCon.equals("diesel")){
            return Tip.DIESEL;
        }else if(tipCon.equals("benzina")){
            return Tip.BENZINA;
        }else{
            throw new NotValidTypeException();
        }
    
    }
    
    public static void stergeVehicul(String serie){
         for(int j=0; j<i; j++){
            if(vehicule[j].serie.equals(serie)){
                for(int k=j; k<i-1; k++){
                    vehicule[k] = vehicule[k+1];
                }
                vehicule[i-1] = null;
                i--;
                break;
            }
        }
    }
    
    public static void afisare(){
        System.out.println("--------------------------------");
         for(int j=0; j<i; j++){
             System.out.println("  " + vehicule[j]);
        }
        System.out.println("--------------------------------");
    }
    
    public static void salvare(){
        try{
            PrintStream out = new PrintStream("DateVehicule.txt");
            for(int j=0; j<i; j++)
                out.println(vehicule[j]);
            System.out.println("  Date salvate in DateVehicule.txt!");
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
