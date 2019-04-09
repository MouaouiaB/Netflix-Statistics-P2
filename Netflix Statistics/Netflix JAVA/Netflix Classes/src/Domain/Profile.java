package Domain;

public class Profile extends Account {
    private String ProfileName;
    private int Age;
    private int AccountId;

    public Profile(int AccountId, String abonneeNaam, String email, String wachtwoord, String straat, int huisnummer, String postcode, String abonneeWoonplaats, String ProfileName, int Age) {
        super( abonneeNaam, email, wachtwoord, straat, huisnummer, postcode, abonneeWoonplaats);
        this.ProfileName = ProfileName;
        this.Age = Age;
    }

    public String getProfileName() {
        return ProfileName;
    }

    public boolean geboortedatumChecker(String geboortedatum){
        if (geboortedatum.matches("\t\n" + "^(([1-9])|(0[1-9])|(1[0-2]))\\/((0[1-9])|([1-31]))\\/((\\d{2})|(\\d{4}))$") ){
            return true;
        }else{
            return false;
        }
    }
    public int getAge() {
        return Age;
    }

    @Override
    public int getAccountId() {
        return AccountId;
    }
}
