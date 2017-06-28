package com.example.rijunath.json3;

/**
 * Created by RIJU NATH on 4/5/2017.
 */
public class Product_setget {
    public String Product_No;
    public String Category_Id;
    public String Item_Name;
    public String Item_Desc;
    public String Market_Price;
    public String Web_Price;
    public String Availability;
    public String Product_Image;

    public void setProduct_Id(String _val) {
        Product_No = _val;
    }

    public void setCategory_Id(String _val) {
        Category_Id = _val;
    }

    public void setItem_Name(String _val) {
        Item_Name = _val;
    }

    public void setItem_Desc(String _val) {
        Item_Desc = _val;
    }

    public void setMarket_Price(String _val) {
        Market_Price = _val;
    }

    public void setWeb_Price(String _val) {
        Web_Price = _val;
    }

    public void setAvailability(String _val) {
        Availability = _val;
    }

    public void setProduct_Image(String _val) {
        Product_Image = _val;
    }

    public String getProduct_Id() {
        return Product_No;
    }

    public String getCategory_Id() {
        return Category_Id;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public String getItem_Desc() {
        return Item_Desc;
    }

    public String getMarket_Price() {
        return Market_Price;
    }

    public String getWeb_Price() {
        return Web_Price;
    }

    public String getAvailability() {
        return Availability;
    }

    public String getProduct_Image() {
        return Product_Image;
    }
}
