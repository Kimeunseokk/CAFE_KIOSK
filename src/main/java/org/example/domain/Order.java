package org.example.domain;

public class Order {
    private final Menu menu;
    private final int quantity; // 주문수량

    Order(Menu menu, int quantity){
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() { return menu; }
    public int getQuantity() { return quantity; }

    public int getTotalPrice() { return menu.getPrice() * quantity; }

    public static void checkQuantity(int quantity){
        if(quantity < 1) throw new IllegalArgumentException("수량이 잘못됐습니다. ");
    }
   
}
