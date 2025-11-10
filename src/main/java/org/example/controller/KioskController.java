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
        this.kioskService = new KioskService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
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
                    //kioskService.option2();
                    break;
                
            }
        }
    }

}
