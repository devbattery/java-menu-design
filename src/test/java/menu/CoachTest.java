package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;

class CoachTest {
    @Test
    void testCallReferralService() {
        ReferralService service = new ReferralService();
        Coach coach = new Coach("sully", service, Arrays.asList("쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        System.out.println(service.getDayOfCategory());
        System.out.println(coach.callReferralService());
    }

    @Test
    void 이름_오류_테스트() {
        Assertions.assertThatThrownBy(() -> new Coach("sully", new ReferralService(), List.of("","")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치 이름은 2글자 이상, 4글자 이하여야 합니다.");
    }

    @Test
    void 음식_오류_테스트() {
        Assertions.assertThatThrownBy(() -> new Coach("sull", new ReferralService(), List.of("","","")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 싫어하는 음식은 0개 이상, 2개 이하여야 합니다.");
    }
}