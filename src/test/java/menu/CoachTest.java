package menu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CoachTest {

    @Test
    void testCallReferralService() {
        ReferralService service = new ReferralService();
        Coach coach = new Coach("sully", service, Arrays.asList("쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        System.out.println(service.getDayOfCategory());
        System.out.println(coach.callReferralService());
    }

}