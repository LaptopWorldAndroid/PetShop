package com.example.petshop.Class;

import java.io.Serializable;

public class Product implements Serializable {
    private String idProduct;
    private String nameProduct;
    private String description;
    private String imgUrl;
    private float stock;
    private float unitPrice;

    private String count;


    public Product() {}


    public Product(int ic_bone, String s, int i) {

    }

    public Product(String idProduct, String nameProduct, String description, String imgUrl, float stock, float unitPrice) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.imgUrl = imgUrl;
        this.stock = stock;
        this.unitPrice = unitPrice;
    }

    public Product(String idProduct, String nameProduct, String description, String imgUrl, float stock, float unitPrice,String count) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.imgUrl = imgUrl;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.count = count;
    }


    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}