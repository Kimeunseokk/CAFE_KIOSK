package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import org.example.domain.Menu;
import org.example.domain.Order;

class OrderTest {
    @Test
    void 기준보다_더작은_숫자가_입력됐을때_예외처리(){
       assertThatThrownBy(() -> Order.checkQuantity(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_총금엑_계산한다(){
        Order order = new Order(Menu.LATTE,2);
        assertThat(order.getTotalPrice()).isEqualTo(9000);
    }
}
