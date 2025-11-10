package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private final List<Order> orderlist;

    public OrderList(){
        this.orderlist= new ArrayList<>();
    }

    public OrderList(List<Order> orderlist){
        this.orderlist = orderlist;
    }

    public void add(Order order){
        orderlist.add(order);
    }

    public List<Order> getOrderList(){ return orderlist; } 
   
}

