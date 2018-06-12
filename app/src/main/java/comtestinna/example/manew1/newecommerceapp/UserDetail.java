package comtestinna.example.manew1.newecommerceapp;

public class UserDetail {

    private String name;
    private String phoneNum ;
    private String City ;



    private String Country ;
    private int proifilePic;
    private String accountNum;
    private String streetAddress;

    public UserDetail(String name, String phoneNum, String city, String country, int proifilePic, String accountNum, String streetAddress) {
        this.name = name;
        this.phoneNum = phoneNum;
        City = city;
        Country = country;
        this.proifilePic = proifilePic;
        this.accountNum = accountNum;
        this.streetAddress = streetAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setProifilePic(int proifilePic) {
        this.proifilePic = proifilePic;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getCity() {
        return City;
    }

    public String getCountry() {
        return Country;
    }

    public int getProifilePic() {
        return proifilePic;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getStreetAddress() {
        return streetAddress;
    }
}
