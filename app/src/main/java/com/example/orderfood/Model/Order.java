package com.example.orderfood.Model;

import java.util.Map;

public class Order {
    int id;
    Table table;
    Map<Food, Integer> itemOrder;
    float price;
    String date;

    public Order(int id, Table table, Map<Food, Integer> itemOrder, float price, String date) {
        this.id = id;
        this.table = table;
        this.itemOrder = itemOrder;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Map<Food, Integer> getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Map<Food, Integer> itemOrder) {
        this.itemOrder = itemOrder;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
