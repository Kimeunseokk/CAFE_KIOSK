package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.domain.Menu;
import org.example.domain.Order;
import org.example.domain.OrderList;
import org.junit.jupiter.api.Test;

public class OrderListTest {
    @Test
    void 올바른_주문내역_출력하기(){
        OrderList orderlist = new OrderList();
        Order order = new Order(Menu.LATTE,3);
        Order order2 = new Order(Menu.ICEAMERICANO, 3);

        orderlist.add(order);
        orderlist.add(order2);
        assertThat(orderlist.getOrderList()).contains(order,order2);
    }

    @Test
    void 주문하기전에_리스트가_비어있는걸_확인한다(){
        OrderList orderlist = new OrderList();
        assertThat(orderlist.getOrderList().isEmpty());
    }
}
