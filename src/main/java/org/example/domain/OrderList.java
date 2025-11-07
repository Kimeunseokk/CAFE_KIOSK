package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private final List<Order> orderlist;

    public OrderList(List<Order> orderlist){
        this.orderlist = orderlist;
    }

    public List<Order> getOrderList(){ return orderlist; } 
   
}

