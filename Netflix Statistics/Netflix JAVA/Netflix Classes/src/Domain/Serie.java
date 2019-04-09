package Domain;

public class Serie extends Program {
    private String SerieTitle;
    private int ProgramID;
    private String genre;
    private String Language;
    private int Seasons;
    private int AgeIndication;
    private String LooksLike;

    public Serie(int ProgramID, String SerieTitle, String serieTitle, String genre, String Language, int Seasons, int AgeIndication, String LooksLike) {
        super(ProgramID, SerieTitle);
        this.genre = genre;
        this.Language = Language;
        this.Seasons = Seasons;
        this.AgeIndication = AgeIndication;
        this.LooksLike = LooksLike;
    }

    @Override
    public String getMovieTitle() {
        return SerieTitle;
    }

    @Override
    public int getProgramID() {
        return ProgramID;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return Language;
    }

    public int getSeasons() {
        return Seasons;
    }

    public int getAgeIndication() {
        return AgeIndication;
    }

    public String getLooksLike() {
        return LooksLike;
    }
}
