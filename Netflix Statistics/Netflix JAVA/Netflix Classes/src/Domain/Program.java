package Domain;

public class Program {
    private int ProgramID;
    private String title;

    public Program(int ProgramID, String title) {
        this.ProgramID = ProgramID;
        this.title = title;
    }

    public int getProgramID() {
        return ProgramID;
    }

    public String getMovieTitle() {
        return title;
    }
}
