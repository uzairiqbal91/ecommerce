package comtestinna.example.manew1.newecommerceapp;

public class UserDetail {

    private String name="None";
    private String phoneNum="None" ;
    private String City="None" ;



    private String Country="None" ;
    private int proifilePic;
    private String accountNum="None";
    private String streetAddress="None";
    private boolean checkProfileCreate=false;
    private String eemail="None";

    public UserDetail(String name, String phoneNum, String city, String country, int proifilePic, String accountNum, String streetAddress,String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.City = city;
        Country = country;
        this.proifilePic = proifilePic;
        this.accountNum = accountNum;
        this.streetAddress = streetAddress;
        this.eemail=email;
    }

    public UserDetail()
    {

    }

    public UserDetail(String name, String phoneNum , String streetAddress,String email) {
        this.name = name;
        this.phoneNum = phoneNum;



        this.streetAddress = streetAddress;
        this.eemail=email;
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

    public String getEemail() {
        return eemail;
    }

    public void setEemail(String eemail) {
        this.eemail = eemail;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCheckProfileCreate(boolean checkProfileCreate) {
        this.checkProfileCreate = checkProfileCreate;
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

    public boolean getCheckProfileCreate(){return checkProfileCreate;}




}
