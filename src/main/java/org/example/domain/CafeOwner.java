package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class CafeOwner {
    private final List<OrderList> owner;

    public CafeOwner(){
        this.owner = new ArrayList<>();
    }

    public CafeOwner(List<OrderList> owner){
        this.owner = owner;
    }

    public void addOwner(OrderList orderlist){
        owner.add(orderlist);
    }

    public List<OrderList> getClientMenuList(){ return owner; }

}
