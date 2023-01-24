package menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ReferralService service = new ReferralService();
        Terminal terminal = new Terminal();
        terminal.serviceStart();

        ArrayList<Coach> coaches = new ArrayList<>();

        try {
            List<String> coachNames = terminal.makeCoaches();
            for (String coachName : coachNames) {
                List<String> dislikes = terminal.makeDislikes(coachName);
                coaches.add(new Coach(coachName, service, dislikes));
            }

            terminal.printDayAndCategories(service);

            for (Coach coach : coaches) {
                terminal.printEachFood(coach, coach.callReferralService());
            }
            terminal.finishService();

        } catch (IllegalArgumentException e1) {
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.out.println("[ERROR] 입력 오류 발생");
        }

    }
}
