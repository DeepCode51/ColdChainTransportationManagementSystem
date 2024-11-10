package com.se.domain;


public class Orders {
    private String id;
    private Users users;
    private String consignee;
    private String con_address;
    private String con_phone;
    private String time;
    private String type;
    private double weight;
    private double ord_money;
    private String ord_state;

    public Orders(String id, Users users, String consignee, String con_address, String con_phone, String time, String type, double weight, double ord_money, String ord_state) {
        this.id = id;
        this.users = users;
        this.consignee = consignee;
        this.con_address = con_address;
        this.con_phone = con_phone;
        this.time = time;
        this.type = type;
        this.weight = weight;
        this.ord_money = ord_money;
        this.ord_state = ord_state;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", users=" + users +
                ", consignee='" + consignee + '\'' +
                ", con_address='" + con_address + '\'' +
                ", con_phone='" + con_phone + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", ord_money=" + ord_money +
                ", ord_state='" + ord_state + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getCon_address() {
        return con_address;
    }

    public void setCon_address(String con_address) {
        this.con_address = con_address;
    }

    public String getCon_phone() {
        return con_phone;
    }

    public void setCon_phone(String con_phone) {
        this.con_phone = con_phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getOrd_money() {
        return ord_money;
    }

    public void setOrd_money(double ord_money) {
        this.ord_money = ord_money;
    }

    public String getOrd_state() {
        return ord_state;
    }

    public void setOrd_state(String ord_state) {
        this.ord_state = ord_state;
    }
}
