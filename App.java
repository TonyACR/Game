import java.util.Scanner;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean passato = true;
        int contgior = 0;
        int loopinfinito = 0;
        int inizioevento = 0;

        Giocatore Cristian = new Giocatore(100, 100, 100);
        RandomEvent casuale = new RandomEvent();

        System.out.println("INIZIO GIOCO");

        while (!Cristian.isGiocofinito()) {
            Cristian.Azioni();
            Cristian.Turno();
            if (inizioevento == 4 || inizioevento == 2 || inizioevento == 6) {
                casuale.CasualEvent(Cristian);
            }
            inizioevento++;
            Cristian.GiocoFinito();
        }
    }

}
