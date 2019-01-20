public class Film extends Programma {
    private int filmID;
    private String title;
    private int tijdsduur;
    private String genre;
    private String taal;
    private int leeftijdsIndicatie;
    private int programmaID;

    public Film(int programmaID, String title, int filmID, String title1, int tijdsduur, String genre, String taal, int leeftijdsIndicatie, int programmaID1) {
        super(programmaID, title);
        this.filmID = filmID;
        this.title = title1;
        this.tijdsduur = tijdsduur;
        this.genre = genre;
        this.taal = taal;
        this.leeftijdsIndicatie = leeftijdsIndicatie;
        this.programmaID = programmaID1;
    }

    public int getFilmID() {
        return filmID;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getTijdsduur() {
        return tijdsduur;
    }

    public String getGenre() {
        return genre;
    }

    public String getTaal() {
        return taal;
    }

    public int getLeeftijdsIndicatie() {
        return leeftijdsIndicatie;
    }

    @Override
    public int getProgrammaID() {
        return programmaID;
    }
}
