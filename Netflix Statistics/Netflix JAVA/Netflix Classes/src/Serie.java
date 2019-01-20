public class Serie extends Programma {
    private String title;
    private int programmaID;
    private String genre;
    private String taal;
    private int seizoen;
    private int leeftijdsIndicatie;
    private String lijktop;

    public Serie(int programmaID, String title, String serieTitle, String genre, String taal, int seizoen, int leeftijdsIndicatie, String lijktop) {
        super(programmaID, title);
        this.genre = genre;
        this.taal = taal;
        this.seizoen = seizoen;
        this.leeftijdsIndicatie = leeftijdsIndicatie;
        this.lijktop = lijktop;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getProgrammaID() {
        return programmaID;
    }

    public String getGenre() {
        return genre;
    }

    public String getTaal() {
        return taal;
    }

    public int getSeizoen() {
        return seizoen;
    }

    public int getLeeftijdsIndicatie() {
        return leeftijdsIndicatie;
    }

    public String getLijktop() {
        return lijktop;
    }
}
