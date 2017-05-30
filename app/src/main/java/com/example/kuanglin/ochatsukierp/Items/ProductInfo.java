package com.example.kuanglin.ochatsukierp.Items;

import java.io.Serializable;

/**
 * Created by KuangLin on 2017/3/19.
 */

public class ProductInfo implements Serializable{
    private String name;
    private Specification specification;
    private int amount;
    private int price;

    public void setValue(String name, Specification specification, int amount, int price){
        this.name = name;
        this.specification = specification;
        this.amount = amount;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public Specification getSpec(){
        return specification;
    }

    public int getAmount(){
        return amount;
    }

    public int getPrice(){
        return price;
    }
}
