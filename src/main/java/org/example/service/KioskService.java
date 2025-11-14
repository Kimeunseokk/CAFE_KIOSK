package org.example.service;

import java.util.ArrayList;

import org.example.domain.CafeOwner;
import org.example.domain.Menu;
import org.example.domain.Order;
import org.example.domain.OrderList;
import org.example.view.InputView;
import org.example.view.OutputView;

public class KioskService {

    private final OrderList orderlist =  new OrderList();
    private final CafeOwner owner = new CafeOwner();
    private final OutputView outputView;

     public KioskService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void orderMenu(String name, int quantity){
        Menu.checkContainsMenu(name);
    
        Order.checkQuantity(quantity);

        Menu menu = Menu.findByName(name);
        Order order = new Order(menu, quantity);
        orderlist.add(order);
        owner.addOwner(order);
    }

    public void getOrderList(){
        int total = 0;
        for(Order order : orderlist.getOrderList()){
            outputView.printOrderList(order);
            total += order.getTotalPrice();
        }
        outputView.printToTalPrice(total);
    }

    public void getClientList(){
            if (!owner.hasOrders()) {
            System.out.println("현재 등록된 주문 내역이 없습니다.");
            return;
        }
        outputView.printClientNumber(orderlist);
        outputView.printClientList(owner.getClientMenuList());
    }

}
