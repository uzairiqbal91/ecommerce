package comtestinna.example.manew1.newecommerceapp;

import java.util.ArrayList;

/**
 * Created by deepshikha on 12/7/17.
 */

public class Model_country {
    String str_country;
    ArrayList<Model_Dish> al_state;
    public Model_country() {
    }



    public Model_country(String str_country, ArrayList<Model_Dish> al_state) {
        this.str_country = str_country;
        this.al_state = al_state;
    }


    public String getStr_country() {
        return str_country;
    }

    public void setStr_country(String str_country) {
        this.str_country = str_country;
    }

    public ArrayList<Model_Dish> getAl_state() {
        return al_state;
    }

    public void setAl_state(ArrayList<Model_Dish> al_state) {
        this.al_state = al_state;
    }
}
