package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.domain.CafeOwner;
import org.example.domain.Menu;
import org.example.domain.Order;
import org.example.domain.OrderList;
import org.example.repository.FileOrderListReposiotry;
import org.example.repository.OrderRepository;
import org.example.view.InputView;
import org.example.view.OutputView;

public class KioskService {

    private final OrderList orderlist =  new OrderList();
    private final CafeOwner owner = new CafeOwner();
    private final OutputView outputView;
    private final OrderRepository orderRepository;

     public KioskService(OutputView outputView) {
        this.outputView = outputView;
        this.orderRepository = new FileOrderListReposiotry();
    }

    public void orderMenu(String name, int quantity){
        Menu.checkContainsMenu(name);
    
        Order.checkQuantity(quantity);

        Menu menu = Menu.findByName(name);
        Order order = new Order(menu, quantity);

        orderlist.add(order);
        // orderlist.add(order);
        // owner.addOwner(order);
        
        // orderRepository.save(orderlist);

    }

    public void getOrderList(){
        int total = 0;
        for(Order order : orderlist.getOrderList()){
            outputView.printOrderList(order);
            total += order.getTotalPrice();
        }
        outputView.printToTalPrice(total);
    }

    public void setMenuList(){
        orderRepository.save(orderlist);
        orderlist.getOrderList().clear();
    }

    public void getClientList(){
        List<OrderList> allOrders = orderRepository.loadAll();
        if (allOrders.isEmpty()) {
            System.out.println("등록된 주문 내역이 없습니다.");
            return;
        }

        outputView.printClientOrderList(allOrders);

        // outputView.printClientNumber(orderlist);
        // outputView.printClientList(owner.getClientMenuList());
    }

}
