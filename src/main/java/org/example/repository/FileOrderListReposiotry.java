package org.example.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.example.domain.Menu;
import org.example.domain.Order;
import org.example.domain.OrderList;

public class FileOrderListReposiotry implements OrderRepository{
    private static final String FILE_PATH = "/Users/rpqhfls2whdkgmail.com/Documents/vscode/KiSOK/orders.txt";

    // 파일에서 다음 주문번호 계산 (파일용)
    private int getNextOrderNumber() {
        int maxNumber = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("주문번호")) {
                    try {
                        int num = Integer.parseInt(line.split(":")[1].trim());
                        if (num > maxNumber) maxNumber = num;
                    } catch (NumberFormatException ignored) {}
                }
            }
        } catch (Exception ignored) {}
        return maxNumber + 1;
    }

    @Override
    public void save(OrderList orderlist){
        int nextNumber = getNextOrderNumber();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH,true))) {
            bw.write("주문번호 : "+ nextNumber);
            bw.newLine();

            for(Order order : orderlist.getOrderList()){
                bw.write(order.getName() + "," + order.getQuantity());
                bw.newLine();
            }

            bw.write("//");
            bw.newLine();
        } catch (Exception e) {
            throw new RuntimeException("파일 저장 실패");
        }
    }

    public List<OrderList> loadAll() {
        List<OrderList> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            OrderList current = null;
            List<Order> tempOrders = null;
            long currentNumber = 0;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("주문번호")) {
                    currentNumber = Long.parseLong(line.split(":")[1].trim());
                    tempOrders = new ArrayList<>();
                } else if (line.equals("//")) {
                    if (tempOrders != null) {
                        result.add(new OrderList(tempOrders));
                        tempOrders = null;
                    }
                } else {
                    try {
                        String[] parts = line.split(",");
                        String menuName = parts[0];
                        int qity = Integer.parseInt(parts[1].trim());

                        Menu menu = Menu.findByName(menuName);
                        tempOrders.add(new Order(menu, qity));
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.err.println("경고: 주문 데이터 변환 오류: " + line);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("파일 읽기 실패", e);
        }

        return result;
    }
    
} 
