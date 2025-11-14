package org.example.domain;

public class Order {
    private static long sequenece = 1L;

    private final Menu menu;
    private final int quantity; // 주문수량
    private final long number; // 주문번호

    public Order(Menu menu, int quantity){
        this.menu = menu;
        this.quantity = quantity;
        this.number = sequenece++;
    }

    public Menu getMenu() { return menu; }
    public int getQuantity() { return quantity; }
    public long getNumber() {return number;}

    public int getTotalPrice() { return menu.getPrice() * quantity; }

    public String getName() { return menu.getName(); }

    public static void checkQuantity(int quantity){
        if(quantity < 1) throw new IllegalArgumentException("[Error] 수량이 잘못됐습니다. ");
    }
   
}
