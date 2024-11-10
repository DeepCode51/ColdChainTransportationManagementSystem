package com.se.domain;

public class Paths {
    private int id;
    private String path;
    private String path_start;
    private String path_end;
    private String path_way;
    private double path_money;

    public Paths() {
    }

    public Paths(int id, String path, String path_start, String path_end, String path_way, double path_money) {
        this.id = id;
        this.path = path;
        this.path_start = path_start;
        this.path_end = path_end;
        this.path_way = path_way;
        this.path_money = path_money;
    }

    @Override
    public String toString() {
        return "Paths{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", path_start='" + path_start + '\'' +
                ", path_end='" + path_end + '\'' +
                ", path_way='" + path_way + '\'' +
                ", path_money='" + path_money + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath_start() {
        return path_start;
    }

    public void setPath_start(String path_start) {
        this.path_start = path_start;
    }

    public String getPath_end() {
        return path_end;
    }

    public void setPath_end(String path_end) {
        this.path_end = path_end;
    }

    public String getPath_way() {
        return path_way;
    }

    public void setPath_way(String path_way) {
        this.path_way = path_way;
    }

    public double getPath_money() {
        return path_money;
    }

    public void setPath_money(double path_money) {
        this.path_money = path_money;
    }
}
