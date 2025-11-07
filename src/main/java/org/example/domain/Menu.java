package org.example.domain;

public enum Menu {
    
    ICEAMERICANO("아이스아메리카노", 3500),
    LATTE("라뗴", 4500);

    private final String name;
    private final int price;

    Menu(String name , int price){
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
}
