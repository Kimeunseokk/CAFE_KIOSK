package org.example.service;

import java.util.ArrayList;

import org.example.domain.Menu;
import org.example.domain.Order;
import org.example.domain.OrderList;
import org.example.view.InputView;
import org.example.view.OutputView;

public class KioskService {

    private final OrderList orderlist =  new OrderList();

    public void orderMenu(String name, int quantity){
        Menu.checkContainsMenu(name);
    
        Order.checkQuantity(quantity);

        Menu menu = Menu.findByName(name);
        orderlist.add(new Order(menu,quantity));
    }

}
