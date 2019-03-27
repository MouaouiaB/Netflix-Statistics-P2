package Domain;

import Domain.Abonnement;

public class Profile extends Abonnement {
    private String profileNaam;
    private String geboortedatum;
    private int abonneeID;

    public Profile(int abonneeID, String abonneeNaam, String email, String wachtwoord, String straat, int huisnummer, String postcode, String abonneeWoonplaats, String profileNaam, String geboortedatum) {
        super(abonneeID, abonneeNaam, email, wachtwoord, straat, huisnummer, postcode, abonneeWoonplaats);
        this.profileNaam = profileNaam;
        this.geboortedatum = geboortedatum;
    }

    public String getProfileNaam() {
        return profileNaam;
    }

    public boolean geboortedatumChecker(String geboortedatum){
        if (geboortedatum.matches("\t\n" + "^(([1-9])|(0[1-9])|(1[0-2]))\\/((0[1-9])|([1-31]))\\/((\\d{2})|(\\d{4}))$") ){
            return true;
        }else{
            return false;
        }
    }
    public String getGeboortedatum() {
        return geboortedatum;
    }

    @Override
    public int getAbonneeID() {
        return abonneeID;
    }
}
