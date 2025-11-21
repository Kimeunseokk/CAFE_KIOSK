package org.example.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public String inputMenuName(){
        System.out.print("주문할 메뉴를 입력해주세요 > ");
        return scanner.nextLine().trim();
    }

    public String inputMenuQuantity(){
        System.out.print("수량을 입력해주세요 > ");
        return scanner.nextLine().trim();
    }

    public String inputOrderKind(){
        System.out.print("[포장] [매장] > ");
        return scanner.nextLine();
    }

    public String inputMenu(){
        System.out.print("\n1. 주문 2. 장바구니 3. 주문종료 4. 관리자모드 > ");
        return scanner.nextLine();
    }

    public String inputClientMenu(){
        System.out.print("관리자 모드 목록 : 1. 삭제  2. 수정 3. 모드 종료 > ");
        return scanner.nextLine();
    }

    public String inpurtClientDeleteMenu(){
        System.out.print("삭제할 주문본호를 입력해주세요 > ");
        return scanner.nextLine().trim();
    }

}
