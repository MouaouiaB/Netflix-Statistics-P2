package Domain;

import java.util.Date;

public class Profile  {
    private int ProfileId;
    private String ProfileName;
    private int Age;
    private String name;

    public Profile(String profileName, String name, int Age) {

        this.ProfileName = profileName;
        this.Age = Age;
        this.name = name;

    }

    public int getProfileId() {
        return ProfileId;
    }

    public void setProfileId(int profileId) {
        ProfileId = profileId;
    }

    public String getProfileName() {
        return ProfileName;
    }

    public void setProfileName(String profileName) {
        ProfileName = profileName;
    }

    public int getBirthDate() {
        return Age;
    }

    public void setBirthDate(int Age) {
        this.Age = Age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
