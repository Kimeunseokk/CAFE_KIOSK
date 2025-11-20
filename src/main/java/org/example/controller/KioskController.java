package org.example.controller;

import java.util.List;

import org.example.domain.Order;
import org.example.domain.OrderList;
import org.example.service.KioskService;
import org.example.view.InputView;
import org.example.view.OutputView;


public class KioskController {

    private final KioskService kioskService;
    private final InputView inputView;
    private final OutputView outputView;


    public KioskController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.kioskService = new KioskService();
    }

    public void option1(){
        while(true){
            try {
                String str = inputView.inputMenuName();
                String quantity = inputView.inputMenuQuantity();

                int num = Integer.parseInt(quantity);
                kioskService.orderMenu(str,num);
                break;

            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void option2(){
        List<Order> currentlist = kioskService.getCurrentOrder();
        outputView.printorderlist(currentlist, kioskService.getTotalPrice());
    }

    public void option3(){
        kioskService.setMenuList();
        System.exit(0);
    }

    public void option4(){
        List<OrderList> client = kioskService.getClientList();
        outputView.printClientOrderList(client);
        while(true){
            String str = inputView.inputClientMenu(); // 관리자모드 종류 입력받기
            switch(str){
                case "1":
                    break;

                case "2":
                    break;

                case "3":
                    return;

            }
        }
    }

    public void run(){
        outputView.printStartMessage();
        String orderkind = inputView.inputOrderKind(); 
        outputView.printMenuList();

        while(true){
            String option = inputView.inputMenu(); 
            switch(option){
                case "1":
                    option1();
                    break;
                case "2":
                    option2();
                    break;
                case "3":
                    option3();
                    break;
                case "4":
                    option4();
                    break;
            }
        }
    }

}
