package org.example.repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.example.domain.Order;
import org.example.domain.OrderList;

public interface OrderRepository {
    public void save(OrderList orderlist);
    List<OrderList> loadAll();
    public void deleteByNum(int orderid);
}
    

