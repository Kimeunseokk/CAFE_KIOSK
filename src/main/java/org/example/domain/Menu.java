package org.example.domain;

public enum Menu {
    
    ICEAMERICANO("아이스아메리카노", 3500),
    LATTE("라떼", 4500);

    private final String name;
    private final int price;

    Menu(String name , int price){
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }

    public static void checkContainsMenu(String name){
        if(name == null || name.trim().isEmpty()) throw new IllegalArgumentException("[Error] 메뉴를 입력해주세요. ");
        for(Menu menu : values()){
            if(menu.getName().equals(name)) return;
        }
        throw new IllegalArgumentException("[Error] 메뉴판에 없는 메뉴입니다. ");
    }

    public static Menu findByName(String name) {
        for (Menu menu : values()) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }
        throw new IllegalArgumentException("[Error] 메뉴판에 없는 메뉴입니다.");
    }

}
