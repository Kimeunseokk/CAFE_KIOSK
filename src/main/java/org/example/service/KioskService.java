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

    public void getOrderList(){
        for(Order order : orderlist.getOrderList()){
            System.out.print("주문내역 :" + order.getMenu() + "\n총 금액 : " + order.getTotalPrice() + "\n");
        }
    }

}
