package org.example.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
    private final OrderRepository orderRepository;

     public KioskService() {
        this.orderRepository = new FileOrderListReposiotry();
    }

    // 메뉴 주문 처리 (임시 저장)
    public void orderMenu(String name, int quantity){
        Menu.checkContainsMenu(name);
    
        Order.checkQuantity(quantity);

        Menu menu = Menu.findByName(name);
        Order order = new Order(menu, quantity);

        orderlist.add(order);
    }

    // 장바구니 총액 계산
    public int getTotalPrice(){
        int total = 0;
        for(Order order : orderlist.getOrderList()){
            total+=order.getTotalPrice();
        }

        return total;
    }

    // 현재 장바구니에 담긴 내역 출력
    public List<Order> getCurrentOrder(){
        return orderlist.getOrderList();
    }

    // // 장바구니 반환 및 총액 계산
    // public void getOrderList(){
    //     int total = 0;
    //     for(Order order : orderlist.getOrderList()){
    //         outputView.printOrderList(order);
    //         total += order.getTotalPrice();
    //     }
    //     outputView.printToTalPrice(total);
    // }

    public void setMenuList(){
        if(orderlist.getOrderList().isEmpty()){
            return;
        }
        orderRepository.save(orderlist);
        orderlist.getOrderList().clear();
        // System.exit(0); service에서 시스템 종료를 좋지 않은 개발법
    }

    public List<OrderList> getClientList(){
        List<OrderList> allOrders = orderRepository.loadAll();
        return allOrders;
        // outputView.printClientNumber(orderlist);
        // outputView.printClientList(owner.getClientMenuList());
    }

    public void deleteMenuList(int num){
        orderRepository.deleteByNum(num);       
    }

    public void switchMenuList(int num, String menuName, String quantity){
        String newMenuName = menuName.isBlank() ? null : menuName;

        Integer newQuantity = null;
        if(!quantity.isBlank()){
            newQuantity = Integer.parseInt(quantity);
        }

        orderRepository.switchByNum(num, newMenuName, newQuantity);
    }

}
