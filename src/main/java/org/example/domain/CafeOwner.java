package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class CafeOwner {
    private final List<Order> owner;

    public CafeOwner(){
        this.owner = new ArrayList<>();
    }

    public CafeOwner(List<Order> owner){
        this.owner = owner;
    }

    public void addOwner(Order order){
        owner.add(order);
    }

    public boolean hasOrders(){
       return !owner.isEmpty();
    }

    public List<Order> getClientMenuList(){ return owner; }

}
