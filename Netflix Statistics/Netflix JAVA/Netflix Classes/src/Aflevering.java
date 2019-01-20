public class Aflevering extends Programma {
    private int afleveringID;
    private String serieNaam;
    private String title;
    private int programmaID;
    private String seizoenEnAflevering;
    private double tijdsduur;

    public Aflevering(int programmaID, String title, int afleveringID, String serieNaam, String title1, int programmaID1, String seizoenEnAflevering, double tijdsduur) {
        super(programmaID, title);
        this.afleveringID = afleveringID;
        this.serieNaam = serieNaam;
        this.seizoenEnAflevering = seizoenEnAflevering;
        this.tijdsduur = tijdsduur;
    }

    public int getAfleveringID() {
        return afleveringID;
    }

    public String getSerieNaam() {
        return serieNaam;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getProgrammaID() {
        return programmaID;
    }

    public String getSeizoenEnAflevering() {
        return seizoenEnAflevering;
    }

    public double getTijdsduur() {
        return tijdsduur;
    }
}

