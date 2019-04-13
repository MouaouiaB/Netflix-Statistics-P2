package Domain;

public class Serie {
    private String SerieTitle;
    private int SerieId;
    private String genre;
    private String Language;
    private int Seasons;
    private int AgeIndication;
    private String LooksLike;

    public Serie(String SerieTitle,  int Seasons, int AgeIndication, String Language, String Genre, String LooksLike) {
        this.SerieTitle = SerieTitle;
        this.genre = Genre;
        this.Language = Language;
        this.Seasons = Seasons;
        this.AgeIndication = AgeIndication;
        this.LooksLike = LooksLike;
    }

    public String getSerieTitle() {
        return SerieTitle;
    }

    public void setSerieTitle(String serieTitle) {
        SerieTitle = serieTitle;
    }

    public int getSerieId() {
        return SerieId;
    }

    public void setSerieId(int serieId) {
        SerieId = serieId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public int getSeasons() {
        return Seasons;
    }

    public void setSeasons(int seasons) {
        Seasons = seasons;
    }

    public int getAgeIndication() {
        return AgeIndication;
    }

    public void setAgeIndication(int ageIndication) {
        AgeIndication = ageIndication;
    }

    public String getLooksLike() {
        return LooksLike;
    }

    public void setLooksLike(String looksLike) {
        LooksLike = looksLike;
    }
}
