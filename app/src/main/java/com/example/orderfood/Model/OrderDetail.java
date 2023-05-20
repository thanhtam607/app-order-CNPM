package com.example.orderfood.Model;

public class OrderDetail {
    int foodId;
    int quantity;

    public OrderDetail(int foodId, int quantity) {
        this.foodId = foodId;
        this.quantity = quantity;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
