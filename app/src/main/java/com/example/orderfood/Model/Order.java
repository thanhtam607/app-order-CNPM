package com.example.orderfood.Model;

import java.util.List;
import java.util.Map;

public class Order {
    int id;
    int table;
   List<OrderDetail> itemOrder;
    float price;


    public Order(int id, int table, List<OrderDetail> itemOrder, float price) {
        this.id = id;
        this.table = table;
        this.itemOrder = itemOrder;
        this.price = price;

    }
    public Order(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public List<OrderDetail> getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(List<OrderDetail> itemOrder) {
        this.itemOrder = itemOrder;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
