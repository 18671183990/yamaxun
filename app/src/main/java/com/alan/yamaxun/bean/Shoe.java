package com.alan.yamaxun.bean;

/**
 * projectName: yamaxun
 * packageName: com.alan.yamaxun.bean
 * className:   Shoe
 * author:  Alan
 * time:    2016/8/1	16:26
 * desc:    鞋子的实体类
 */
public class Shoe {
    public int productIcon;   //商品图标
    public String productIconUrl; //商品图标地址
    public String productDesc;
    public double productPrice;

    public Shoe() {
    }

    public Shoe(int productIcon, String productIconUrl, String productDesc, double productPrice) {
        this.productIcon = productIcon;
        this.productIconUrl = productIconUrl;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    public int getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(int productIcon) {
        this.productIcon = productIcon;
    }

    public String getProductIconUrl() {
        return productIconUrl;
    }

    public void setProductIconUrl(String productIconUrl) {
        this.productIconUrl = productIconUrl;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
