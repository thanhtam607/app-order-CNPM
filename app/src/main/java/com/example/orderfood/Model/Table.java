package com.example.orderfood.Model;

public class Table {
   int id;
    String status;
    String name;

    public Table(int id, String name,String status) {
        this.id = id;
        this.status = status;
        this.name = name;
    }
    public Table(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}