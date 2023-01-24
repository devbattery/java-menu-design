package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TerminalTest {

    @Test
    void 코치이름입력() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("현,설리".getBytes());
        System.setIn(in);

        Terminal terminal = new Terminal();
        terminal.serviceStart();
        List<String> coaches = terminal.makeCoaches();

        assertThat(coaches).containsExactly("현", "설리");
    }

    @Test
    void 코치이름입력오류() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("현".getBytes());
        System.setIn(in);

        Terminal terminal = new Terminal();
        terminal.serviceStart();
        assertThatThrownBy(() -> terminal.makeCoaches())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 코치는 최소 2명, 최대 5명 까지 허용됩니다.");
    }

    @Test
    void 싫어하는_음식입력() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("현,설리\n우동,스시\n뇨끼,월남쌈".getBytes());
        System.setIn(in);

        Terminal terminal = new Terminal();
        List<String> coaches = terminal.makeCoaches();

        List<String> hyunDislikes = terminal.makeDislikes(coaches.get(0));
        assertThat(hyunDislikes).containsExactly("우동", "스시");

        List<String> sullyDislikes = terminal.makeDislikes(coaches.get(1));
        assertThat(sullyDislikes).containsExactly("뇨끼", "월남쌈");
    }

    @Test
    void 요일_카테고리_출력() {
        Terminal terminal = new Terminal();
        ReferralService service = new ReferralService();
        terminal.printDayAndCategories(service);
    }

    @Test
    void 음식_출력() {
        Terminal terminal = new Terminal();
        ReferralService service = new ReferralService();
        Coach coach = new Coach("hyun", service, List.of(""));
        terminal.printDayAndCategories(service);
        terminal.printEachFood(coach, coach.callReferralService());
    }
}