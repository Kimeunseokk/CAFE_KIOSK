package org.example.domain;

public class Order {
    private final Menu menu;
    private final int quatity; // 주문수량

    Order(Menu menu, int quatity){
        this.menu = menu;
        this.quatity = quatity;
    }

    public Menu getMenu() { return menu; }
    public int getQuntity() { return quatity; }

    public int getTotalPrice() { return menu.getPrice() * quatity; }
}
