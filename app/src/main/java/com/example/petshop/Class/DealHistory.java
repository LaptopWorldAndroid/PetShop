package com.example.petshop.Class;

public class DealHistory {
    private String name;
    private int amount;
    private double totalMoney;
    private double price;

    public DealHistory(String name, int amount , double totalMoney , double  price){
        this.name = name;
        this.amount = amount;
        this.totalMoney = totalMoney;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public double getTotalMoney() {
        return totalMoney;
    }
    public void setTotalMoney(double totalMoney)
    {
        this.totalMoney = totalMoney;
    }

    public double gerPrice() {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }}
