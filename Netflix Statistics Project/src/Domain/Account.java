package Domain;

public class Account {
    private int AccountID;
    private String AccountName;
    private String FullName;
    private String Email;
    private String Password;
    private String Street;
    private String HouseNumber;
    private String ZipCode;
    private String City;

    public Account(String AccountName, String fullName, String Email, String Password, String Street, String HouseNumber, String ZipCode, String City) {
        this.AccountName = AccountName;
        this.FullName = fullName;
        this.Email = Email;
        this.Password = Password;
        this.Street = Street;
        this.HouseNumber = HouseNumber;
        this.ZipCode = ZipCode;
        this.City = City;
    }

    public String getFullName() {
        return FullName;
    }

    public int getAccountId() {
        return this.AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public String getAccountName() {
        return AccountName;
    }

    // regular expression
    public boolean emailChecker(String Email){
        if (Email.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){
            return true;
        }else {
            return false;
        }
    }
    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getStreet() {
        return Street;
    }

    public String getHouseNumber() {
        return HouseNumber;
    }

    // regular expression
    public boolean postcodeChecker(String ZipCode){
        if (ZipCode.matches("[0-9]{4}\\s*[a-zA-Z]{2}")){
            return true;
        }else{
            return false;
        }
    }
    public String getZipCode() {
        return ZipCode;
    }

    public String getCity() {
        return City;
    }

}
