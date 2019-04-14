package Domain;

public class Episode {
    private int EpisodeID;
    private String SerieName;
    private String Title;
    private int SerieId;
    private String SeasonAndEpisode;
    private int Lengthe;

    public Episode(String SerieName,  String title, String SeasonAndEpisode, int Lengthe) {

        this.SerieName = SerieName;
        this.Title = title;
        this.SeasonAndEpisode = SeasonAndEpisode;
        this.Lengthe = Lengthe;
    }

    public int getEpisodeID() {
        return EpisodeID;
    }

    public void setEpisodeID(int episodeID) {
        EpisodeID = episodeID;
    }

    public String getSerieName() {
        return SerieName;
    }

    public void setSerieName(String serieName) {
        SerieName = serieName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getSerieId() {
        return SerieId;
    }

    public void setSerieId(int serieId) {
        SerieId = serieId;
    }

    public String getSeasonAndEpisode() {
        return SeasonAndEpisode;
    }

    public void setSeasonAndEpisode(String seasonAndEpisode) {
        SeasonAndEpisode = seasonAndEpisode;
    }

    public int getLengthe() {
        return Lengthe;
    }

    public void setLengthe(int lengthe) {
        Lengthe = lengthe;
    }
}

