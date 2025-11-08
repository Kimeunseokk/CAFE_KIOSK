package org.example.controller;

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

    public void run(){
        outputView.printStartMessage();
        String orderkind = inputView.inputOrderKind(); 
        outputView.printMenuList();
        String str = inputView.inputMenuName();
        
    }
}
