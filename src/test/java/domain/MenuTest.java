package domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.*;


import org.example.domain.Menu;
import org.example.domain.Order;
import org.junit.jupiter.api.Test;

class MenuTest {
    @Test
    void 메뉴판에_없는_메뉴_주문시_예외발생(){
        assertThatThrownBy(() -> Menu.checkContainsMenu("카라멜마키아또"))
        .isInstanceOf(IllegalArgumentException.class);
    }
    
}
