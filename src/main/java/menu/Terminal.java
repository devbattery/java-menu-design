package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Terminal {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void serviceStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public List<String> makeCoaches() throws IOException {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = br.readLine();
        String[] split = input.split(",");

        validateCoachCount(split);

        return List.of(split);
    }

    public List<String> makeDislikes(String coachName) throws IOException{
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = br.readLine();
        String[] split = input.split(",");

        return List.of(split);
    }

    public void printDayAndCategories(ReferralService referralService) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        List<Category> categories = referralService.getDayOfCategory();

        System.out.print("[ 카테고리 |");
        categories.stream()
                .map(c -> c.getCategoryName())
                .forEach(cn -> System.out.print(" " + cn + " |"));
        System.out.println("\b]");
    }

    public void printEachFood(Coach coach, List<String> food) {
        System.out.print("[ " + coach.getName() + " |");

        food.stream()
                .forEach(f -> System.out.print(" " + f + " |"));

        System.out.print("\b]");
    }

    private static void validateCoachCount(String[] split) {
        if (split.length < 2 || split.length > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명 까지 허용됩니다.");
        }
    }

}
