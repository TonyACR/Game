import java.util.Scanner;
import java.util.Random;

public class RandomEvent {
    Random random = new Random();
    public int ciboconservato;
    public int borracciariempita;
    Scanner scanner = new Scanner(System.in);
    Boss bossuno = new Boss();
    public String bossGuerrieroPuntoMappa = "Castello di Drangleic";
    Mappa mappaCastello = new Mappa();
    Classi classi = new Classi();
    public int cS;

    public void CasualEvent(Giocatore giocatore) {
        int evento = random.nextInt(4);
        int eventoanimaleselvatico = random.nextInt(8);
        int eventospeciale = random.nextInt(400000);
        int eventoCastelloDiDrangleic = random.nextInt(15);

        if (evento == 1) {
            System.out.println(
                    "Hai trovato del cibo! Sei stato fortunato. Vuoi mangiarlo subito oppure conservartelo ? ");
            String man = scanner.nextLine();

            if (man.equals("mangiare")) {
                System.out.println("Il giocatore sta mangiando....");
                giocatore.azionitot++;
                giocatore.mangia++;
                System.out.println("Energia ripristinata");
                giocatore.energia = 100;
            } else if (man.equals("conservarlo")) {
                System.out.println("Stai conservando il cibo....");
                ciboconservato++;
                System.out.println("Cibo conservato.");
            }
            if (evento == 2) {
                System.out.println(
                        "Hai trovato una fonte d'acqua! Sei stato fortunato. Vuoi bere subito oppure riempire la tua borraccia ? ");
                String bev = scanner.nextLine();
                if (bev.equals("bere")) {
                    System.out.println("Il giocatore sta bevendo....");
                    giocatore.azionitot++;
                    giocatore.beve++;
                    System.out.println("Acqua ripristinata");
                    giocatore.acqua = 100;
                } else if (bev.equals("riempire la borraccia")) {
                    System.out.println("Il giocatore sta riempiendo la borraccia");
                    giocatore.borraccia += 10;
                    // borracciariempita++;
                    System.out.println("Borraccia riempita.");
                }
                if (evento == 3) {
                    System.out.println(
                            "Hai incontrato un animale selvatico. Puoi scegliere se combattere o scappare (scappare costa energia, combattere può costare salute).");
                    String animale = scanner.nextLine();
                    if (animale.equals("combattere")) {
                        System.out.println("Il giocatore sta combattendo");
                        if (eventoanimaleselvatico == 2 || eventoanimaleselvatico == 4 || eventoanimaleselvatico == 6
                                || eventoanimaleselvatico == 8) {
                            System.out.println("Il giocatore ha vinto lo scontro");
                        } else if (eventoanimaleselvatico == 1 || eventoanimaleselvatico == 3
                                || eventoanimaleselvatico == 5 || eventoanimaleselvatico == 7) {
                            System.out.println(
                                    "Il giocatore ha perso lo scontro ma è riuscito a salvarsi ed a scappare, questo pero' gli ha consumato sia energie che salute");
                            giocatore.energia -= 20;
                            giocatore.salute -= 20;
                        }

                    }
                }
                if (evento == 4) {
                    System.out.println(
                            "Una pioggia torrenziale si è abbattuta sulla foresta. Tutte le risorse si ridurranno");
                    giocatore.energia -= 10;
                    giocatore.salute -= 10;
                    giocatore.acqua -= 10;
                }
                if (eventospeciale == 21000) {
                    System.out.println("Hai trovato una caverna... Chissà cosa si cela dentro essa");
                    System.out.println("Vuoi entrare dentro la caverna ? ");
                    String caverna = scanner.nextLine();
                    if (caverna.equals("si")) {
                        System.out.println(
                                "Sei entrato nella caverna ma noti un vecchio anziano con un bastone ad osservare una parete con un anello raffigurato");
                        System.out.println(
                                "Il vecchio esclama 'chissà chi sarà il prossimo lord ancestrale'. Dopo aver udito queste parole, il nostro protagonista sviene.....");
                        System.out.println("Ciao ragazzo, scegli una classe per la tua avventura");
                        System.out.println("Classi disponibili 3: Classe magia, Classe destrezza, classe forza");
                        String sceltaClasse = scanner.nextLine();
                        if (sceltaClasse.equals("Classe Magia")) {
                            classi.ClasseMagia();
                            cS = 1;
                        }
                        if (sceltaClasse.equals("Classe destrezza")) {
                            classi.ClasseDestrezza();
                            cS = 2;
                        }
                        if (sceltaClasse.equals("Classe Forza")) {
                            classi.ClasseForza();
                            cS = 3;
                        }
                    }
                }
                if (eventoCastelloDiDrangleic == 12) {
                    System.out.println("Hai trovato il Castello Di Drangleic, vuoi entrarci ? ");
                    String entrare = scanner.nextLine();
                    if (entrare.equals("si")) {
                        System.out.println("Sei entrato nel castello di Dragleic");
                        mappaCastello.mappaCastelloDiDrangleic();
                    }
                }

            }
        }
    }
}