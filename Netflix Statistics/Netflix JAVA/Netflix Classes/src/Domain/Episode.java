package Domain;

public class Episode extends Program {
    private int EpisodeID;
    private String SerieName;
    private String Title;
    private int ProgramID;
    private String SeasonAndEpisode;
    private double Lengthe;

    public Episode(int ProgramID, String title, int EpisodeID, String SerieName, String title1, int programID1, String SeasonAndEpisode, double Lengthe) {
        super(ProgramID, title);
        this.EpisodeID = EpisodeID;
        this.SerieName = SerieName;
        this.SeasonAndEpisode = SeasonAndEpisode;
        this.Lengthe = Lengthe;
    }

    public int getEpisodeID() {
        return EpisodeID;
    }

    public String getSerieName() {
        return SerieName;
    }

    @Override
    public String getMovieTitle() {
        return Title;
    }

    @Override
    public int getProgramID() {
        return ProgramID;
    }

    public String getSeasonAndEpisode() {
        return SeasonAndEpisode;
    }

    public double getLengthe() {
        return Lengthe;
    }
}

