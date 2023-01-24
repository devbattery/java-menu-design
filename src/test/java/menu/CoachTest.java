package menu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CoachTest {

    @Test
    void testCallReferralService() {
        ReferralService service = new ReferralService();
        Coach coach = new Coach("sully", service, Arrays.asList("fksdaj"));
        System.out.println(service.getDayOfCategory());
        System.out.println(coach.callReferralService());
    }

}