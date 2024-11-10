package com.se.domain;

public class Logistics {
    private int id;
    private Orders orders;
    private Cars cars;
    private Paths paths;

    public Logistics(int id, Orders orders, Cars cars, Paths paths) {
        this.id = id;
        this.orders = orders;
        this.cars = cars;
        this.paths = paths;
    }

    public Logistics() {
    }

    @Override
    public String toString() {
        return "Logistics{" +
                "id=" + id +
                ", orders=" + orders +
                ", cars=" + cars +
                ", paths=" + paths +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public Paths getPaths() {
        return paths;
    }

    public void setPaths(Paths paths) {
        this.paths = paths;
    }
}
