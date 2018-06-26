package comtestinna.example.manew1.newecommerceapp;

import android.util.Size;

/**
 * Created by Aws on 28/01/2018.
 */

public class Book {

    private String Title;
    private String Price ;
    private String Description ;
    private int Thumbnail ;
    private String Size;
    private String qty;

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public Book() {
    }

    public Book(String title, String price, String description, int thumbnail) {
        Title = title;
        Price = price;
        Description = description;
        Thumbnail = thumbnail;
    }

    public Book(String title, String price, String description, int thumbnail,String size,String Qty) {
        Title = title;
        Price = price;
        Size=size;
        Description = description;
        Thumbnail = thumbnail;
        qty=Qty;
    }

    public String getTitle() {
        return Title;
    }

    public String getPrice() {
        return Price;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }


    public String getSize(){return Size ;}

    public void setTitle(String title) {
        Title = title;
    }


    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
    public void setPrice(String price) {
        Price = price;
    }

    public void setSize(String size){Size=size;}

}
