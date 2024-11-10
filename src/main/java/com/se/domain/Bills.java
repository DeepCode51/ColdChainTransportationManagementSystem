package com.se.domain;

public class Bills {
    private String date;//年月日字符串
    private double income;//收入
    private double expend;//支出

    @Override
    public String toString() {
        return "Bills{" +
                "date='" + date + '\'' +
                ", income=" + income +
                ", expend=" + expend +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpend() {
        return expend;
    }

    public void setExpend(double expend) {
        this.expend = expend;
    }

    public Bills() {
    }

    public Bills(String date, double income, double expend) {
        this.date = date;
        this.income = income;
        this.expend = expend;
    }
}
