package com.example.orderfood.Model;
//create by thanh tam
public class Food {
    int id;
    String name;
    int price;
    String image;

    public Food(int id, String name, int price,  String image){
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }
    public Food(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getImage() {
        return image;
    }
}
