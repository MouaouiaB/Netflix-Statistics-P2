package Domain;

public class Program {
    private int ProgramId;
    private String accountName;
    private String profileName;
    private String title;
    private String EpisodeTitle;
    private int precentage;

    public Program( String profileName, String Title, int precentage) {
        this.accountName = accountName;
        this.profileName = profileName;
        this.title = Title;
        this.precentage = precentage;
    }
    public Program( String profileName, String Title, String EpisodeTitel, int precentage) {
        this.accountName = accountName;
        this.profileName = profileName;
        this.title = Title;
        this.EpisodeTitle = EpisodeTitel;
        this.precentage = precentage;
    }



    public int getProgramId() {
        return ProgramId;
    }

    public void setProgramId(int programId) {
        ProgramId = programId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisodeTitle() {
        return EpisodeTitle;
    }

    public void setEpisodeTitle(String episodeTitle) {
        EpisodeTitle = episodeTitle;
    }

    public int getPrecentage() {
        return precentage;
    }

    public void setPrecentage(int precentage) {
        this.precentage = precentage;
    }
}
