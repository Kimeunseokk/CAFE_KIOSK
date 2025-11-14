package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private static long sequenece = 1L;
    private final List<Order> orderlist;
    private final long number;

    public OrderList(){
        this.number = sequenece++;
        this.orderlist= new ArrayList<>();
    }

    public OrderList(List<Order> orderlist){
        this.number = sequenece++;
        this.orderlist = orderlist;
    }

    public void add(Order order){
        orderlist.add(order);
    }

    public long getNumber() { return number; }

    public List<Order> getOrderList(){ return orderlist; } 
   
}

