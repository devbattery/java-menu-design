package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class ReferralServiceTest {

    @Test
    void 코치_서비스호출() {
        ReferralService service = new ReferralService();
        Coach coach = new Coach("hyun", service, Arrays.asList("foo"));

        assertThat(coach.callReferralService()).isEqualTo("Coach 가 메뉴 추천을 요구하였습니다.");
    }

    @Test
    void 카테고리_추천() {
        ReferralService service = new ReferralService();

        System.out.println(service.getDayOfCategory());
    }

}