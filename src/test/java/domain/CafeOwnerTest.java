package domain;

import org.example.domain.CafeOwner;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CafeOwnerTest {
 
    @Test
    void 카페주인_리스트_생성확인(){
        CafeOwner owenr = new CafeOwner();
        assertThat(owenr.getClientMenuList().isEmpty());
    }
}

