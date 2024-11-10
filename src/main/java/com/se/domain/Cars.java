package com.se.domain;

public class Cars {
    private int id;
    private String car_num;
    private double max_weight;
    private String car_state;

    public Cars(int id, String car_num, double max_weight, String car_state) {
        this.id = id;
        this.car_num = car_num;
        this.max_weight = max_weight;
        this.car_state = car_state;
    }

    public Cars() {
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", car_num='" + car_num + '\'' +
                ", max_weight=" + max_weight +
                ", car_state='" + car_state + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
    }

    public double getMax_weight() {
        return max_weight;
    }

    public void setMax_weight(double max_weight) {
        this.max_weight = max_weight;
    }

    public String getCar_state() {
        return car_state;
    }

    public void setCar_state(String car_state) {
        this.car_state = car_state;
    }
}
