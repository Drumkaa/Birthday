package fr.epsi;

public class ServiceSouhaitAnniversaire {

    public ServiceSouhaitAnniversaire(EnvoyeurDeMail envoyeurDeMail, EntrepôtEnployé entrepôtEnployé) {
        this.envoyeurDeMail = envoyeurDeMail;
        this.entrepôtEnployé = entrepôtEnployé;
    }

    public void souhaiteAnniversaire() {
        for (Employé employé :entrepôtEnployé.tous()) {
            envoyeurDeMail.envoi();
        }
    }

    private EnvoyeurDeMail envoyeurDeMail;
    private EntrepôtEnployé entrepôtEnployé;
}
