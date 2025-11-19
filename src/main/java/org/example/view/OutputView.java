package org.example.view;

import java.util.List;

import org.example.domain.CafeOwner;
import org.example.domain.Menu;
import org.example.domain.Order;
import org.example.domain.OrderList;

public class OutputView {

    public void printStartMessage() {
        System.out.println("=== 카페에 오신 것을 환영합니다 ===");
    }

    // ✅ 메뉴 전체 출력 메서드 추가
    public void printMenuList() {
        System.out.println("\n📋 메뉴 목록");
        System.out.println("--------------------");

        for (Menu menu : Menu.values()) {
            System.out.printf("%-15s : %d원%n", menu.getName(), menu.getPrice());
        }

        System.out.println("--------------------\n");
    }

    public void printOrderSuccess(String menuName, int price) {
        System.out.println(menuName + " 주문 완료! (" + price + "원)");
    }

    public void printOrderFail() {
        System.out.println("존재하지 않는 메뉴입니다.");
    }

    public void printErrorMessage(String message){
        System.out.println(message);
    }

    public void printOrderList(Order order){
        System.out.print("주문내역 : " + order.getName()+ "\t\t금액 : " + order.getTotalPrice()+" (원)");
        System.out.println();
    }

    public void printorderlist(List<Order> order, int total){
        System.out.print("=== 주문 내역 ===");
        for(Order o : order){
            System.out.print("\n"+o.getName() + " "+ o.getQuantity()+ "개  (" + o.getTotalPrice() + "원)");
        }
        System.out.println("\n총 금액 : " +total+" (원)");
    }

    // public void printToTalPrice(int total){
    //     System.out.println("총 금액 : " +total+" (원)");
    // }

    public void printClientList(List<Order> orders) {
        System.out.println("\n=== 주문 내역 ===");
        for (Order order : orders) {
            System.out.println(order.getMenu().getName() + " " 
                + order.getQuantity() + "개 (₩" + order.getTotalPrice() + ")");
        }
        System.out.println("=================\n");
    }

    public void printClientNumber(OrderList orderlist){
        System.out.print("주문번호 "+ orderlist.getNumber());
    }

     public void printClientOrderList(List<OrderList> allOrders) {
        int orderNumber = 1; // 출력용 번호
        for (OrderList orderList : allOrders) {
            System.out.println("주문번호 : " + orderNumber++);
            for (Order order : orderList.getOrderList()) {
                System.out.println(" - " + order.getName() + " : " + order.getQuantity() + "개");
            }
            System.out.println("-----");
        }
    }

    public void printNoClientOrders() {
        System.out.println("등록된 주문 내역이 없습니다.");
    }

    public void printNotImplemented() {
        System.out.println("아직 구현되지 않은 기능입니다.");
    }

}
