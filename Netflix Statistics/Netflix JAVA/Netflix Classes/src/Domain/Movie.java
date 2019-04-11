package Domain;

public class Movie  {
    private int MovieID;
    private String MovieTitle;
    private int Length;
    private String Genre;
    private String Language;
    private int AgeIndication;
    private int ProgramID;

    public Movie(String MovieTitle,  int Length, String genre, String Language, int AgeIndication) {

        //this.MovieID = MovieID;
        this.MovieTitle = MovieTitle;
        this.Length = Length;
        this.Genre = genre;
        this.Language = Language;
        this.AgeIndication = AgeIndication;
        //this.ProgramID = programmaID1;
    }

    public int getMovieID() {
        return MovieID;
    }


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


    public int getProgramID() {
        return ProgramID;
    }
}
