package org.example.controller;

import org.example.domain.Order;
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
        this.kioskService = new KioskService(outputView);
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
        kioskService.getOrderList();
    }

    public void option3(){
        kioskService.setMenuList();
    }

    public void option4(){
        kioskService.getClientList();
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
