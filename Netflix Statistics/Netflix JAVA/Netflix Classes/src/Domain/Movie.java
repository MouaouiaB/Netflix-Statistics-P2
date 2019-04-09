package Domain;

public class Movie extends Program {
    private int MovieID;
    private String MovieTitle;
    private int Length;
    private String Genre;
    private String Language;
    private int AgeIndication;
    private int ProgramID;

    public Movie(int ProgramID, String MovieTitle, int MovieID, String title1, int Length, String genre, String Language, int AgeIndication, int programmaID1) {
        super(ProgramID, MovieTitle);
        this.MovieID = MovieID;
        this.MovieTitle = title1;
        this.Length = Length;
        this.Genre = genre;
        this.Language = Language;
        this.AgeIndication = AgeIndication;
        this.ProgramID = programmaID1;
    }

    public int getMovieID() {
        return MovieID;
    }

    @Override
    public String getMovieTitle() {
        return MovieTitle;
    }

    public int getLength() {
        return Length;
    }

    public String getGenre() {
        return Genre;
    }

    public String getLanguage() {
        return Language;
    }

    public int getAgeIndication() {
        return AgeIndication;
    }

    @Override
    public int getProgramID() {
        return ProgramID;
    }
}
