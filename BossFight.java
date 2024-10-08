public class BossFight {
    Boss bossKalameetBossDrago = new Boss();
    Boss bossGwynLordOfCinderBossGuerriero = new Boss();
    Mappa mappaCastelloDiDragleic = new Mappa();
    // ancora da definire la scelta della calsse del giocatore
    Classi classeScelta = new Classi();
    public boolean scontroFinito = false;
    public boolean turnoGiocatore = true;
    public boolean turnoBoss = false;

    public void BossFightKalameet(Giocatore giocatore, RandomEvent randomEvent) {
        System.out.println("Boss Fight Kalameet iniziata");
        System.out.println("Sei all'interno del castello di Drangleic");
        mappaCastelloDiDragleic.CastelloDiDragleic();

        System.out.println("Nome giocatore da definire contro Kalameet");

        bossKalameetBossDrago.ApparizioneBossKalameet();
        System.out.print(" VS ");
        if (cS == 1) {
            classeScelta.ApparizionePersonaggioMagia();
        }
        if (cS == 2) {
            classeScelta.ApparizionePersonaggioDestrezza();
        }
        if (cS == 3) {
            classeScelta.ApparizionePersonaggioForza();
        }
        System.out.println("Inizio scontro");

        while (scontroFinito) {

            if (giocatore.salute == 0 || bossKalameetBossDrago.saluteGwynLordOfCinder == 0) {
                scontroFinito = true;
            }
            if (turnoGiocatore) {
                turnoBoss = false;
                System.out.println("E' il turno del giocatore ");
                if (cS == 1) {
                    classeScelta.MosseMagia();
                }
                if (cS == 2) {
                    classeScelta.MosseDestrezza();
                }
                if (cS == 3) {
                    classeScelta.MosseForza();
                }
                turnoBoss = true;
            }
            if (turnoBoss) {
                System.out.println("E' il turno del boss");
                bossKalameetBossDrago.FunzionamentoBossKalameet();
            }
        }

    }
}