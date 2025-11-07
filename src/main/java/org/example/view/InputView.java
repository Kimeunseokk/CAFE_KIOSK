package org.example.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public String inputMenuName(){
        System.out.println("주문할 메뉴를 입력해주세요 > ");
        return scanner.nextLine();
    }

}
