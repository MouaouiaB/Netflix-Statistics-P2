public class Abonnement {
    private int abonneeID;
    private String abonneeNaam;
    private String email;
    private String wachtwoord;
    private String straat;
    private int huisnummer;
    private String postcode;
    private String abonneeWoonplaats;

    public Abonnement(int abonneeID, String abonneeNaam, String email, String wachtwoord, String straat, int huisnummer, String postcode, String abonneeWoonplaats) {
        this.abonneeID = abonneeID;
        this.abonneeNaam = abonneeNaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.abonneeWoonplaats = abonneeWoonplaats;
    }

    public int getAbonneeID() {
        return this.abonneeID;
    }

    public String getAbonneeNaam() {
        return abonneeNaam;
    }

    // regular expression
    public boolean emailChecker(String email){
        if (email.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){
            return true;
        }else {
            return false;
        }
    }
    public String getEmail() {
        return email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public String getStraat() {
        return straat;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    // regular expression
    public boolean postcodeChecker(String postcode){
        if (postcode.matches("[0-9]{4}\\s*[a-zA-Z]{2}")){
            return true;
        }else{
            return false;
        }
    }
    public String getPostcode() {
        return postcode;
    }

    public String getAbonneeWoonplaats() {
        return abonneeWoonplaats;
    }
}
