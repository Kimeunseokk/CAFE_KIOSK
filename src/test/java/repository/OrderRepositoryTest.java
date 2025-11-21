package repository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.example.domain.Order;
import org.example.repository.FileOrderListReposiotry;
import org.example.repository.OrderRepository;
import org.junit.jupiter.api.Test;

public class OrderRepositoryTest {
   @Test
    void 범위_밖의_번호_입력시_예외처리() {
        OrderRepository orderRepository = new FileOrderListReposiotry();

        // 예: 존재하지 않는 주문번호 999
        assertThatThrownBy(() -> orderRepository.deleteByNum(999))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("존재하지 않는 주문번호");
    }
}
