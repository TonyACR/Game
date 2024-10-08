import java.util.Scanner;
import java.util.Random;

// un turno è formato da 7 azioni, ogni 4 azioni il giorno finisce e il turno finisce

public class Giocatore {
    Scanner scanner = new Scanner(System.in);
    public int energia;
    public int acqua;
    public int salute;
    public int azionitot = 0;
    public int beve;
    public int mangia;
    public int giorniPassati = 0;
    public int vitatotale = 0;
    public boolean morto = false;
    public int borraccia = 100;
    public int saccaDiCibo = 100;

    public Giocatore(int energia, int acqua, int salute) {
        this.energia = energia;
        this.acqua = acqua;
        this.salute = salute;
    }

    /*
     * Ogni turno rappresenta un giorno. Alla fine di ogni giorno:
     * 
     * L'energia diminuisce di 10.
     * L'acqua diminuisce di 10.
     * Se l'energia o l'acqua scendono sotto i 20, la salute diminuisce di 10.
     */

    public void Azioni() {
        System.out.println("Che azione vuoi fare ?");
        String domanda = scanner.nextLine();
        System.out.println(domanda);

        if (domanda.equals("camminare") || domanda.equals("Camminare")) {
            System.out.println("Sto camminando....");
            azionitot++;

        }
        if (domanda.equals("correre") || domanda.equals("Correre")) {
            System.out.println("Sto correndo....");
            azionitot++;
        }
        if (domanda.equals("combattere") || domanda.equals("Combattere")) {
            System.out.println("Sto combattendo....");
            azionitot++;
        }
        if (domanda.equals("bere") || domanda.equals("Bere")) {
            if (borraccia > 0) {
                System.out.println("Il giocatore sta bevendo....");
                azionitot++;
                beve++;
                borraccia -= 10;
                System.out.println("Acqua ripristinata");
                acqua = 100;
                System.out.println("La borraccia adesso contiene " + borraccia + " % di acqua");
            }
        }
        if (domanda.equals("mangiare") || domanda.equals("Mangiare")) {
            if (saccaDiCibo > 0) {
                System.out.println("Il giocatore sta mangiando....");
                azionitot++;
                mangia++;
                saccaDiCibo -= 10;
                System.out.println("Energia ripristinata");
                energia = 100;
                System.out.println("La sacca di cibo adesso contiene " + saccaDiCibo + " % di cibo");
            }
        }
        vitatotale = energia + acqua + salute;
        System.out.println("Vita totale:" + vitatotale);
        // System.out.println(azionitot);
    }

    public boolean isGiocofinito() {
        return morto;
    }

    public void Turno() {

        if (azionitot == 7) {
            azionitot = 0;
            // System.out.println("è passato un giorno");
            giorniPassati++;
            System.out.println("Fine giornata");
            System.out.println("Giorni passati: " + giorniPassati);
            energia -= 10;
            acqua -= 10;
            System.out.println("Percentuale di cibo totale in possesso: " + saccaDiCibo);
            System.out.println("Percentuale di acqua totale in possesso: " + borraccia);
            if (energia < 20 || acqua < 20) {
                salute -= 10;
            }
            System.out
                    .println("Energia attuale: " + energia + " Acqua attuale: " + acqua + " Salute totale: " + salute);
        }
    }

    public void GiocoFinito() {
        if (energia == 0 || acqua == 0 || salute == 0) {
            morto = true;
            System.out.println("Game over. Sei morto");
        }

    }
}
